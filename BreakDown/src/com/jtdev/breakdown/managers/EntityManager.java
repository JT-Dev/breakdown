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
    private BackgroundManager backgroundManager;
    private WallManager wallManager;
    private Player player;

    public EntityManager()
    {
        this.player = new Player();
        this.backgroundManager = new BackgroundManager();
        this.wallManager = new WallManager();
    }

    public void update()
    {
        backgroundManager.update();
        wallManager.update();
        player.update();

        for (Wall wall : wallManager.getWallArray())
        {
            if (player.collides(wall))
            {
                player.collision(wall);
                wall.collision(player);
            }
        }
    }

    public void draw(SpriteBatch batch)
    {
        backgroundManager.draw(batch);
        wallManager.draw(batch);
        player.draw(batch);
    }

    public void debugDraw(ShapeRenderer shapeRenderer)
    {
        backgroundManager.debugDraw(shapeRenderer);
        wallManager.debugDraw(shapeRenderer);
        player.debugDraw(shapeRenderer);
    }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public BackgroundManager getBackgroundManager() { return backgroundManager; }
    public void setBackgroundManager(BackgroundManager backgroundManager) { this.backgroundManager = backgroundManager; }
    public WallManager getWallManager() { return wallManager; }
    public void setWallManager(WallManager wallManager) { this.wallManager = wallManager; }
}
