package org.wso2.carbon.apimgt.rest.api.store.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * CommentDTO
 */
public class CommentDTO   {
  @JsonProperty("commentId")
  private String commentId = null;

  @JsonProperty("apiId")
  private String apiId = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("commentText")
  private String commentText = null;

  @JsonProperty("createdTime")
  private String createdTime = null;

  @JsonProperty("createdBy")
  private String createdBy = null;

  @JsonProperty("lastUpdatedTime")
  private String lastUpdatedTime = null;

  @JsonProperty("lastUpdatedBy")
  private String lastUpdatedBy = null;

  public CommentDTO commentId(String commentId) {
    this.commentId = commentId;
    return this;
  }

   /**
   * Get commentId
   * @return commentId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCommentId() {
    return commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public CommentDTO apiId(String apiId) {
    this.apiId = apiId;
    return this;
  }

   /**
   * Get apiId
   * @return apiId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public CommentDTO userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * If userName is not given user invoking the API will be taken as the userName. 
   * @return userName
  **/
  @ApiModelProperty(required = true, value = "If userName is not given user invoking the API will be taken as the userName. ")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public CommentDTO commentText(String commentText) {
    this.commentText = commentText;
    return this;
  }

   /**
   * Get commentText
   * @return commentText
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

  public CommentDTO createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

   /**
   * Get createdTime
   * @return createdTime
  **/
  @ApiModelProperty(example = "2017-02-20T13:57:16.229+0000", value = "")
  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public CommentDTO createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @ApiModelProperty(value = "")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public CommentDTO lastUpdatedTime(String lastUpdatedTime) {
    this.lastUpdatedTime = lastUpdatedTime;
    return this;
  }

   /**
   * Get lastUpdatedTime
   * @return lastUpdatedTime
  **/
  @ApiModelProperty(example = "2017-02-20T13:57:16.229+0000", value = "")
  public String getLastUpdatedTime() {
    return lastUpdatedTime;
  }

  public void setLastUpdatedTime(String lastUpdatedTime) {
    this.lastUpdatedTime = lastUpdatedTime;
  }

  public CommentDTO lastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

   /**
   * Get lastUpdatedBy
   * @return lastUpdatedBy
  **/
  @ApiModelProperty(value = "")
  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentDTO comment = (CommentDTO) o;
    return Objects.equals(this.commentId, comment.commentId) &&
        Objects.equals(this.apiId, comment.apiId) &&
        Objects.equals(this.userName, comment.userName) &&
        Objects.equals(this.commentText, comment.commentText) &&
        Objects.equals(this.createdTime, comment.createdTime) &&
        Objects.equals(this.createdBy, comment.createdBy) &&
        Objects.equals(this.lastUpdatedTime, comment.lastUpdatedTime) &&
        Objects.equals(this.lastUpdatedBy, comment.lastUpdatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentId, apiId, userName, commentText, createdTime, createdBy, lastUpdatedTime, lastUpdatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentDTO {\n");
    
    sb.append("    commentId: ").append(toIndentedString(commentId)).append("\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    commentText: ").append(toIndentedString(commentText)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

