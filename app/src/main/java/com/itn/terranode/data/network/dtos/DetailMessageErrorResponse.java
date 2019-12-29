package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class DetailMessageErrorResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
