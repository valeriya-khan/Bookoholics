package com.demo.bookaholics.pojo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.demo.bookaholics.converters.Converter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "books")
@TypeConverters(value = Converter.class)
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int uniqueId;
    @SerializedName("kind")
    @Expose
    private String bookKind;
    @SerializedName("id")
    @Expose
    private String bookId;
    @SerializedName("etag")
    @Expose
    private String bookEtag;
    @SerializedName("selfLink")
    @Expose
    private String bookSelfLink;
    @SerializedName("volumeInfo")
    @Expose
    private BookVolumeInfo bookVolumeInfo;

    public Book(int uniqueId, String bookKind, String bookId, String bookEtag, String bookSelfLink, BookVolumeInfo bookVolumeInfo) {
        this.uniqueId = uniqueId;
        this.bookKind = bookKind;
        this.bookId = bookId;
        this.bookEtag = bookEtag;
        this.bookSelfLink = bookSelfLink;
        this.bookVolumeInfo = bookVolumeInfo;
    }
    @Ignore
    public Book(String bookKind, String bookId, String bookEtag, String bookSelfLink, BookVolumeInfo bookVolumeInfo) {
        this.bookKind = bookKind;
        this.bookId = bookId;
        this.bookEtag = bookEtag;
        this.bookSelfLink = bookSelfLink;
        this.bookVolumeInfo = bookVolumeInfo;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public String getBookKind() {
        return bookKind;
    }

    public void setBookKind(String kind) {
        this.bookKind = kind;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String id) {
        this.bookId = id;
    }

    public String getBookEtag() {
        return bookEtag;
    }

    public void setBookEtag(String etag) {
        this.bookEtag = etag;
    }

    public String getBookSelfLink() {
        return bookSelfLink;
    }

    public void setBookSelfLink(String selfLink) {
        this.bookSelfLink = selfLink;
    }

    public BookVolumeInfo getBookVolumeInfo() {
        return bookVolumeInfo;
    }

    public void setBookVolumeInfo(BookVolumeInfo bookVolumeInfo) {
        this.bookVolumeInfo = bookVolumeInfo;
    }

}

