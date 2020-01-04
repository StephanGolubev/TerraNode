package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.SuccessChatsResponce;
import com.itn.terranode.data.network.dtos.SuccessCreateChatResponce;

import java.lang.reflect.Type;

public class ChatDeserializer implements JsonDeserializer<SuccessCreateChatResponce> {

    @Override
    public SuccessCreateChatResponce deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessCreateChatResponce successResponse = new SuccessCreateChatResponce();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject productList = jsonObject.getAsJsonObject("data");
            successResponse.setData(productList.get("chat_id").getAsString());
        }

        return successResponse;
    }
}
