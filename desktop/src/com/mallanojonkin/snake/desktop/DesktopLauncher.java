package com.mallanojonkin.snake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mallanojonkin.snake.ChristmasSnake;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ChristmasSnake";
		config.useGL30 = true;
		config.width = 1024;
		config.height = 768;
		config.foregroundFPS = 60;
		new LwjglApplication(new ChristmasSnake(), config);
	}
}
