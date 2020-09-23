package jules.rpg.control;

import jules.rpg.view.ViewNewGame;

public class NewGameControl {

    private ViewNewGame view;
    
    public NewGameControl(ViewNewGame view) {
        this.view = view;
    }
    
    public void onClickWar(String name) {
        view.makeWarrior();
    }

    public void onClickRanger(String name) {
        view.makeRanger();
    }

    public void onClickRogue(String name) {
        view.makeRogue();
    }

    public void onClickBack() {
        view.retreat();
    }
}