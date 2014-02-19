package com.jtdev.breakdown.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.jtdev.breakdown.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 15/02/14
 * Time: 10:42 PM
 */
public class Cloud
{
    private Sprite sprite;
    
    public Cloud(float x, float y, TextureRegion image)
    {
        sprite = new Sprite(image);
        sprite.setSize(Constants.CLOUD_WIDTH, Constants.CLOUD_HEIGHT);
        sprite.setPosition(x,y);
    }

    public void update()
    {
        addX(-Constants.CLOUD_SPEED);
    }
    
    public void draw(SpriteBatch batch)
    {
        sprite.draw(batch);
    }

    public boolean collides(Cloud otherEntity)
    {
        return getRectangle().overlaps(otherEntity.getRectangle());
    }

    public Sprite getSprite() { return sprite; }
    public void setSprite(Sprite sprite) { this.sprite = sprite; }
    public Rectangle getRectangle() { return sprite.getBoundingRectangle(); }

    public float getX() { return sprite.getX(); }
    public float getY() { return sprite.getY(); }
    public void setX(float x) { sprite.setX(x); }
    public void setY(float y) { sprite.setY(y); }

    public void addX(float x) { setX(getX() + x); }
    public void addY(float y) { setY(getY() + y); }

    public float getWidth() { return sprite.getWidth(); }
    public void setWidth(int width) { sprite.setRegionWidth(width); }
    public float getHeight() { return sprite.getHeight(); }
    public void setHeight(int height) { sprite.setRegionHeight(height); }
}
