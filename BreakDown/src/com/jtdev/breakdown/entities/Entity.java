package com.jtdev.breakdown.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 22/10/13
 * Time: 1:36 PM
 */
public interface Entity
{
    //public void update();
    public void draw(SpriteBatch batch);
    
    public float getX();
    public float getY();
    public void setX(float x);
    public void setY(float y);
    public void addX(float x);
    public void addY(float y);
    public float getVx();

    public float getVy();
    public void setVx(float vx);
    public void setVy(float vy);
    public void addVx(float vx);
    public void addVy(float vy);

    public float getSpeed();
    public void setSpeed(float speed);
    public void addSpeed(float speed);

    public float getWidth();
    public float getHeight();

    public Sprite getSprite();
    public Rectangle getRectangle();
    public boolean collides(Entity otherEntity);
    public void collision(Entity otherEntity);
}
