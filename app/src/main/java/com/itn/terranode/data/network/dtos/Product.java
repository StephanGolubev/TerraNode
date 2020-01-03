package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("description_en")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("text_en")
    private String text;

    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private String price;

    @SerializedName("min_dep")
    private String max_dep;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getMax_dep() {
        return max_dep;
    }

    public String getUrl() {
        return url;
    }
}
