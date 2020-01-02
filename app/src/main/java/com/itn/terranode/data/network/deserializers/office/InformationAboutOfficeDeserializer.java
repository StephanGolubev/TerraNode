package com.itn.terranode.data.network.deserializers.office;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.itn.terranode.data.network.dtos.Balance;
import com.itn.terranode.data.network.dtos.InformationAboutNews;
import com.itn.terranode.data.network.dtos.InformationAboutUser;
import com.itn.terranode.data.network.dtos.LevelInfo;
import com.itn.terranode.data.network.dtos.NewsItem;

import java.lang.reflect.Type;

public class InformationAboutOfficeDeserializer implements JsonDeserializer<InformationAboutUser> {
    @Override
    public InformationAboutUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        InformationAboutUser informationAboutUser = new InformationAboutUser();
        informationAboutUser.setId(jsonObject.get("id").getAsString());
        informationAboutUser.setEmail(jsonObject.get("email").getAsString());
        informationAboutUser.setName(jsonObject.get("name").getAsString());
        informationAboutUser.setPhoto(jsonObject.get("photo").getAsString());
        informationAboutUser.setSponsorId(jsonObject.get("sponsor_id").getAsString());

        JsonObject levelInfo = jsonObject.getAsJsonObject("level_info");
        informationAboutUser.setLevelInfo((LevelInfo) context.deserialize(levelInfo, LevelInfo.class));


        JsonObject balance = jsonObject.getAsJsonObject("balance");
        informationAboutUser.setBalance((Balance) context.deserialize(balance, Balance.class));

        return informationAboutUser;
    }
}
