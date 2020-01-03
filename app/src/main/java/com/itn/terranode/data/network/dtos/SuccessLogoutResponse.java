package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class SuccessLogoutResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private SimpleData data;
}
