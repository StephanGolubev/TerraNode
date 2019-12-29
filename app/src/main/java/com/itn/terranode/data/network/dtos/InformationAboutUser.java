package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class InformationAboutUser {

    @SerializedName("id")
    String id;

    @SerializedName("email")
    String email;

    @SerializedName("name")
    String name;

    @SerializedName("photo")
    String photo;

    @SerializedName("sponsor_id")
    String sponsorId;

    @SerializedName("level_info")
    LevelInfo levelInfo;

    @SerializedName("balance")
    Balance balance;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSponsorId() {
        return sponsorId;
    }

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public Balance getBalance() {
        return balance;
    }
}
