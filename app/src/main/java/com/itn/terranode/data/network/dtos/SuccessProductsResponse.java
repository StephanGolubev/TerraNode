package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuccessProductsResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<Product> data;

    @SerializedName("error")
    private ErrorResponse error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getData() {
        return data;
    }

    public void addData(Product data) {
        this.data.add(data);
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}

