package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.ErrorResponse;
import com.itn.terranode.data.network.dtos.InformationAboutMessages;
import com.itn.terranode.data.network.dtos.SuccessGetMessageFromChatResponse;

import java.lang.reflect.Type;

public class GetMessageFromChatDeserializer implements JsonDeserializer<SuccessGetMessageFromChatResponse> {

    @Override
    public SuccessGetMessageFromChatResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessGetMessageFromChatResponse successResponse = new SuccessGetMessageFromChatResponse();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject news = jsonObject.getAsJsonObject("data");
            JsonObject newsJsonObject = news.getAsJsonObject("messages");
            successResponse.setData(context.deserialize(newsJsonObject, InformationAboutMessages.class));

        } else {
            successResponse.setData(null);

            JsonObject error = jsonObject.getAsJsonObject("error");
            successResponse.setError(context.deserialize(error, ErrorResponse.class));
        }

        return successResponse;
    }
}
