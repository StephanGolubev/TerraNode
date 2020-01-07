package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class DetailMessageWithTwoErrorsResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("error")
    private TwoErrorsResponse error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TwoErrorsResponse getError() {
        return error;
    }

    public void setError(TwoErrorsResponse error) {
        this.error = error;
    }
}
