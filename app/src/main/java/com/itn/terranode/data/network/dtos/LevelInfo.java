package com.itn.terranode.data.network.dtos;

import com.google.gson.annotations.SerializedName;

public class LevelInfo {


    @SerializedName("current_level")
    CurrentLevel currentLevel;

    @SerializedName("next_level")
    NextLevel nextLevel;

    public CurrentLevel getCurrentLevel() {
        return currentLevel;
    }

    public NextLevel getNextLevel() {
        return nextLevel;
    }
}
