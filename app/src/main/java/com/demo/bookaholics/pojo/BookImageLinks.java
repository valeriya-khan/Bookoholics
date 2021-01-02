package com.demo.bookaholics.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    private String smallThumbnail;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getBookImageSmallThumbnail() {
        return smallThumbnail;
    }

    public void setBookImageSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getBookImageThumbnail() {
        return thumbnail;
    }

    public void setBookImageThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
