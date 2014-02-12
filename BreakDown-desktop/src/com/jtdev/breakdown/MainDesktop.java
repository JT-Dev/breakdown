package com.jtdev.breakdown;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MainDesktop
{
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Break Down";
        //cfg.vSyncEnabled = true;
		cfg.useGL20 = false;
		cfg.width = 680;
		cfg.height = 380;
		
		new LwjglApplication(new Main(), cfg);
	}
}
