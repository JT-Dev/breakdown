package com.jtdev.breakdown.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 15/02/14
 * Time: 10:42 PM
 */
public class Cloud
{
    private Rectangle rectangle;
    private TextureRegion texture;

    public Cloud(Rectangle rectangle, TextureRegion texture)
    {
        this.rectangle = rectangle;
        this.texture = texture;
    }

    public Rectangle getRectangle() { return rectangle; }
    public void setRectangle(Rectangle rectangle) { this.rectangle = rectangle; }
    public TextureRegion getTexture() { return texture; }
    public void setTexture(TextureRegion texture) { this.texture = texture; }

    public float getX() { return rectangle.getX(); }
    public float getY() { return rectangle.getY(); }
    public void setX(float x) { rectangle.setX(x); }
    public void setY(float y) { rectangle.setY(y); }

    public void addX(float x) { setX(getX() + x); }
    public void addY(float y) { setY(getY() + y); }

    public float getWidth() { return rectangle.getWidth(); }
    public void setWidth(int width) { rectangle.setWidth(width); }
    public float getHeight() { return rectangle.getHeight(); }
    public void setHeight(int height) { rectangle.setHeight(height); }
}
