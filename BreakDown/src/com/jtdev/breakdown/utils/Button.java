package com.jtdev.breakdown.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 18/02/14
 * Time: 10:31 AM
 */
public class Button
{
    Rectangle rectangle;
    TextureRegion image;

    public Button(float x, float y, TextureRegion image)
    {
        rectangle = new Rectangle(x,y,image.getRegionWidth(),image.getRegionHeight());
        this.image = image;
    }

    public void draw(SpriteBatch batch)
    {
        batch.draw(image,getX(),getY());
    }

    public boolean isPressed(InputManager inputManager)
    {
        float touchX = inputManager.getTouchX(0);
        float touchY = inputManager.getTouchY(0);
        if (touchX != -1 && touchY != -1)
        {
            if ((touchX > rectangle.getX() && touchX < rectangle.getX() + rectangle.getWidth()) &&
                (touchY > rectangle.getY() && touchY < rectangle.getY() + rectangle.getHeight()))
            {
                inputManager.resetTouch(0);
                return true;
            }
        }
        return false;
    }

    public float getX() { return rectangle.getX(); }
    public float getY() { return rectangle.getY(); }
    public void setX(float x) { rectangle.setX(x); }
    public void setY(float y) { rectangle.setY(y); }
    public void addX(float x) { setX(getX()+x); }
    public void addY(float y) { setY(getY()+y); }

    public Rectangle getRectangle() { return rectangle; }
    public void setRectangle(Rectangle rectangle) { this.rectangle = rectangle; }
    public TextureRegion getImage() { return image; }
    public void setImage(TextureRegion image) { this.image = image; }
}
