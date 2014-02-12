package com.jtdev.breakdown;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jtdev.breakdown.screens.GameScreen;
import com.jtdev.breakdown.screens.SplashScreen;
import com.jtdev.breakdown.utils.Logger;

public class Main extends Game
{
    private Logger logger;

    @Override
    public void create()
    {
        logger = new Logger(this);
        logger.log("Starting Game in " + Gdx.app.getType());
        setScreen(new SplashScreen(this));
        //setScreen(new GameScreen());
    }
}