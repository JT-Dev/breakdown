package com.jtdev.breakdown.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.entities.Background;
import com.jtdev.breakdown.entities.Cloud;
import com.jtdev.breakdown.utils.Logger;

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
    private ArrayList<Cloud> cloudArray;
    private ArrayList<Cloud> removeCloudArray;
    private Color[] colors;
    //private long oldTime;

    public BackgroundManager()
    {
        log = new Logger(this);

        int backgroundNum = (int) Math.ceil((float) Constants.DEVICE_SCREEN_WIDTH / (float) Constants.BACKGROUND_WIDTH) * 2;
        log.log("Number of backgroundTextures: " + backgroundNum);
        backgroundTextures = new TextureRegion[backgroundNum];
        backgrounds = new Background[backgroundNum];
        if (Constants.DEBUG_DRAW) colors = new Color[backgroundNum];
        for (int i = 0; i < backgroundNum; i++)
        {
            Texture texture = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            TextureRegion image = new TextureRegion(texture,Constants.BACKGROUND_WIDTH,Constants.BACKGROUND_HEIGHT);
            if (i % 2 == 0) image.flip(true,false);
            //Rectangle rectangle = new Rectangle(i * Constants.BACKGROUND_WIDTH, 0, Constants.BACKGROUND_WIDTH, Constants.BACKGROUND_HEIGHT);
            
            backgrounds[i] = new Background(i * Constants.BACKGROUND_WIDTH, 0 ,image);

            if (Constants.DEBUG_DRAW) colors[i] = new Color(MathUtils.random(),MathUtils.random(),MathUtils.random(),0);
        }

        cloudTextures = new TextureRegion[Constants.AMOUNT_OF_CLOUDS];
        cloudArray = new ArrayList<Cloud>();
        for (int i = 0; i < Constants.AMOUNT_OF_CLOUDS; i++)
        {
            Texture texture = new Texture(Gdx.files.internal(Constants.CLOUD_IMAGE_PATH+(i+1)+".png"));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            cloudTextures[i] = new TextureRegion(texture,Constants.CLOUD_IMAGE_WIDTH,Constants.CLOUD_IMAGE_HEIGHT);
            //cloud = new Rectangle(i * Constants.CLOUD_IMAGE_WIDTH, 0, Constants.CLOUD_IMAGE_WIDTH, Constants.CLOUD_IMAGE_HEIGHT);
        }

        removeCloudArray = new ArrayList<Cloud>();
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
        if (cloudArray.size() < Constants.MAX_CLOUDS && MathUtils.random() < Constants.CLOUD_SPAWN_RATE)
        {
            createCloud();
        }
        for (Cloud cloud : cloudArray)
        {
            cloud.addX(-Constants.CLOUD_SPEED);
            if (cloud.getX() + cloud.getWidth() <= 0)
            {
                removeCloudArray.add(cloud);
            }
        }
        for (Cloud cloud : removeCloudArray) cloudArray.remove(cloud);
    }

    private void createCloud()
    {
        log.log("Making cloud");
        log.log("Clouds array length: " + cloudArray.size());

        int i = MathUtils.random(0,cloudTextures.length-1);
        TextureRegion image = cloudTextures[i];

        float x,y;
        Cloud cloud;
        do
        {
            x = MathUtils.random(Constants.DEVICE_SCREEN_WIDTH, Constants.DEVICE_SCREEN_WIDTH + Constants.CLOUD_SPAWN_RANGE);
            y = Constants.DEVICE_SCREEN_HEIGHT - 20;
            cloud = new Cloud(x,y,image);
        }
        while (collides(cloud));

        cloudArray.add(cloud);
        //oldTime = TimeUtils.millis();
    }

    private boolean collides(Cloud cloud)
    {
        for (Cloud otherCloud : cloudArray)
        {
            if (!cloud.equals(otherCloud))
            {
                if (cloud.collides(otherCloud)) return true;
            }
        }
        return false;
    }

    public void draw(SpriteBatch batch)
    {
        for (Background background : backgrounds)
        {
            if (background.getX() + background.getWidth() > 0 && background.getX() < Constants.DEVICE_SCREEN_WIDTH)
            {
                background.draw(batch);
                //batch.draw(background.getTexture(), background.getX(), background.getY(), background.getWidth(), Constants.DEVICE_SCREEN_HEIGHT);
            }
        }
        for (Cloud cloud : cloudArray)
        {
            if (cloud.getX() + cloud.getWidth() > 0 && cloud.getX() < Constants.DEVICE_SCREEN_WIDTH)
            {
                cloud.draw(batch);
                //batch.draw(cloud.getTexture(), cloud.getX(), cloud.getY(),
                //           Constants.DEVICE_SCREEN_WIDTH / 4, Constants.DEVICE_SCREEN_HEIGHT / 4);
            }
        }
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        for (int i = 0; i < backgrounds.length; i++)
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(colors[i]);
            shapeRenderer.rect(backgrounds[i].getX(), backgrounds[i].getY(), backgrounds[i].getWidth(), backgrounds[i].getHeight());
            shapeRenderer.end();
        }
    }
}