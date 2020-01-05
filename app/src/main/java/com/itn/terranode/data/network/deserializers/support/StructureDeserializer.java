package com.itn.terranode.data.network.deserializers.support;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.ErrorResponse;
import com.itn.terranode.data.network.dtos.InformationAboutStructure;
import com.itn.terranode.data.network.dtos.SuccessStructureResponce;

import java.lang.reflect.Type;

public class StructureDeserializer implements JsonDeserializer<SuccessStructureResponce> {

    @Override
    public SuccessStructureResponce deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessStructureResponce successResponse = new SuccessStructureResponce();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonObject data = jsonObject.getAsJsonObject("data");
            JsonObject structure = data.getAsJsonObject("structure");
            successResponse.setData((context.deserialize(structure, InformationAboutStructure.class)));
        } else {
            successResponse.setData(null);

            JsonObject error = jsonObject.getAsJsonObject("error");
            successResponse.setError(context.deserialize(error, ErrorResponse.class));
        }

        return successResponse;
    }
}
