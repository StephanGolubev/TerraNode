package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class Chat {

    @SerializedName("chat_id")
    private String chatId;

    @SerializedName("last_message")
    private String lastMessage;

    @SerializedName("is_read")
    private String isRead;

    @SerializedName("name")
    private String name;

    @SerializedName("photo")
    private String photo;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
