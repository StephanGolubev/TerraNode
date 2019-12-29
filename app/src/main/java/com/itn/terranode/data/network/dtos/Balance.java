package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class Balance {

    @SerializedName("cash")
    private String cash;

    @SerializedName("partner")
    private String partner;

    @SerializedName("transfer")
    private String transfer;

    @SerializedName("nod")
    private String nod;

    public String getCash() {
        return cash;
    }

    public String getPartner() {
        return partner;
    }

    public String getTransfer() {
        return transfer;
    }

    public String getNod() {
        return nod;
    }
}
