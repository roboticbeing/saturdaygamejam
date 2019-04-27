package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.baseactor.BaseActor;

import tampongame.TamponGame;

public class MenuScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor menu = new BaseActor(0, 0, mainStage);
        menu.loadTexture("menu.png");
        menu.setSize(1300, 800);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Keys.X))
            TamponGame.setActiveScreen(new GameScreen());
    }
}
