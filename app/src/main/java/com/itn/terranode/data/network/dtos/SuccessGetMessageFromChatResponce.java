package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SuccessGetMessageFromChatResponce {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private InformationAboutMessages data;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public InformationAboutMessages getData() {
        return data;
    }

    public ErrorResponse getError() {
        return error;
    }
}
