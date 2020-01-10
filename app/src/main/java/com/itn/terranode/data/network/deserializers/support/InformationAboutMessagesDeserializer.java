package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.network.dtos.InformationAboutMessages;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.NewsItem;

import java.lang.reflect.Type;

public class InformationAboutMessagesDeserializer implements JsonDeserializer<InformationAboutMessages> {
    @Override
    public InformationAboutMessages deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        InformationAboutMessages informationAboutMessages = new InformationAboutMessages();
        JsonObject newsJsonObject = jsonObject.getAsJsonObject("messages");

        JsonArray jsonElements = newsJsonObject.getAsJsonArray("data");
        for (JsonElement jsonElement: jsonElements) {
            informationAboutMessages.addChatMessages( context.deserialize(jsonElement, ChatMessage.class));
        }


        if(newsJsonObject.get("current_page").getAsString() != null){
            informationAboutMessages.setCurrentPage(newsJsonObject.get("current_page").getAsInt());
        }
        if(newsJsonObject.get("from").getAsString() != null) {
            informationAboutMessages.setFrom(newsJsonObject.get("from").getAsInt());
        }
        if(newsJsonObject.get("last_page").getAsString() != null) {
            informationAboutMessages.setLastPage(newsJsonObject.get("last_page").getAsInt());
        }
        if(newsJsonObject.get("per_page").getAsString() != null) {
            informationAboutMessages.setPerPage(newsJsonObject.get("per_page").getAsInt());
        }
        if(newsJsonObject.get("to").getAsString() != null) {
            informationAboutMessages.setTo(newsJsonObject.get("to").getAsInt());
        }
        if(newsJsonObject.get("total").getAsString() != null) {
            informationAboutMessages.setTotal(newsJsonObject.get("total").getAsInt());
        }


        if(newsJsonObject.get("first_page_url").getAsString() != null){
            informationAboutMessages.setFirstPageUrl(newsJsonObject.get("first_page_url").getAsString());
        }
        if(newsJsonObject.get("last_page_url").getAsString() != null){
            informationAboutMessages.setLastPageUrl(newsJsonObject.get("last_page_url").getAsString());
        }
        if(newsJsonObject.get("next_page_url").getAsString() != null){
            informationAboutMessages.setNextPageUrl(newsJsonObject.get("next_page_url").getAsString());
        }
        if(newsJsonObject.get("prev_page_url").getAsString() != null){
            informationAboutMessages.setPrevPageUrl(newsJsonObject.get("prev_page_url").getAsString());
        }
        if(newsJsonObject.get("path").getAsString() != null){
            informationAboutMessages.setPath(newsJsonObject.get("path").getAsString());
        }

        return informationAboutMessages;
    }
}
