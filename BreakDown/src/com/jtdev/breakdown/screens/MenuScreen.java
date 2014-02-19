package com.jtdev.breakdown.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.Main;
import com.jtdev.breakdown.managers.BackgroundManager;
import com.jtdev.breakdown.utils.Button;
import com.jtdev.breakdown.utils.InputManager;
import com.jtdev.breakdown.utils.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 17/02/14
 * Time: 8:37 AM
 */
public class MenuScreen implements Screen 
{
    private InputManager inputManager;
    private Button playButton;
    private Button creditButton;
    private Button musicButton;

    private SpriteBatch menuBatch;
    private BackgroundManager backgroundManager;
    private Logger log;

    private final Main main;

    public MenuScreen(Main main)
    {
        log = new Logger(this);
        this.main = main;

        menuBatch = new SpriteBatch();
        backgroundManager = main.getWorld().getEntityManager().getBackgroundManager();

        Texture playTexture = new Texture(Gdx.files.internal(Constants.PLAY_BUTTON_IMAGE_PATH));
        Texture creditTexture = new Texture(Gdx.files.internal(Constants.CREDIT_BUTTON_IMAGE_PATH));
        Texture musicTexture = new Texture(Gdx.files.internal(Constants.MUSIC_BUTTON_IMAGE_PATH));

        TextureRegion playImage = new TextureRegion(playTexture,Constants.PLAY_BUTTON_WIDTH,Constants.PLAY_BUTTON_HEIGHT);
        TextureRegion creditImage = new TextureRegion(creditTexture,Constants.CREDIT_BUTTON_WIDTH,Constants.CREDIT_BUTTON_HEIGHT);
        TextureRegion musicImage = new TextureRegion(musicTexture,Constants.MUSIC_BUTTON_WIDTH,Constants.MUSIC_BUTTON_HEIGHT);

        playButton = new Button(Constants.DEVICE_SCREEN_WIDTH / 2 - playImage.getRegionWidth() / 2, Constants.DEVICE_SCREEN_HEIGHT / 2 - playImage.getRegionHeight() / 2, playImage);
        creditButton = new Button(Constants.DEVICE_SCREEN_WIDTH / 2 - playImage.getRegionWidth() / 2 - creditImage.getRegionWidth() - 10, Constants.DEVICE_SCREEN_HEIGHT / 2 - playImage.getRegionHeight() / 2, creditImage);
        musicButton = new Button(Constants.DEVICE_SCREEN_WIDTH / 2 - playImage.getRegionWidth() / 2 + musicImage.getRegionWidth() + 10, Constants.DEVICE_SCREEN_HEIGHT / 2 - playImage.getRegionHeight() / 2, musicImage);

        inputManager = new InputManager();
        inputManager.setInputProcessor(true);
    }

    @Override
	public void render(float delta)
    {
        backgroundManager.update();
        if (playButton.isPressed(inputManager))
        {
            log.log("Play");
            main.setScreen(new GameScreen(main));
        }
        else if (creditButton.isPressed(inputManager))
        {
            log.log("Credits");
            //main.setScreen(new CreditScreen());
        }
        else if (musicButton.isPressed(inputManager))
        {
            log.log("Music");
            main.getWorld().toggleMusic();
            //main.setScreen(new MusicScreen());
        }

        main.getRenderer().render();

        menuBatch.begin();
        playButton.draw(menuBatch);
        creditButton.draw(menuBatch);
        musicButton.draw(menuBatch);
        menuBatch.end();
    }

    @Override
	public void resize(int width, int height)
    {
    }

    @Override
	public void show()
    {
        main.getWorld().toggleMusic();
    }

    @Override
	public void hide()
    {
    }

    @Override
	public void pause()
    {
    }

    @Override
	public void resume()
    {
    }

    @Override
	public void dispose()
    {
    }
}
