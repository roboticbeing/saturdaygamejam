package Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;

public class GameScreen extends BaseScreen {

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
    }

    @Override
    public void initialize() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen", "Render");
        Gdx.app.log("GameScreen FPS", (1/delta) + "");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {

    }
}
