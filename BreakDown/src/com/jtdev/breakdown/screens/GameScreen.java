package com.jtdev.breakdown.screens;

import com.badlogic.gdx.Screen;
import com.jtdev.breakdown.Main;
import com.jtdev.breakdown.entities.World;
import com.jtdev.breakdown.utils.InputManager;
import com.jtdev.breakdown.utils.Logger;
import com.jtdev.breakdown.utils.WorldRenderer;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 31/07/13
 * Time: 6:20 PM
 */
public class GameScreen implements Screen
{
    Logger logger;

    World world;
    WorldRenderer renderer;
    InputManager inputManager;

    public GameScreen(Main main)
    {
        logger = new Logger(this);

        this.world = main.getWorld();
        this.renderer = main.getRenderer();
        this.inputManager = main.getInputManager();
    }

    @Override
	public void render(float delta)
    {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        world.update();
        renderer.render();
    }

    @Override
	public void resize(int width, int height)
    {
    }

    @Override
	public void show()
    {
        world.getEntityManager().getPlayer().setShowing(true);
    }

    @Override
	public void hide()
    {
        inputManager.setInputProcessor(false);
    }

    @Override
	public void pause()
    {
        logger.log("Pausing");
        world.pause();
        renderer.pause();
    }

    @Override
	public void resume()
    {
        logger.log("Resuming");
        world.resume();
        renderer.resume();
    }

    @Override
	public void dispose()
    {
        logger.log("Disposing");
        inputManager.setInputProcessor(false);
        world.dispose();
        renderer.dispose();
    }
}
