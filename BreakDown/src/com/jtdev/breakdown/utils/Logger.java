package com.jtdev.breakdown.utils;

import com.badlogic.gdx.Gdx;
import com.jtdev.breakdown.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 30/07/13
 * Time: 1:17 PM
 */
public class Logger
{
    String className;

    public Logger(Object classObject)
    {
        className = classObject.getClass().getSimpleName() + "(D)";
    }

    public void log(String message)
    {
        if (Constants.DEBUG) Gdx.app.log(className, message);
    }
}
