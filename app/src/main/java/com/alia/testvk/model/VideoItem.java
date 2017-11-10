
package com.alia.testvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoItem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("photo_130")
    @Expose
    private String photo130;
    @SerializedName("photo_320")
    @Expose
    private String photo320;
    @SerializedName("photo_640")
    @Expose
    private String photo640;
    @SerializedName("access_key")
    @Expose
    private String accessKey;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("can_add")
    @Expose
    private Integer canAdd;
    @SerializedName("can_comment")
    @Expose
    private Integer canComment;
    @SerializedName("can_repost")
    @Expose
    private Integer canRepost;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("photo_800")
    @Expose
    private String photo800;
    @SerializedName("first_frame_320")
    @Expose
    private String firstFrame320;
    @SerializedName("first_frame_160")
    @Expose
    private String firstFrame160;
    @SerializedName("first_frame_130")
    @Expose
    private String firstFrame130;
    @SerializedName("first_frame_800")
    @Expose
    private String firstFrame800;
    @SerializedName("content_restricted")
    @Expose
    private Integer contentRestricted;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("repeat")
    @Expose
    private Integer repeat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    public String getPhoto320() {
        return photo320;
    }

    public void setPhoto320(String photo320) {
        this.photo320 = photo320;
    }

    public String getPhoto640() {
        return photo640;
    }

    public void setPhoto640(String photo640) {
        this.photo640 = photo640;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Integer canAdd) {
        this.canAdd = canAdd;
    }

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }

    public Integer getCanRepost() {
        return canRepost;
    }

    public void setCanRepost(Integer canRepost) {
        this.canRepost = canRepost;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPhoto800() {
        return photo800;
    }

    public void setPhoto800(String photo800) {
        this.photo800 = photo800;
    }

    public String getFirstFrame320() {
        return firstFrame320;
    }

    public void setFirstFrame320(String firstFrame320) {
        this.firstFrame320 = firstFrame320;
    }

    public String getFirstFrame160() {
        return firstFrame160;
    }

    public void setFirstFrame160(String firstFrame160) {
        this.firstFrame160 = firstFrame160;
    }

    public String getFirstFrame130() {
        return firstFrame130;
    }

    public void setFirstFrame130(String firstFrame130) {
        this.firstFrame130 = firstFrame130;
    }

    public String getFirstFrame800() {
        return firstFrame800;
    }

    public void setFirstFrame800(String firstFrame800) {
        this.firstFrame800 = firstFrame800;
    }

    public Integer getContentRestricted() {
        return contentRestricted;
    }

    public void setContentRestricted(Integer contentRestricted) {
        this.contentRestricted = contentRestricted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public String getCombId() {
        return ownerId + "_" + id + "_" + accessKey;
    }

}
