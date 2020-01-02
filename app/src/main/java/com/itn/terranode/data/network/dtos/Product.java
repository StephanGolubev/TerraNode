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
}
