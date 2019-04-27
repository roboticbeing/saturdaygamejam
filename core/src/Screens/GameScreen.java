package Screens;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.baseactor.BaseActor;
import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;

import tampongame.AudioStage;
import tampongame.TamponGame;


public class GameScreen extends BaseScreen {

    private Whirlpool[] whirlpools;
    private Rectangle[] whirlpoolsRects;
    private Tampon tampon;
    private Rectangle tamponRect;
    private BaseActor trash;
    private Rectangle trashRect;
    private BaseActor youWin;
    private boolean win;
    private final int NUM_WHIRLPOOLS = 6;
    private AudioStage audio;


    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
        Gdx.app.log("GameScreen", "Initialize");
    }
    public void initialize()
    {
        win = false;
        audio = new AudioStage();

        //TODO: Pull specific whirlpool quantity and location from level data
        whirlpools = new Whirlpool[NUM_WHIRLPOOLS];
        whirlpoolsRects = new Rectangle[NUM_WHIRLPOOLS];

        for (int i=0;i<whirlpools.length;i++){
            whirlpools[i]= new Whirlpool((float)Math.random()*(mainStage.getWidth() - 196),(float)Math.random()*(mainStage.getHeight() - 274),10000,mainStage);
            whirlpoolsRects[i] = new Rectangle(whirlpools[i].getX() + 100, whirlpools[i].getY() + 100, whirlpools[i].getWidth() / 6, whirlpools[i].getHeight() / 6);
        }

        trash = new BaseActor(0, 0, mainStage);
        trash.loadTexture("trash.png");
        trashRect = new Rectangle(0, 0, trash.getWidth() / 3, trash.getHeight() / 3);

        tampon = new Tampon(960,540, mainStage);
        tamponRect = new Rectangle(tampon.getX(), tampon.getY(), tampon.getWidth(), tampon.getHeight());

        youWin = new BaseActor(0, 0, mainStage);
        youWin.loadTexture("win.png");
        youWin.setSize(mainStage.getWidth(), mainStage.getHeight());
        youWin.setVisible(false);
    }

    public float CalculateAccelx(){
        float x_force=0;


        for (int i=0;i<whirlpools.length -1;i++) {

            float force =(float)( 0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.acos((whirlpools[i].getX() - tampon.getX())/Math.sqrt((Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2))));

            x_force = (float)( x_force + force*Math.cos(theta));
        }
        Gdx.app.log("Calculate x Accel",x_force+"");
        return x_force/tampon.getWeight();


    };
    public float CalculateAccely(){
        float y_force = 0;
        for (int i=0;i<whirlpools.length -1;i++) {
            float force =(float)( 0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.asin((whirlpools[i].getY() - tampon.getY())/Math.sqrt((Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2))));

            y_force = (float)( y_force + force*Math.sin(theta));
    }
        Gdx.app.log("Calculate y Accel",y_force+"");
        return y_force/tampon.getWeight();

    }


    @Override
    public void update(float dt) {
        float dVx = CalculateAccelx();
        float dVy = CalculateAccely();

        tampon.adjustSpeedx(dVx);
        tampon.adjustSpeedy(dVy);

            tamponRect.setX(tampon.getX());

            tamponRect.setY(tampon.getY());
            Gdx.app.log("Calculate x pos",tampon.getX()+"");
            Gdx.app.log("Calculate y pos",tampon.getY()+"");

            for (int i = 0; i < whirlpools.length; i++) {
                if (tamponRect.overlaps(whirlpoolsRects[i])) {
                    audio.flush();
                    TamponGame.setActiveScreen(new MenuScreen());
                }
            }

            if (tampon.getX() <= 0 || tampon.getX() >= mainStage.getWidth() - tampon.getWidth()) {
                tampon.setSpeedx(tampon.getSpeedx() * -1);
                audio.bounce();
            }
            if (tampon.getY() <= 0 || tampon.getY() >= mainStage.getHeight() - tampon.getHeight()) {
                tampon.setSpeedy(tampon.getSpeedy() * -1);
                audio.bounce();
            }
        if (tamponRect.overlaps(trashRect)) {
            audio.splat();
//            win = true;
            TamponGame.setActiveScreen(new WinScreen());
        }
    }

}
