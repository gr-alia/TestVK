
package com.alia.testvk.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
