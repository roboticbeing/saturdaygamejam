package tampongame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GameBeta extends Game {
    Stage mainStage;

    @Override
    public void create() {
        mainStage = new Stage();
        initialize();
    }

    public abstract void initialize();

    public void render() {


        float deltaTime = Gdx.graphics.getDeltaTime();
        mainStage.act(deltaTime);
        update(deltaTime);

        Gdx.app.log("GameScreen", "Render");
        Gdx.app.log("GameScreen FPS", (1/deltaTime) + "");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }

    public abstract void update(float deltaTime);
}
