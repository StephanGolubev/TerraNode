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
    private String firstPageUrl;

    @SerializedName("from")
    private int from;

    @SerializedName("last_page")
    private int lastPage;

    @SerializedName("last_page_url")
    private String lastPageUrl;

    @SerializedName("next_page_url")
    private String nextPageUrl;

    @SerializedName("path")
    private String path;

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("prev_page_url")
    private String prevPageUrl;

    @SerializedName("to")
    private int to;

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

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public int getPerPage() {
        return perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public int getTotal() {
        return total;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
