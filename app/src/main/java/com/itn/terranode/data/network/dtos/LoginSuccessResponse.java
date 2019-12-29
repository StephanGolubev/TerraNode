package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class LoginSuccessResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private LoginData data;

    public String getStatus() {
        return status;
    }

    public LoginData getData() {
        return data;
    }
}
