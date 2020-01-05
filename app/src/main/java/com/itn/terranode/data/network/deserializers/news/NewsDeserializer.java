package com.itn.terranode.data.network.deserializers.news;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.ErrorResponse;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.Product;
import com.itn.terranode.data.network.dtos.SuccessNewsResponse;
import com.itn.terranode.data.network.dtos.SuccessProductsResponse;

import java.lang.reflect.Type;

public class NewsDeserializer implements JsonDeserializer<SuccessNewsResponse> {

    @Override
    public SuccessNewsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessNewsResponse successResponse = new SuccessNewsResponse();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject news = jsonObject.getAsJsonObject("data");
            successResponse.setData(context.deserialize(news, InformationAboutNews.class));

        } else {
            successResponse.setData(null);

            JsonObject error = jsonObject.getAsJsonObject("error");
            successResponse.setError(context.deserialize(error, ErrorResponse.class));
        }

        return successResponse;
    }
}
