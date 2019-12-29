package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class OfficeSuccessResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private InformationAboutUser data;

    public String getStatus() {
        return status;
    }

    public InformationAboutUser getData() {
        return data;
    }
}
