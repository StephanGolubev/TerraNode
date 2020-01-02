package com.itn.terranode.data.network.deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.Product;
import com.itn.terranode.data.network.dtos.SuccessProductsResponse;

import java.lang.reflect.Type;

public class ProductsDeserializer implements JsonDeserializer<SuccessProductsResponse> {

    @Override
    public SuccessProductsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        SuccessProductsResponse successResponse = new SuccessProductsResponse();
        successResponse.setStatus(jsonObject.get("status").getAsString());

        if(jsonObject.get("status").getAsString().equals("200")){
            successResponse.setError(null);

            JsonArray productList = jsonObject.getAsJsonArray("data");
            for (JsonElement jsonElement : productList) {
                successResponse.addData( context.deserialize(jsonElement, Product.class));
            }
        }

        return successResponse;
    }
}
