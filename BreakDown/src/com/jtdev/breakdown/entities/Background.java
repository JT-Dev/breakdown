package com.jtdev.breakdown.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.jtdev.breakdown.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 11/02/14
 * Time: 1:23 PM
 */
public class Background
{
    private float width1,height1,width2,height2;
    private Sprite sprite1;
    private Sprite sprite2;

    public Background()
    {
        this(0,0,Constants.BACKGROUND_WIDTH_1,Constants.BACKGROUND_HEIGHT_1,0,0,Constants.BACKGROUND_WIDTH_2,Constants.BACKGROUND_HEIGHT_2);
    }

    public Background(float x1, float y1, float width1, float height1, float x2, float y2, float width2, float height2)
    {
        Texture texture1 = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH_1));
        texture1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
        TextureRegion image1 = new TextureRegion(texture1, Constants.BACKGROUND_WIDTH_1, Constants.BACKGROUND_HEIGHT_1);

        Texture texture2 = new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH_2));
        texture2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
        TextureRegion image2 = new TextureRegion(texture2, Constants.BACKGROUND_WIDTH_2, Constants.BACKGROUND_HEIGHT_2);

        this.width1 = width1;
        this.height1 = height1;
        this.width2 = width2;
        this.height2 = height2;
        sprite1 = new Sprite(image1);
        sprite1.setPosition(x1,y1);
        sprite2 = new Sprite(image2);
        sprite2.setPosition(x2,y2);
    }

    public void update()
    {
        addX1(-Constants.BACKGROUND_SPEED_1);
        addX2(-Constants.BACKGROUND_SPEED_2);

        if (getX1()+getWidth1() < 0) setX1(Constants.SCREEN_WIDTH);
        if (getX2()+getWidth2() < 0) setX2(Constants.SCREEN_WIDTH);
    }

    public void draw(SpriteBatch batch)
    {
        sprite1.draw(batch);
        sprite2.draw(batch);
    }

    public float getX1() { return sprite1.getX(); };
    public float getY1() { return sprite1.getY(); };
    public void setX1(float x1) { sprite1.setX(x1); };
    public void setY1(float y1) { sprite1.setY(y1); };

    public void addX1(float x1) { setX1(getX1()+x1); }
    public void addX2(float x2) { setX2(getX2()+x2); }
    public void addY1(float y1) { setY1(getY1()+y1); }
    public void addY2(float y2) { setY2(getY2()+y2); }

    public float getWidth1() { return width1; }
    public void setWidth1(float width1) { this.width1 = width1; }
    public float getHeight1() { return height1; }
    public void setHeight1(float height1) { this.height1 = height1; }

    public float getX2() { return sprite2.getX(); };
    public float getY2() { return sprite2.getY(); };
    public void setX2(float x2) { sprite2.setX(x2); };
    public void setY2(float y2) { sprite2.setY(y2); };

    public float getWidth2() { return width2; }
    public void setWidth2(float width2) { this.width2 = width2; }
    public float getHeight2() { return height2; }
    public void setHeight2(float height2) { this.height2 = height2; }
}
