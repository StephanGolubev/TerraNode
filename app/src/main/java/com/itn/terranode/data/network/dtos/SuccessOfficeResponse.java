package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class SuccessOfficeResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private InformationAboutUser data;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public InformationAboutUser getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(InformationAboutUser data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
