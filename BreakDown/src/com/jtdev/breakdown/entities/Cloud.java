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
    private TextureRegion image;

    public Cloud(float x, float y, TextureRegion image)
    {
        this.rectangle = new Rectangle(x,y, image.getRegionWidth(), image.getRegionHeight());
        this.image = image;
    }

    public boolean collides(Cloud otherCloud)
    {
        return getRectangle().overlaps(otherCloud.getRectangle());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cloud cloud = (Cloud) o;

        if (rectangle != null ? !rectangle.equals(cloud.rectangle) : cloud.rectangle != null) return false;
        if (image != null ? !image.equals(cloud.image) : cloud.image != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = rectangle != null ? rectangle.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public Rectangle getRectangle() { return rectangle; }
    public void setRectangle(Rectangle rectangle) { this.rectangle = rectangle; }
    public TextureRegion getImage() { return image; }
    public void setImage(TextureRegion image) { this.image = image; }

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
