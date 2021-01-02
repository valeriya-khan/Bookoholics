package com.demo.bookaholics.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookIndustryIdentifier {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("identifier")
    @Expose
    private String identifier;

    public String getBookIdentifierType() {
        return type;
    }

    public void setBookIdentifierType(String type) {
        this.type = type;
    }

    public String getBookIdentifier() {
        return identifier;
    }

    public void setBookIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
