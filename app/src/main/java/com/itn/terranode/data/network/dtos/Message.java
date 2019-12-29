package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message {

    @SerializedName("name")
    private List<String> name;

    @SerializedName("email")
    private List<String> email;

    @SerializedName("password")
    private List<String> password;

    public List<String> getName() {
        return name;
    }

    public List<String> getEmail() {
        return email;
    }

    public List<String> getPassword() {
        return password;
    }
}
