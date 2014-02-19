package com.jtdev.breakdown.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.entities.Wall;
import com.jtdev.breakdown.utils.Logger;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 16/02/14
 * Time: 12:25 PM
 */
public class WallManager
{
    ArrayList<Wall> wallArray;
    ArrayList<Wall> removeWallArray;
    private TextureRegion image;
    private long oldTime;
    private int timeOut;
    private Logger log;

    public WallManager()
    {
        log = new Logger(this);
        wallArray = new ArrayList<Wall>();
        removeWallArray = new ArrayList<Wall>();

        oldTime = 0;
        timeOut = Constants.WALL_INITIAL_TIMEOUT;

        Texture texture = new Texture(Gdx.files.internal(Constants.WALL_IMAGE_PATH));
        image = new TextureRegion(texture, Constants.WALL_WIDTH, Constants.WALL_HEIGHT);
    }

    public void update()
    {
        for (Wall wall : wallArray)
        {
            wall.update();
            if (wall.isOutOfScreen()) removeWallArray.add(wall);
        }

        //TODO Vary timeout based on distance travelled
        if (TimeUtils.millis() - oldTime > timeOut && MathUtils.random() < Constants.WALL_SPAWN_RATE && wallArray.size() < 2) createWall();

        for (Wall wall : removeWallArray) wallArray.remove(wall);
        removeWallArray.clear();
    }

    private void createWall()
    {
        log.log("Making Wall");
        float x,y;
        Wall wall;
        do
        {
            x = MathUtils.random(Constants.DEVICE_SCREEN_WIDTH, Constants.DEVICE_SCREEN_WIDTH + Constants.WALL_SPAWN_RANGE);
            y = 0;
            wall = new Wall(x,y,image);
            //TODO Vary speed based on distance travelled
            wall.setSpeed(-Constants.WALL_SPEED);
        }
        while (collides(wall));

        wallArray.add(wall);
        oldTime = TimeUtils.millis();
    }

    private boolean collides(Wall wall)
    {
        for (Wall otherWall : wallArray)
        {
            if (!wall.equals(otherWall))
            {
                if (wall.collides(otherWall)) return true;
            }
        }
        return false;
    }

    public void draw(SpriteBatch batch)
    {
        for (Wall wall: wallArray) wall.draw(batch);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        for (Wall wall: wallArray) wall.debugDraw(shapeRenderer);
    }

    public ArrayList<Wall> getWallArray() { return wallArray; }
    public void setWallArray(ArrayList<Wall> wallArray) { this.wallArray = wallArray; }
}
