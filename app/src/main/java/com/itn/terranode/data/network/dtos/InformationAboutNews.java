package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InformationAboutNews {
    @SerializedName("current_page")
    private int currentPage;

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
    private int total;

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public void addNewsItems(NewsItem newsItem) {
        this.newsItems.add(newsItem);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public String getFrom() {
        return from;
    }

    public String getLast_page() {
        return last_page;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public String getPath() {
        return path;
    }

    public String getPer_page() {
        return per_page;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public String getTo() {
        return to;
    }

    public int getTotal() {
        return total;
    }
}
