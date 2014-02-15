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

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 11/02/14
 * Time: 1:23 PM
 */
public class Background
{
    private Logger log;
    private TextureRegion[] backgrounds;
    private Rectangle[] backgroundRectangles;

    private TextureRegion[] clouds;
    private Rectangle[] cloudRectangles;
    private boolean moving;
    private Color[] colors;

    public Background()
    {
        log = new Logger(this);

        int backgroundNum = (int) Math.ceil((float) Constants.SCREEN_WIDTH / (float) Constants.BACKGROUND_WIDTH) * 2;
        log.log("Number of backgrounds: " + backgroundNum);
        backgrounds = new TextureRegion[backgroundNum];
        backgroundRectangles = new Rectangle[backgroundNum];
        colors = new Color[backgroundNum];
        for (int i = 0; i < backgroundNum; i++)
        {
            Texture texture = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            backgrounds[i] = new TextureRegion(texture,Constants.BACKGROUND_WIDTH,Constants.BACKGROUND_HEIGHT);
            if (i % 2 == 0) backgrounds[i].flip(true,false);
            backgroundRectangles[i] = new Rectangle(i * Constants.BACKGROUND_WIDTH, 0, Constants.BACKGROUND_WIDTH, Constants.BACKGROUND_HEIGHT);
            colors[i] = new Color(MathUtils.random(),MathUtils.random(),MathUtils.random(),0);
        }

        /*clouds = new TextureRegion[Constants.AMOUNT_OF_CLOUDS];
        for (int i = 0; i <= Constants.AMOUNT_OF_CLOUDS; i++)
        {
            Texture texture = new Texture(Gdx.files.internal(Constants.CLOUD_PATH +i+".png"));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            //clouds[i] = new TextureRegion(texture,Constants.)

        }*/

        //TODO Don't set true here
        moving = true;
    }

    public void update()
    {
        for (int i = 0; i < backgrounds.length; i++)
        {
            if (getBackgroundX(i)+ getBackgroundWidth(i) <= 0)
            {
                setBackgroundX(i, getBackgroundX(i) + (Constants.BACKGROUND_WIDTH * backgrounds.length));// + getBackgroundWidth(backgrounds.length - 1 - i));
            }
            addBackgroundX(i, -Constants.BACKGROUND_SPEED);
        }
    }

    public void draw(SpriteBatch batch)
    {
        if (moving)
        {
            for (int i = 0; i < backgrounds.length; i++)
            {
                batch.draw(backgrounds[i],backgroundRectangles[i].getX(),backgroundRectangles[i].getY(), getBackgroundWidth(i),Constants.SCREEN_HEIGHT);
            }
            //int i = MathUtils.random(0,clouds.length-1);
            //for (int i = 0; i <= backgrounds.length-1; i++) batch.draw(backgrounds[i],getBackgroundWidth(i),Constants.SCREEN_HEIGHT);
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
                shapeRenderer.rect(getBackgroundX(i), getBackgroundY(i), getBackgroundWidth(i), getBackgroundHeight(i));
                shapeRenderer.end();
            }
            //int i = MathUtils.random(0,clouds.length-1);
            //for (int i = 0; i <= backgrounds.length-1; i++) batch.draw(backgrounds[i],getBackgroundWidth(i),Constants.SCREEN_HEIGHT);
        }
    }

    public float getBackgroundX(int background) { return backgroundRectangles[background].getX(); }
    public float getBackgroundY(int background) { return backgroundRectangles[background].getY(); }
    public void setBackgroundX(int background, float x) { backgroundRectangles[background].setX(x); }
    public void setBackgroundY(int background, float y) { backgroundRectangles[background].setY(y); }

    public void addBackgroundX(int background, float x) { setBackgroundX(background, getBackgroundX(background) + x); }
    public void addBackgroundY(int background, float y) { setBackgroundY(background, getBackgroundY(background) + y); }

    public float getBackgroundWidth(int background) { return backgroundRectangles[background].getWidth(); }
    public void setBackgroundWidth(int background, int width) { backgroundRectangles[background].setWidth(width); }
    public float getBackgroundHeight(int background) { return backgroundRectangles[background].getHeight(); }
    public void setBackgroundHeight(int background, int height) { backgroundRectangles[background].setHeight(height); }

    public boolean getMoving() { return moving; }
    public void setMoving(boolean moving) { this.moving = moving; }
}