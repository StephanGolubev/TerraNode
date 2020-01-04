package com.itn.terranode.data.network.deserializers.news;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.NewsItem;

import java.lang.reflect.Type;

public class InformationAboutNewsDeserializer implements JsonDeserializer<InformationAboutNews> {
    @Override
    public InformationAboutNews deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        InformationAboutNews informationAboutNews = new InformationAboutNews();
        JsonObject newsJsonObject = jsonObject.getAsJsonObject("news");
        JsonArray jsonElements = newsJsonObject.getAsJsonArray("data");
        for (JsonElement jsonElement: jsonElements) {
            informationAboutNews.addNewsItems(context.deserialize(jsonElement, NewsItem.class));
        }
        return informationAboutNews;
    }
}
