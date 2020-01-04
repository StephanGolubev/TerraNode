package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.SuccessSearchResponce;
import com.itn.terranode.data.network.dtos.User;

import java.lang.reflect.Type;

public class SearchDeserializer implements JsonDeserializer<SuccessSearchResponce> {

    @Override
    public SuccessSearchResponce deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessSearchResponce successResponse = new SuccessSearchResponce();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject data = jsonObject.getAsJsonObject("data");
            JsonArray users = data.getAsJsonArray("users");
            for (JsonElement jsonElement : users) {
                successResponse.addData( context.deserialize(jsonElement, User.class));
            }
        }

        return successResponse;
    }
}
