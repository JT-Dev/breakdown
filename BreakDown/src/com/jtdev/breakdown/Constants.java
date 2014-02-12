package com.jtdev.breakdown;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 29/07/13
 * Time: 10:15 PM
 */
public class Constants
{
    //General options
    public static int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final boolean TOUCHSCREEN = Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS;

    //Images
    public static final int SPLASH_SCREEN_TIME = 2000;
    public static final String SPLASH_IMAGE_PATH = "data/splashscreen.png";
    public static final int SPLASH_WIDTH = 1280;
    public static final int SPLASH_HEIGHT = 720;

    public static final String BACKGROUND_IMAGE_PATH_1 = "data/background1.png";
    public static final int BACKGROUND_WIDTH_1 = 1280;
    public static final int BACKGROUND_HEIGHT_1 = 720;

    public static final String BACKGROUND_IMAGE_PATH_2 = "data/background1.png";
    public static final int BACKGROUND_WIDTH_2 = 1280;
    public static final int BACKGROUND_HEIGHT_2 = 720;

    public static final String PLAYER_IMAGE_PATH = "data/player.png";
    public static final float PLAYER_STARTING_X = (float) (SCREEN_WIDTH * 0.1);
    public static final float PLAYER_STARTING_Y = 0;
    public static final int PLAYER_WIDTH = (int) (SCREEN_WIDTH * 0.18);
    public static final int PLAYER_HEIGHT = (int) (SCREEN_HEIGHT * 0.7);

    public static final String WALL_IMAGE_PATH = "data/wall.png";
    public static final int WALL_WIDTH = 16;
    public static final int WALL_HEIGHT = 8;

    //Background
    public static final int BACKGROUND_SPEED_1 = 5;
    public static final int BACKGROUND_SPEED_2 = 5;

    //Key mapping
    public static final int SPACE = Input.Keys.SPACE;

    //Player options
    public static final int PLAYER_SPEED = 2;
    public static final int PLAYER_MAX_SPEED = 5;

    //Wall options

    public static final float WALL_SPEED = 5;
    public static final int WALL_MAX_SPEED = 5;
    public static final int WALL_SPAWN_RANGE = 500;
    public static final int WALL_SPAWN_TIMEOUT = 500;

    //File options
    public static final String FILE_PATH = "/home/james/data";
    //public static final String FILE_PATH = "C:\\Users\\James Ridey\\Desktop\\data";

    //Debug options
    public static final boolean DEBUG_DRAW = false;
    public static final boolean DEBUG_LOG = true;
}
