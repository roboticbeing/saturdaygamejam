package tampongame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import Screens.MenuScreen;

public class TamponGame extends BaseGame {
    Music menuMusic;
    @Override
    public void create() {
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("loop.wav"));
        menuMusic.setLooping(true);
        menuMusic.play();
        setActiveScreen(new MenuScreen());
    }
}
