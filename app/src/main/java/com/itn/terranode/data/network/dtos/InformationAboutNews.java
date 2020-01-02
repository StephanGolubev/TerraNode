package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InformationAboutNews {
    @SerializedName("current_page")
    private String currentPage;

    @SerializedName("data")
    private List<NewsItem> newsItems = new ArrayList<>();

    @SerializedName("first_page_url")
    private String first_page_url;

    @SerializedName("from")
    private String from;

    @SerializedName("last_page")
    private String last_page;

    @SerializedName("last_page_url")
    private String last_page_url;

    @SerializedName("next_page_url")
    private String next_page_url;

    @SerializedName("path")
    private String path;

    @SerializedName("per_page")
    private String per_page;

    @SerializedName("prev_page_url")
    private String prev_page_url;

    @SerializedName("to")
    private String to;

    @SerializedName("total")
    private String total;

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public void addNewsItems(NewsItem newsItem) {
        this.newsItems.add(newsItem);
    }
}
