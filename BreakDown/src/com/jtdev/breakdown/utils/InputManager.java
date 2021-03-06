package com.jtdev.breakdown.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.jtdev.breakdown.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 31/07/13
 * Time: 6:17 PM
 */
public class InputManager implements InputProcessor
{
    public static final int SPACE = 0;

    private Logger logger;

    private boolean[] keysDown;
    private int[] touchX, touchY;
    private int[] oldTouchX,oldTouchY;//,touchX,touchY;
    private boolean flipped = true;

    //private int distanceZoom, oldZoom;
    //private boolean zooming;

    public InputManager()
    {
        logger = new Logger(this);

        keysDown = new boolean[10];
        touchX = new int[8];
        touchY = new int[8];
        oldTouchX = new int[8];
        oldTouchY = new int[8];
        //zooming = false;

        for (int i = 0; i < touchX.length; i++) touchX[i] = -1;
        for (int i = 0; i < touchY.length; i++) touchY[i] = -1;
        for (int i = 0; i < oldTouchX.length; i++) oldTouchX[i] = -1;
        for (int i = 0; i < oldTouchY.length; i++) oldTouchY[i] = -1;
    }

    public void setInputProcessor(boolean set)
    {
        if (set) Gdx.input.setInputProcessor(this);
        else Gdx.input.setInputProcessor(null);
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if (keycode == Constants.SPACE) keysDown[SPACE] = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if (keycode == Constants.SPACE) keysDown[SPACE] = false;
        return true;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        touchX[pointer] = screenX;
        if (flipped) touchY[pointer] = screenY;
        else touchY[pointer] = Constants.DEVICE_SCREEN_HEIGHT - screenY;
        //touchX = screenX;
        //touchY = screenY;

        if (pointer == 0)
        {
            oldTouchX[0] = screenX;
            oldTouchY[0] = screenY;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        touchX[pointer] = -1;
        touchY[pointer] = -1;
        oldTouchX[pointer] = screenX;
        if (flipped) oldTouchY[pointer] = screenY;
        else oldTouchY[pointer] = Constants.DEVICE_SCREEN_HEIGHT - screenY;

        //distanceTouchX = 0;
        //distanceTouchY = 0;
        //zooming = false;

        //distanceZoom = 0;
        //oldZoom = 0;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        logger.log("Pointer: " + pointer);
        logger.log("Touch X: " + screenX);
        logger.log("Touch Y: " + screenY);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    public boolean getKeyPressed(int key) { return keysDown[key]; }
    public boolean getSingleKeyPress(int key)
    {
        if (keysDown[key])
        {
            keysDown[key] = false;
            return true;
        }
        return false;
    }

    public float getTouchX(int pointer) { return touchX[pointer]; }
    public float getTouchY(int pointer) { return touchY[pointer]; }
    public void resetTouch(int pointer)
    {
        touchX[pointer] = -1;
        touchY[pointer] = -1;
    }

    public void setFlipped(boolean flipped) { this.flipped = flipped; }
}
