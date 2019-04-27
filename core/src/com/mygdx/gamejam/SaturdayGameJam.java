package com.mygdx.gamejam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SaturdayGameJam extends Game {
	SpriteBatch batch;
//	Texture img;
	
	@Override
	public void create () {
		Gdx.app.log("SaturdayGameJam", "created");
		setScreen(new GameScreen());
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
