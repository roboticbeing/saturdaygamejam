package tampongame;

import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;

public class TamponGame extends GameBeta {
    Whirlpool whirlpool;
    Tampon tampon;

    @Override
    public void initialize() {
        whirlpool = new Whirlpool(20, 20, mainStage);
//        tampon = new Tampon(300, 300, mainStage);
    }

    @Override
    public void update(float deltaTime) {
        // add later
    }
}
