
package com.alia.testvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source_id")
    @Expose
    private Integer sourceId;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("video")
    @Expose
    private VideoList video;

    @SerializedName("player")
    @Expose
    private String player;

    public String getPlayer() {
        return player;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public VideoList getVideo() {
        return video;
    }


}
