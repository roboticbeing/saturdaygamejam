package com.mygdx.baseactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tampon extends BaseActor {

    private float weight = 1; //used for physics
    private float Vx = 0;
    private float Vy = 0;
    public Tampon(float x, float y, Stage stage) {

        super(x, y, stage);
        String[] fileNames = {"tampon-1.png", "tampon-2.png", "tampon-3.png", "tampon-2.png"};
        loadAnimationFromFiles(fileNames, 0.5f, true);
    }

    public void act(float deltaTime) {
        super.act(deltaTime);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.setX(this.getX() - 10);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.setX(this.getX() + 10);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.setY(this.getY() + 10);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.setY(this.getY() - 10);
        }
    }

    public float getWeight() {

        return weight;
    }

    public float getSpeedx(){
        return Vx;

    }

    public float getSpeedy(){
        return Vy;
    }

    public void setSpeedx(float Speedx){
        Vx = Speedx;
    }

    public void setSpeedy(float Speedy) {
        Vx = Speedy;
    }
}
