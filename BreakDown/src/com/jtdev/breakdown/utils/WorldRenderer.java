package com.jtdev.breakdown.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.entities.World;
//shapeRenderer\.$1
/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 31/07/13
 * Time: 6:25 PM
 */
public class WorldRenderer
{
    private Logger logger;

    private World world;
    private SpriteBatch batch;

    private ShapeRenderer shapeRenderer;
    //private SpriteBatch debugBatch;
    private BitmapFont debugFont;

    public WorldRenderer(World world)
    {
        logger = new Logger(this);

        this.world = world;

        batch = new SpriteBatch();
        //debugBatch = new SpriteBatch();

        if (Constants.DEBUG_DRAW)
        {
            shapeRenderer = new ShapeRenderer();

            debugFont = new BitmapFont();
            debugFont.setColor(Color.BLACK);
        }
    }

    public void render()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //batch.getProjectionMatrix().setToOrtho2D(0, 0, 680, 480);
        //batch.setProjectionMatrix(camera.combined);
        batch.begin();
        world.draw(batch);
        batch.end();

        if (Constants.DEBUG_DRAW)
        {
            //shapeRenderer.setProjectionMatrix(world.getCamera().combined);
            world.debugDraw(shapeRenderer);

            batch.begin();
            debugFont.draw(batch, String.valueOf(Gdx.graphics.getFramesPerSecond()),10,Constants.DEVICE_SCREEN_HEIGHT - 10);
            batch.end();
        }
    }

    public void pause()
    {

    }

    public void resume()
    {

    }

    public void dispose()
    {
        logger.log("Disposing Renderer");
        batch.dispose();
        shapeRenderer.dispose();
        debugFont.dispose();
    }
}
