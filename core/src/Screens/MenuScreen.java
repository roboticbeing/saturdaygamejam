package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.baseactor.BaseActor;

import tampongame.TamponGame;

public class MenuScreen extends BaseScreen {
    BaseActor menu;

    @Override
    public void initialize() {
        menu = new BaseActor(0, 0, mainStage);
        menu.loadTexture("menu.png");
        menu.setSize(1300, 800);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Keys.X)) {
            Gdx.app.log("Menu Screen", "X pressed");
            TamponGame.setActiveScreen(new GameScreen());

            //menu.remove();

        }
    }
}