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
    public static final String ICON_PATH = "data/icon.png";

    //Images
    //Splash
    public static final int SPLASH_SCREEN_TIME = 2000; //Milliseconds
    public static final String SPLASH_IMAGE_PATH = "data/splashscreen.png";
    public static final int SPLASH_WIDTH = 1280;
    public static final int SPLASH_HEIGHT = 720;

    //BackgroundManager
    public static final String BACKGROUND_IMAGE_PATH = "data/background.png";
    public static final int BACKGROUND_WIDTH = 1280;
    public static final int BACKGROUND_HEIGHT = 720;

    //Clouds
    public static final double CLOUD_SPAWN_RATE = 0.05;
    public static final int MAX_CLOUDS = 3;
    public static final int AMOUNT_OF_CLOUDS = 10;
    public static final String CLOUD_IMAGE_PATH = "data/cloud";
    public static final int CLOUD_WIDTH = 800;
    public static final int CLOUD_HEIGHT = 500;

    //Player
    public static final String PLAYER_IMAGE_PATH = "data/player.png";
    public static final float PLAYER_STARTING_X = (float) (SCREEN_WIDTH * 0.1);
    public static final float PLAYER_STARTING_Y = 0;
    public static final int PLAYER_WIDTH = 200;
    public static final int PLAYER_HEIGHT = 200;

    //Wall
    public static final String WALL_IMAGE_PATH = "data/wall.png";
    public static final int WALL_WIDTH = 16;
    public static final int WALL_HEIGHT = 8;

    //Button images
    //Play
    public static final String PLAY_BUTTON_IMAGE_PATH = "data/play.png";
    public static final int PLAY_BUTTON_WIDTH = 100;
    public static final int PLAY_BUTTON_HEIGHT = 100;

    //Play
    public static final String CREDIT_BUTTON_IMAGE_PATH = "data/credit.png";
    public static final int CREDIT_BUTTON_WIDTH = 100;
    public static final int CREDIT_BUTTON_HEIGHT = 100;

    //Play
    public static final String MUSIC_BUTTON_IMAGE_PATH = "data/music.png";
    public static final int MUSIC_BUTTON_WIDTH = 100;
    public static final int MUSIC_BUTTON_HEIGHT = 100;



    //Key mapping
    public static final int SPACE = Input.Keys.SPACE;

    //BackgroundManager options
    public static final int BACKGROUND_SPEED = 5;

    //Clouds options
    public static int CLOUD_SPEED = 5;

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
