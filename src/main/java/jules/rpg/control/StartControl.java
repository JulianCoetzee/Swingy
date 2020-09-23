package jules.rpg.control;

import jules.rpg.view.ViewStart;

public class StartControl {

    private ViewStart view;
    
    public StartControl(ViewStart view) {
        this.view = view;
    }

    public void onClickNewGame() {
        view.newGame();
    }
    
    public void onClickContinue() {
        view.loadGame();
    }

    public void onClickKwit() {
        view.kwit();
    }
}