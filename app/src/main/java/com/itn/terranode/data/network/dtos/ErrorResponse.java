package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

class ErrorResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;
}
