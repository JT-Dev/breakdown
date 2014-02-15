package com.jtdev.breakdown.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.utils.Logger;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 11/02/14
 * Time: 1:23 PM
 */
public class BackgroundManager
{
    private Logger log;
    private TextureRegion[] backgroundTextures;
    private Background[] backgrounds;

    private TextureRegion[] cloudTextures;
    private ArrayList<Cloud> clouds;
    private ArrayList<Cloud> removeClouds;
    private boolean moving;
    private Color[] colors;

    public BackgroundManager()
    {
        log = new Logger(this);

        int backgroundNum = (int) Math.ceil((float) Constants.SCREEN_WIDTH / (float) Constants.BACKGROUND_WIDTH) * 2;
        log.log("Number of backgroundTextures: " + backgroundNum);
        backgroundTextures = new TextureRegion[backgroundNum];
        backgrounds = new Background[backgroundNum];
        if (Constants.DEBUG_DRAW) colors = new Color[backgroundNum];
        for (int i = 0; i < backgroundNum; i++)
        {
            Texture texture = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            TextureRegion textureRegion = new TextureRegion(texture,Constants.BACKGROUND_WIDTH,Constants.BACKGROUND_HEIGHT);
            if (i % 2 == 0) textureRegion.flip(true,false);
            Rectangle rectangle = new Rectangle(i * Constants.BACKGROUND_WIDTH, 0, Constants.BACKGROUND_WIDTH, Constants.BACKGROUND_HEIGHT);
            
            backgrounds[i] = new Background(rectangle,textureRegion);

            if (Constants.DEBUG_DRAW) colors[i] = new Color(MathUtils.random(),MathUtils.random(),MathUtils.random(),0);
        }

        cloudTextures = new TextureRegion[Constants.AMOUNT_OF_CLOUDS];
        clouds = new ArrayList<Cloud>();
        for (int i = 0; i < Constants.AMOUNT_OF_CLOUDS; i++)
        {
            log.log("" + i);
            Texture texture = new Texture(Gdx.files.internal(Constants.CLOUD_IMAGE_PATH+(i+1)+".png"));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            cloudTextures[i] = new TextureRegion(texture,Constants.CLOUD_WIDTH,Constants.CLOUD_HEIGHT);
            //cloud = new Rectangle(i * Constants.CLOUD_WIDTH, 0, Constants.CLOUD_WIDTH, Constants.CLOUD_HEIGHT);
        }

        removeClouds = new ArrayList<Cloud>();
        //TODO Don't set true here
        moving = true;
    }

    public void update()
    {
        for (Background background : backgrounds)
        {
            if (background.getX()+ background.getWidth() <= 0)
            {
                background.setX(background.getX() + (Constants.BACKGROUND_WIDTH * backgroundTextures.length));// + getBackgroundWidth(backgroundTextures.length - 1 - i));
            }
            background.addX(-Constants.BACKGROUND_SPEED);
        }
        if (clouds.size() < Constants.MAX_CLOUDS && MathUtils.random() < Constants.CLOUD_SPAWN_RATE)
        {
            log.log("Making cloud");
            log.log("Clouds array length: " + clouds.size());
            int i = MathUtils.random(0,cloudTextures.length-1);
            TextureRegion textureRegion = cloudTextures[i];
            Rectangle rectangle = new Rectangle(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT - (Constants.CLOUD_HEIGHT / 4),
                                                cloudTextures[i].getRegionWidth(),cloudTextures[i].getRegionHeight());
            clouds.add(new Cloud(rectangle,textureRegion));
            //for (int i = 0; i <= backgroundTextures.length-1; i++) batch.draw(backgroundTextures[i],background.getWidth(),Constants.SCREEN_HEIGHT);
        }
        for (Cloud cloud : clouds)
        {
            log.log("" + cloud.getX());
            cloud.addX(-Constants.CLOUD_SPEED);
            log.log((cloud.getX() + cloud.getWidth() <= 0) + "");
            if (cloud.getX() + cloud.getWidth() <= 0)
            {
                removeClouds.add(cloud);
            }
        }
        for (Cloud cloud : removeClouds) clouds.remove(cloud);
    }

    public void draw(SpriteBatch batch)
    {
        if (moving)
        {
            for (Background background : backgrounds)
            {
                if (background.getX() + background.getWidth() > 0 && background.getX() < Constants.SCREEN_WIDTH)
                {
                    batch.draw(background.getTexture(), background.getX(), background.getY(), background.getWidth(), Constants.SCREEN_HEIGHT);
                }
            }
            for (Cloud cloud : clouds)
            {
                if (cloud.getX() + cloud.getWidth() > 0 && cloud.getX() < Constants.SCREEN_WIDTH)
                {
                    log.log("draw: width: " + cloud.getY());
                    batch.draw(cloud.getTexture(), cloud.getX(), cloud.getY(),
                               cloud.getTexture().getRegionWidth() / 4, cloud.getTexture().getRegionHeight() / 4);
                }
            }
        }
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        if (moving)
        {
            for (int i = 0; i < backgrounds.length; i++)
            {
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(colors[i]);
                shapeRenderer.rect(backgrounds[i].getX(), backgrounds[i].getY(), backgrounds[i].getWidth(), backgrounds[i].getHeight());
                shapeRenderer.end();
            }
            //int i = MathUtils.random(0,cloudTextures.length-1);
            //for (int i = 0; i <= backgroundTextures.length-1; i++) batch.draw(backgroundTextures[i],background.getWidth(),Constants.SCREEN_HEIGHT);
        }
    }

    public boolean getMoving() { return moving; }
    public void setMoving(boolean moving) { this.moving = moving; }
}