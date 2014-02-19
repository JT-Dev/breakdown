package com.jtdev.breakdown.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.utils.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 30/07/13
 * Time: 11:27 AM
 */
public class Wall implements Entity
{
    private float vx, vy, speed;

    private Color color;
    private Logger logger;
    private Sprite sprite;

    public Wall(float x, float y, TextureRegion image)
    {
        logger = new Logger(this);

        sprite = new Sprite(image);
        sprite.setSize(Constants.WALL_WIDTH, Constants.WALL_HEIGHT);
        sprite.setPosition(x,y);
        vx = vy = speed = 0;
    }

    public void update()
    {
        addX(speed);
    }

    public void draw(SpriteBatch batch)
    {
        sprite.draw(batch);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(getColor());
        shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
        shapeRenderer.end();
    }

    public boolean collides(Entity otherEntity)
    {
        return getRectangle().overlaps(otherEntity.getRectangle());
    }

    public void collision(Entity otherEntity)
    {
        logger.log("Wall Collision");
    }

    public Rectangle getRectangle() { return sprite.getBoundingRectangle(); }

    public float getX() { return sprite.getX(); }
    public float getY() { return sprite.getY(); }
    public void setX(float x) { sprite.setX(x); }
    public void setY(float y) { sprite.setY(y); }
    public void addX(float x) { setX(getX()+x); }
    public void addY(float y) { setY(getY()+y); }

    public float getSpeed() { return speed; }
    public void setSpeed(float speed) { this.speed = speed; }
    public void addSpeed(float speed) { setSpeed(getSpeed() + speed); }

    public float getWidth() { return sprite.getWidth(); }
    public float getHeight() { return sprite.getHeight(); }
    public Sprite getSprite() { return sprite; }

    public Color getColor() { return color; }

    public boolean isOutOfScreen() { return getX()+getWidth() < 0; }
}
