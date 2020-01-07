package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class TwoErrorsResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private Message message;

    public String getCode() {
        return code;
    }

    public Message getMessage() {
        return message;
    }
}
