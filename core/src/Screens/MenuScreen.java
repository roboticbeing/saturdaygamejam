package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import tampongame.TamponGame;

public class MenuScreen extends BaseScreen {

    @Override
    public void initialize() {
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Keys.S))
            TamponGame.setActiveScreen(new GameScreen());
    }
}
