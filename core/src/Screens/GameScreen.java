package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;


public class GameScreen extends BaseScreen {

    private Whirlpool[] whirlpools;
    private Tampon tampon;
    private boolean win;


    public GameScreen() {
        Gdx.app.log("GameScreen", "Constructor");
    }
    public void initialize()
    {
        //TODO: Pull specific whirlpool quantity and location from level data
        whirlpools = new Whirlpool[1];

        for (int i=0;i<whirlpools.length;i++){
            whirlpools[i]= new Whirlpool(960,540,10000,mainStage);
        }

        tampon = new Tampon(0,0,mainStage);
    }

    public float CalculateAccelx(){
        float x_force=0;


        for (int i=0;i<whirlpools.length;i++) {

            float force =(float)( -0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.acos((whirlpools[i].getX() - tampon.getX())/(Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));

            x_force = (float)( x_force + force*Math.cos(theta));
            Gdx.app.log("WhirlPool#",i+"");
            Gdx.app.log("Calculate force",force+"");
            Gdx.app.log("Calculate theta",theta+"");
        }
        Gdx.app.log("Calculate x Accel",x_force+"");
        return x_force/tampon.getWeight();


    };
    public float CalculateAccely(){
        float y_force = 0;
        for (int i=0;i<whirlpools.length;i++) {
            float force =(float)(- 0.6 * tampon.getWeight() * whirlpools[i].getWeight() / (Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));
            float theta = (float)Math.asin((whirlpools[i].getY() - tampon.getY())/(Math.pow((whirlpools[i].getY() - tampon.getY()),2) + Math.pow((whirlpools[i].getX() - tampon.getX()),2)));

        y_force = (float)( y_force + force*Math.sin(theta));
    }
        Gdx.app.log("Calculate y Accel",y_force+"");
        return y_force/tampon.getWeight();

    }


    @Override
    public void update(float dt) {

       // tampon.setSpeedx(10);
       // tampon.setX(tampon.getX()+tampon.getSpeedx());
       float dVx = CalculateAccelx();
       float dVy = CalculateAccely();

       tampon.adjustSpeedx(dVx);
       tampon.adjustSpeedy(dVy);
        //Gdx.app.log("Calculate x speed",tampon.getSpeedx()+"");
       //tampon.setSpeedy(tampon.getSpeedy()+dVy);
       // Gdx.app.log("Calculate y speed",tampon.getSpeedy()+"");

     //  tampon.setX(tampon.getX()+tampon.getSpeedx());

       //tampon.setY(tampon.getY()+tampon.getSpeedy());
      //  Gdx.app.log("Calculate x pos",tampon.getX()+"");
       // Gdx.app.log("Calculate y pos",tampon.getY()+"");
    }

}
