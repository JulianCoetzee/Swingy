package jules.rpg.view;

import jules.rpg.game.Game;
import jules.rpg.game.world.Pos;

public interface ViewGame {

    void run();

    void printMap(boolean[][] map, Pos heroPos);
  
    void updateMap(Game game);

    void endGame();

    void showMsg(String message);

    void getVillian();

    void retreat(); 
}
