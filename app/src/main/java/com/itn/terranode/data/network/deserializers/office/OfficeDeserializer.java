package com.itn.terranode.data.network.deserializers.office;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.InformationAboutUser;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.network.dtos.SuccessOfficeResponse;

import java.lang.reflect.Type;

public class OfficeDeserializer implements JsonDeserializer<SuccessOfficeResponse> {

    @Override
    public SuccessOfficeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessOfficeResponse successResponse = new SuccessOfficeResponse();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject news = jsonObject.getAsJsonObject("data");
            successResponse.setData((InformationAboutUser) context.deserialize(news, InformationAboutUser.class));

        }

        return successResponse;
    }
}
