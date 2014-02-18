package com.jtdev.breakdown;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jtdev.breakdown.entities.World;
import com.jtdev.breakdown.screens.SplashScreen;
import com.jtdev.breakdown.utils.InputManager;
import com.jtdev.breakdown.utils.Logger;
import com.jtdev.breakdown.utils.WorldRenderer;

public class Main extends Game
{
    private Logger logger;

    private World world;
    private WorldRenderer renderer;
    private InputManager inputManager;

    @Override
    public void create()
    {
        logger = new Logger(this);
        logger.log("Starting Game in " + Gdx.app.getType());

        setScreen(new SplashScreen(this));
        //setScreen(new GameScreen());
    }

    public void init()
    {
        inputManager = new InputManager();
        world = new World(inputManager);
        renderer = new WorldRenderer(world);

        inputManager.setInputProcessor(true);
    }

    public World getWorld() { return world; }
    public WorldRenderer getRenderer() { return renderer; }
    public InputManager getInputManager() { return inputManager; }
}