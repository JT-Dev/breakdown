package com.jtdev.breakdown.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
    private final Logger log;
    private TextureRegion background1;
    private TextureRegion background2;
    private Rectangle rectangle1;
    private Rectangle rectangle2;

    public Background()
    {
        this(0,0,Constants.BACKGROUND_WIDTH_1,Constants.BACKGROUND_HEIGHT_1,
             Constants.BACKGROUND_WIDTH_1,0,Constants.BACKGROUND_WIDTH_2,Constants.BACKGROUND_HEIGHT_2);
    }

    public Background(float x1, float y1, int width1, int height1, float x2, float y2, int width2, int height2)
    {
        log = new Logger(this);

        Texture texture1 = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH_1));
        texture1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background1 = new TextureRegion(texture1,width1,height1);

        Texture texture2 = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH_2));
        texture2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background2 = new TextureRegion(texture2,width2,height2);

        this.rectangle1 = new Rectangle(x1,y1,width1,height2);
        this.rectangle2 = new Rectangle(x2,y2,width2,height2);
    }

    public void update()
    {
        addX1(-Constants.BACKGROUND_SPEED_1);
        addX2(-Constants.BACKGROUND_SPEED_2);

        if (getX1()+getWidth1() < 0) setX1(getX2()+getWidth2());
        if (getX2()+getWidth2() < 0) setX2(getX1()+getWidth1());

        //log.log("X1: " + getX1());
        //log.log("X2: " + getX2());
    }

    public void draw(SpriteBatch batch)
    {
        batch.draw(background1,getX1(),getY1(),getWidth1(),Constants.SCREEN_HEIGHT);
        batch.draw(background2,getX2(),getY2(),getWidth2(),Constants.SCREEN_HEIGHT);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getX1(),getY1(),getWidth1(),getHeight1());
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(getX2(),getY2(),getWidth2(),getHeight2());
        shapeRenderer.end();
    }

    public float getX1() { return rectangle1.getX(); }
    public float getY1() { return rectangle1.getY(); }
    public void setX1(float x1) { rectangle1.setX(x1); }
    public void setY1(float y1) { rectangle1.setY(y1); }

    public void addX1(float x1) { setX1(getX1()+x1); }
    public void addX2(float x2) { setX2(getX2()+x2); }
    public void addY1(float y1) { setY1(getY1()+y1); }
    public void addY2(float y2) { setY2(getY2()+y2); }

    public float getWidth1() { return rectangle1.getWidth(); }
    public void setWidth1(int width1) { rectangle1.setWidth(width1); }
    public float getHeight1() { return rectangle1.getHeight(); }
    public void setHeight1(int height1) { rectangle1.setHeight(height1); }

    public float getX2() { return rectangle2.getX(); }
    public float getY2() { return rectangle2.getY(); }
    public void setX2(float x2) { rectangle2.setX(x2); }
    public void setY2(float y2) { rectangle2.setY(y2); }

    public float getWidth2() { return rectangle2.getWidth(); }
    public void setWidth2(int width2) { rectangle2.setWidth(width2); }
    public float getHeight2() { return rectangle2.getHeight(); }
    public void setHeight2(int height2) { rectangle2.setHeight(height2); }
}
