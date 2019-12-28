package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("error")
    private ErrorResponse error;

    @SerializedName("data")
    private String data;

}
