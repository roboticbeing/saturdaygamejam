package Screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;


public class GameScreen extends BaseScreen {

    private Whirlpool[] whirlpools;
    private Tampon tampon;
    private boolean win;


    public GameScreen() {
        initialize();
        Gdx.app.log("GameScreen", "Attached");

    }
    public void initialize()
    {
        //TODO: Pull specific whirlpool quantity and location from level data
        for (int i=0;i<10;i++){
            whirlpools[i]= new Whirlpool(x,y,mainStage);
        }

        tampon = new Tampon(x,y,mainStage);
    }

    public float CalculateAccelx(){
        float x_force=0;


        for (int i=0;i<10;i++) {

            float force = -0.6 * tampon.getWeight() * whirlpools[i].getWeight / (Math.pow((whirlpools[i].getOriginY() - tampon.getOriginY()),2) + Math.pow((whirlpools[i].getOriginX() - tampon.getOriginX()),2));
            float theta = (float)Math.atan((whirlpools[i].getOriginY() - tampon.getOriginY())/(whirlpools[i].getOriginX() - tampon.getOriginX()));

            x_force = (float)( x_force + force*Math.cos(theta));
        }
            return x_force/tampon.getWeight();

    };
    public float CalculateAccely(){
        float y_force = 0;
        for (int i=0;i<10;i++) {
            float force = -0.6 * tampon.getWeight() * whirlpools[i].getWeight / (Math.pow((whirlpools[i].getOriginY() - tampon.getOriginY()),2) + Math.pow((whirlpools[i].getOriginX() - tampon.getOriginX()),2));
            float theta = (float)Math.atan((whirlpools[i].getOriginY() - tampon.getOriginY())/(whirlpools[i].getOriginX() - tampon.getOriginX()));

        y_force = (float)( y_force + force*Math.sin(theta));
    }
        return y_force/tampon.getWeight();

    }


    @Override
    public void update(float dt) {

       float dVx = CalculateAccelx();
       float dVy = CalculateAccely();

       tampon.setSpeedx(tampon.getSpeedx+dVx);
       tampon.setSpeedy(tampon.getSpeedy+dVy);

       tampon.setOriginX();
    }


    /*
    private Tampon tampon;
    private boolean win;
    public void initialize()
    {
// code identical to StarfishCollector initialize method
    }
    public void update(float dt)
    {
// code identical to StarfishCollector update method
    }
    */
}
