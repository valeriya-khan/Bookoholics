package com.demo.bookaholics.pojo;

import androidx.room.TypeConverters;

import com.demo.bookaholics.converters.Converter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@TypeConverters(value = Converter.class)
public class BookVolumeInfo {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("publishedDate")
    @Expose
    private String publishedDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("industryIdentifiers")
    @Expose
    private List<BookIndustryIdentifier> industryIdentifiers = null;
    @SerializedName("printType")
    @Expose
    private String printType;
    @SerializedName("maturityRating")
    @Expose
    private String maturityRating;
    @SerializedName("allowAnonLogging")
    @Expose
    private boolean allowAnonLogging;
    @SerializedName("contentVersion")
    @Expose
    private String contentVersion;

    @SerializedName("imageLinks")
    @Expose
    private BookImageLinks imageLinks;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("previewLink")
    @Expose
    private String previewLink;
    @SerializedName("infoLink")
    @Expose
    private String infoLink;
    @SerializedName("canonicalVolumeLink")
    @Expose
    private String canonicalVolumeLink;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("pageCount")
    @Expose
    private int pageCount;
    @SerializedName("averageRating")
    @Expose
    private double averageRating;
    @SerializedName("ratingsCount")
    @Expose
    private int ratingsCount;

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public List<String> getBookAuthors() {
        return authors;
    }

    public void setBookAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getBookPublisher() {
        return publisher;
    }

    public void setBookPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookPublishedDate() {
        return publishedDate;
    }

    public void setBookPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getBookDescription() {
        return description;
    }

    public void setBookDescription(String description) {
        this.description = description;
    }

    public List<BookIndustryIdentifier> getBookIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setBookIndustryIdentifiers(List<BookIndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }



    public String getBookPrintType() {
        return printType;
    }

    public void setBookPrintType(String printType) {
        this.printType = printType;
    }

    public String getBookMaturityRating() {
        return maturityRating;
    }

    public void setBookMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getBookContentVersion() {
        return contentVersion;
    }

    public void setBookContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public BookImageLinks getBookImageLinks() {
        return imageLinks;
    }

    public void setBookImageLinks(BookImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getBookLanguage() {
        return language;
    }

    public void setBookLanguage(String language) {
        this.language = language;
    }

    public String getBookPreviewLink() {
        return previewLink;
    }

    public void setBookPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getBookInfoLink() {
        return infoLink;
    }

    public void setBookInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getBookCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setBookCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public List<String> getBookCategories() {
        return categories;
    }

    public void setBookCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getBookSubtitle() {
        return subtitle;
    }

    public void setBookSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getBookPageCount() {
        return pageCount;
    }

    public void setBookPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getBookAverageRating() {
        return averageRating;
    }

    public void setBookAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getBookRatingsCount() {
        return ratingsCount;
    }

    public void setBookRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }
}
