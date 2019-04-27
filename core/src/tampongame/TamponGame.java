package tampongame;

import Screens.MenuScreen;

public class TamponGame extends BaseGame {
    @Override
    public void create() {
        setActiveScreen(new MenuScreen());
    }
}
