package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;
}
