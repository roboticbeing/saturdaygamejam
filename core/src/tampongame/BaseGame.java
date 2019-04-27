package tampongame;

import com.badlogic.gdx.Game;

import Screens.BaseScreen;

public abstract class BaseGame extends Game {
    private static BaseGame game;

    public BaseGame() {
        game = this;
    }

    public static void setActiveScreen(BaseScreen screen) {
        game.setScreen(screen);
    }
}
