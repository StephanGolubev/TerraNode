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
        return informationAboutMessages;
    }
}
