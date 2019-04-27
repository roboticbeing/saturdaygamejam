package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.baseactor.BaseActor;

import tampongame.TamponGame;

public class WinScreen extends BaseScreen {
    @Override
    public void initialize() {
        BaseActor menu = new BaseActor(0, 0, mainStage);
        menu.loadTexture("win.png");
        menu.setSize(mainStage.getWidth(), mainStage.getHeight());
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.X))
            TamponGame.setActiveScreen(new GameScreen());
    }
}
