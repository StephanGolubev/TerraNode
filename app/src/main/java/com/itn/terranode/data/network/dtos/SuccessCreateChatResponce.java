package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class SuccessCreateChatResponce {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private String data;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
