package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("text")
    private String text;

    @SerializedName("created_at")
    private String createdAt;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
