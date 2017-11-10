package com.alia.testvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alyona on 10.11.2017.
 */

public class Response {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    @SerializedName("next_from")
    @Expose
    private String nextFrom;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNextFrom() {
        return nextFrom;
    }

    public void setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
    }

}
