package com.mygdx.baseactor;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Whirlpool extends BaseActor {

    private float weight;   //used for physics

    public Whirlpool(float x, float y, float w, Stage stage) {
        super(x, y, stage);
        weight = w;
        loadTexture("whirlpool.png");

        Action spin = Actions.rotateBy(30, 1);
        this.addAction(Actions.forever(spin));
    }
    public float getWeight(){
        return weight;
    }
}
