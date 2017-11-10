
package com.alia.testvk.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoList {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("items")
    @Expose
    private List<VideoItem> videoItems;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<VideoItem> getVideoItems() {
        if (videoItems == null){
            return new ArrayList<>();
        }
        return videoItems;
    }

    public void setVideoItems(List<VideoItem> items) {
        this.videoItems = items;
    }

}
