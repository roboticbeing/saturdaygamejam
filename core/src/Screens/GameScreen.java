package Screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;


public class GameScreen extends BaseScreen {

    private Whirlpool[] whirlpools;
    private Tampon tampon;
    private boolean win;


    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
        Gdx.app.log("GameScreen", "Initialize");
        initialize();
    }
    public void initialize()
    {
        //TODO: Pull specific whirlpool quantity and location from level data
        whirlpools = new Whirlpool[2];

        for (int i=0;i<whirlpools.length -1;i++){
            whirlpools[i]= new Whirlpool((float)Math.random()*1920,(float)Math.random()*1080,1000000,mainStage);
        }

        tampon = new Tampon(960,540,mainStage);
    }

    public float CalculateAccelx(){
        float x_force=0;


        for (int i=0;i<whirlpools.length -1;i++) {

            float force =(float)( -0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getX() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.atan((whirlpools[i].getY() - tampon.getY())/(whirlpools[i].getX() - tampon.getX()));

            x_force = (float)( x_force + force*Math.cos(theta));
        }
        Gdx.app.log("Calculate x Accel",x_force+"");
        return x_force/tampon.getWeight();


    };
    public float CalculateAccely(){
        float y_force = 0;
        for (int i=0;i<whirlpools.length -1;i++) {
            float force =(float)( -0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getX() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.atan((whirlpools[i].getY() - tampon.getY())/(whirlpools[i].getX() - tampon.getX()));

        y_force = (float)( y_force + force*Math.sin(theta));
    }
        Gdx.app.log("Calculate y Accel",y_force+"");
        return y_force/tampon.getWeight();

    }


    @Override
    public void update(float dt) {

       float dVx = CalculateAccelx();
       float dVy = CalculateAccely();

       tampon.setSpeedx(tampon.getSpeedx()+dVx);
        Gdx.app.log("Calculate x speed",tampon.getSpeedx()+"");
       tampon.setSpeedy(tampon.getSpeedy()+dVy);
        Gdx.app.log("Calculate y speed",tampon.getSpeedy()+"");

       tampon.setX(tampon.getX()+tampon.getSpeedx());

       tampon.setY(tampon.getY()+tampon.getSpeedy());
        Gdx.app.log("Calculate x pos",tampon.getX()+"");
        Gdx.app.log("Calculate y pos",tampon.getY()+"");
    }

}
