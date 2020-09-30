package jules.rpg.control;

import jules.rpg.view.ViewGame;
import jules.rpg.game.Game;

public class GameControl {

    private ViewGame view;
    private Game game;

    public GameControl(ViewGame view) {
        this.view = view;
        game = Game.getGame();
    }

    public void setGame() {
        view.printMap(game.getMap());
    }

    public void onPrintMap() {
        view.printMap(game.getMap());
        // view.updateMap(game);
    }

    public void moveMe(String move) {

    }
    
    public void onClickBack() {
        view.retreat();
    }
}