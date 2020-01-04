package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class ChatMessage {

    @SerializedName("id")
    private String id;

    @SerializedName("chat_id")
    private String chatId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("message")
    private String message;

    @SerializedName("is_read")
    private String isRead;

    @SerializedName("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
