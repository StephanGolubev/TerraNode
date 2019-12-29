package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class OfficeSuccessResponse {

    @SerializedName("status")
    String status;

    @SerializedName("data")
    InformationAboutUser data;
}
