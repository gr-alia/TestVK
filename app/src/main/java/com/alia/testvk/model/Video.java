package com.alia.testvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alyona on 10.11.2017.
 */

public class Video {

    @SerializedName("player")
    @Expose
    private String player;

    public String getPlayer() {
        return player;
    }
}
