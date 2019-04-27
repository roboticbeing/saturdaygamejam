package com.mygdx.gamejam;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Screens.GameScreen;


public class SaturdayGameJam extends Game {
	SpriteBatch batch;
//	Texture img;
	
	@Override
	public void create () {
		Gdx.app.log("SaturdayGameJam", "created");
		setScreen(new GameScreen());
	}
}
