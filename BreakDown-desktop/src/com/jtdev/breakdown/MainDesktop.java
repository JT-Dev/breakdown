package com.jtdev.breakdown;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MainDesktop
{
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "BreakDown";
        //cfg.vSyncEnabled = true;
        cfg.addIcon(Constants.ICON_PATH, Files.FileType.Internal);
		cfg.useGL20 = false;
		cfg.width = 1300;
		cfg.height = 500;
		new LwjglApplication(new Main(), cfg);
	}
}
