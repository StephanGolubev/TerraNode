package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.ErrorResponse;
import com.itn.terranode.data.network.dtos.InformationAboutStructure;
import com.itn.terranode.data.network.dtos.Product;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;

import java.lang.reflect.Type;

public class ChatsDeserializer implements JsonDeserializer<SuccessChatsResponce> {

    @Override
    public SuccessChatsResponce deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessChatsResponce successResponse = new SuccessChatsResponce();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject productList = jsonObject.getAsJsonObject("data");
            JsonArray chats = productList.getAsJsonArray("chats");
            for (JsonElement jsonElement : chats) {
                successResponse.addData( context.deserialize(jsonElement, Chat.class));
            }
        } else {
            successResponse.setData(null);

            JsonObject error = jsonObject.getAsJsonObject("error");
            successResponse.setError(context.deserialize(error, ErrorResponse.class));
        }

        return successResponse;
    }
}
