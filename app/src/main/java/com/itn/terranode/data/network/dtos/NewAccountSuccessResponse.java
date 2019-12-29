package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class NewAccountSuccessResponse {

    @SerializedName("status")
    String status;

    @SerializedName("data")
    NewAccountData data;
}
