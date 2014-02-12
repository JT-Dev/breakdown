package com.jtdev.breakdown.utils;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 16/08/13
 * Time: 2:34 P
 */
public class Profile implements Json.Serializable
{
    private int highscore;

    public Profile()
    {
        highscore = 0;
    }

    @Override
    public void write(Json json)
    {
        json.writeValue("highscore", highscore);
    }

    @Override
    public void read(Json json, JsonValue jsonValue)
    {
        this.highscore = json.readValue("highscore", Integer.class, jsonValue);
    }

    public int getScore() { return highscore; }
}
