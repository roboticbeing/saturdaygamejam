package Screens;

public class MenuScreen {
    private static final MenuScreen ourInstance = new MenuScreen();

    public static MenuScreen getInstance() {
        return ourInstance;
    }

    private MenuScreen() {
    }
}
