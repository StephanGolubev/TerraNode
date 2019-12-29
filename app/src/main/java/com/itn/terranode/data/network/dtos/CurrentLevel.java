package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class CurrentLevel {

    @SerializedName("level")
    String level;

    @SerializedName("name")
    String name;

    @SerializedName("totalInvest")
    String totalInvest;

    @SerializedName("moneyTurnover")
    String moneyTurnover;

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getTotalInvest() {
        return totalInvest;
    }

    public String getMoneyTurnover() {
        return moneyTurnover;
    }
}
