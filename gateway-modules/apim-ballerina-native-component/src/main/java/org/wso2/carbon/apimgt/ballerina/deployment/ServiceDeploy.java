/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.apimgt.ballerina.deployment;

import org.ballerinalang.BLangProgramLoader;
import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.RuntimeEnvironment;
import org.ballerinalang.model.BLangPackage;
import org.ballerinalang.model.BLangProgram;
import org.ballerinalang.model.Service;
import org.ballerinalang.model.builder.BLangExecutionFlowBuilder;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.services.dispatchers.DispatcherRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.ballerina.util.Util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Native function org.wso2.carbon.apimgt.ballerina.deployment.ServiceDeploy.{@link ServiceDeploy}
 * This function will create ballerina file in the FS.
 *
 * @since 0.10-SNAPSHOT
 */
@BallerinaFunction(
        packageName = "org.wso2.carbon.apimgt.ballerina.deployment",
        functionName = "deployService",
        args = {@Argument(name = "fileName", type = TypeEnum.STRING),
                @Argument(name = "config", type = TypeEnum.STRING),
                @Argument(name = "path", type = TypeEnum.STRING)},
        returnType = {@ReturnType(type = TypeEnum.STRING)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description", attributes = {@Attribute(name = "value",
        value = " deployment service")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "fileName",
        value = "path to the service file")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "config",
        value = "ballerina source")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "path",
        value = "ballerina package")})
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "string",
        value = "status of the deployment")})
public class ServiceDeploy extends AbstractNativeFunction {

    private static final Logger log = LoggerFactory.getLogger(ServiceDeploy.class);
    private static Path programDirPath = Paths.get(System.getProperty("user.dir"));

    @Override
    public BValue[] execute(Context context) {
        String fileName = getArgument(context, 0).stringValue();
        String config = getArgument(context, 1).stringValue();
        String packageName = getArgument(context, 2).stringValue();

        Path path = Paths.get(packageName);
        String filePath = path.toAbsolutePath() + File.separator + fileName;
        if (Util.saveFile(filePath, config)) {
            BLangProgram bLangProgram = new BLangProgramLoader().loadService(programDirPath, path);
            BLangExecutionFlowBuilder flowBuilder = new BLangExecutionFlowBuilder();
            for (BLangPackage servicePackage : bLangProgram.getServicePackages()) {
                for (Service service : servicePackage.getServices()) {
                    service.setBLangProgram(bLangProgram);
                    DispatcherRegistry.getInstance().getServiceDispatchers().forEach((protocol, dispatcher) ->
                            dispatcher.serviceRegistered(service));
                    // Build Flow for Non-Blocking execution.
                    service.accept(flowBuilder);
                }
                RuntimeEnvironment runtimeEnv = RuntimeEnvironment.get(bLangProgram);
                bLangProgram.setRuntimeEnvironment(runtimeEnv);
            }
            log.info("write config to File system");

        } else {
            log.error("Error saving API configuration in " + path);
        }

        return new BValue[0];
    }


}

