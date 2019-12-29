package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class NextLevel {

    @SerializedName("level")
    private String level;

    @SerializedName("name")
    private String name;

    @SerializedName("bonus")
    private String bonus;

    @SerializedName("total_investment")
    private String totalInvest;

    @SerializedName("personal_turenover")
    private String moneyTurnover;

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getBonus() {
        return bonus;
    }

    public String getTotalInvest() {
        return totalInvest;
    }

    public String getMoneyTurnover() {
        return moneyTurnover;
    }
}
