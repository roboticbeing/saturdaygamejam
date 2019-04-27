package tampongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class AudioStage {
    Music flush;
    Music splat;
    Music bounce;

    public AudioStage() {
        flush = Gdx.audio.newMusic(Gdx.files.internal("flush.wav"));
        flush.setVolume(0.4f);
        splat = Gdx.audio.newMusic(Gdx.files.internal("splat.wav"));
        bounce = Gdx.audio.newMusic(Gdx.files.internal("bounce.wav"));
    }
    public void flush() {

        flush.play();

    }
    public void splat() {
        splat.play();
    }

    public void bounce() {
        bounce.play();
    }
}
