package com.jtdev.breakdown.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.entities.Player;
import com.jtdev.breakdown.entities.Wall;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 15/10/13
 * Time: 9:42 AM
 */
public class EntityManager
{
    private Player player;
    private BackgroundManager backgroundManager;
    private ArrayList<Wall> wallArray;
    private ArrayList<Wall> removeWallArray;

    public EntityManager()
    {
        this.player = new Player();
        this.backgroundManager = new BackgroundManager();
        wallArray = new ArrayList<Wall>();
        removeWallArray = new ArrayList<Wall>();

        //if (Constants.DEBUG_DRAW) createWall(0,0);
    }

    public void update()
    {
        backgroundManager.update();
        player.update();
        for (Wall wall : wallArray)
        {
            wall.update();
            if (wall.isOutOfScreen()) removeWallArray.add(wall);
        }

        for (Wall wall : wallArray)
        {
            if (player.collides(wall))
            {
                player.collision(wall);
                wall.collision(player);
            }
        }

        for (Wall wall : removeWallArray) wallArray.remove(wall);
        removeWallArray.clear();
    }

    public void draw(SpriteBatch batch)
    {
        backgroundManager.draw(batch);
        player.draw(batch);
        for (Wall wall: wallArray) wall.draw(batch);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        backgroundManager.debugDraw(shapeRenderer);
        player.debugDraw(shapeRenderer);
        for (Wall wall: wallArray) wall.debugDraw(shapeRenderer);
    }

    private void createWall(Camera camera)
    {
        float cameraX1 = (camera.position.x - camera.viewportWidth / 2);
        float cameraY1 = (camera.position.y - camera.viewportHeight / 2);
        float cameraX2 = (camera.position.x + camera.viewportWidth / 2);
        float cameraY2 = (camera.position.y + camera.viewportHeight / 2);

        float x,y;
        do
        {
            x = MathUtils.random(cameraX1 - Constants.WALL_SPAWN_RANGE, cameraX2 + Constants.WALL_SPAWN_RANGE);
            y = MathUtils.random(cameraY1 - Constants.WALL_SPAWN_RANGE, cameraY2 + Constants.WALL_SPAWN_RANGE);
        }
        while (x < cameraX1 && x > cameraX2 && y < cameraY1 && y > cameraY2);

        Wall wall = new Wall();
        wallArray.add(wall);
    }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public BackgroundManager getBackgroundManager() { return backgroundManager; }
    public void setBackgroundManager(BackgroundManager backgroundManager) { this.backgroundManager = backgroundManager; }
    public ArrayList<Wall> getWallArray() { return wallArray; }
    public void setWallArray(ArrayList<Wall> wallArray) { this.wallArray = wallArray; }
}
