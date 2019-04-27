package com.mygdx.baseactor;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tampon extends BaseActor {
    public Tampon(float x, float y, Stage stage) {
        super(x, y, stage);
        String[] fileNames = {"tampon-1.png", "tampon-2.png", "tampon-3"};
        loadAnimationFromFiles(fileNames, 0.1f, true);
    }
}
