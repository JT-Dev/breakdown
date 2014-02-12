package com.jtdev.breakdown.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.managers.EntityManager;
import com.jtdev.breakdown.utils.FileManager;
import com.jtdev.breakdown.utils.InputManager;
import com.jtdev.breakdown.utils.Logger;
import com.jtdev.breakdown.utils.Profile;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 29/07/13
 * Time: 10:09 PM
 */
public class World
{
    private Profile profile;
    private EntityManager entityManager;
    private FileManager fileManager;
    private InputManager inputManager;
    private Logger logger;

    public World(InputManager inputManager)
    {
        logger = new Logger(this);
        this.inputManager = inputManager;

        create();
    }

    public void create()
    {
        logger.log("Creating Objects");

        //fileManager = new FileManager(this);
        //profile = fileManager.getProfile();

        entityManager = new EntityManager();

        logger.log("Done creating objects");
    }

    public void update(float delta)
    {
        if (Constants.TOUCHSCREEN) updateTouchScreen();
        else updateKeys();
        entityManager.update();
    }

    private void updateKeys()
    {
    }

    private void updateTouchScreen()
    {
    }

    public void draw(SpriteBatch batch)
    {
        entityManager.draw(batch);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        entityManager.debugDraw(shapeRenderer);
    }

    public void pause()
    {
        logger.log("Pausing World");
    }

    public void resume()
    {
        logger.log("Resuming World");
    }

    public void dispose()
    {
        logger.log("Disposing World");
    }

    public FileManager getFileManager() { return fileManager; }
    public Profile getProfile() { return profile; }

}
