package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.baseactor.BaseActor;

import tampongame.TamponGame;

public class MenuScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor menu = new BaseActor(0, 0, mainStage);
        menu.loadTexture("menu2.png");
        menu.setSize(mainStage.getWidth(), mainStage.getHeight());
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Keys.X))
            TamponGame.setActiveScreen(new GameScreen());
    }
}
