package com.mygdx.baseactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tampon extends BaseActor {
    public Tampon(float x, float y, Stage stage) {
        super(x, y, stage);
        String[] fileNames = {"tampon-1.png", "tampon-2.png", "tampon-3"};
//        loadAnimationFromFiles(fileNames, 0.1f, true);
        loadTexture("tampon.png");
    }

    public void act(float deltaTime) {
        super.act(deltaTime);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

        }
    }
}
