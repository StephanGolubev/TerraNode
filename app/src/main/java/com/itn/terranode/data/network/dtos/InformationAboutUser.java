package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class InformationAboutUser {

    @SerializedName("id")
    private String id;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("photo")
    private String photo;

    @SerializedName("sponsor_id")
    private String sponsorId;

    @SerializedName("level_info")
    private LevelInfo levelInfo;

    @SerializedName("balance")
    private Balance balance;

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

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setSponsorId(String sponsorId) {
        this.sponsorId = sponsorId;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
