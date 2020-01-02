package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class SuccessNewsResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private InformationAboutNews data;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InformationAboutNews getData() {
        return data;
    }

    public void setData(InformationAboutNews data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
