package com.itn.terranode.data.network.deserializers.news;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.NewsItem;

import java.lang.reflect.Type;

public class NewsItemDeserializer implements JsonDeserializer<NewsItem> {
    @Override
    public NewsItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        NewsItem newsItem = new NewsItem();
        JsonObject jsonObject = json.getAsJsonObject();
        newsItem.setTitle(jsonObject.get("title").getAsString());
        newsItem.setDescription(jsonObject.get("description").getAsString());
        newsItem.setText(jsonObject.get("text").getAsString());
        newsItem.setCreatedAt(jsonObject.get("created_at").getAsString());
        return newsItem;
    }
}
