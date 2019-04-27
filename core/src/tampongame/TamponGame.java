package tampongame;

import com.mygdx.baseactor.Tampon;
import com.mygdx.baseactor.Whirlpool;

import Screens.MenuScreen;

public class TamponGame extends BaseGame {
    @Override
    public void create() {
        setActiveScreen(new MenuScreen());
    }
}
