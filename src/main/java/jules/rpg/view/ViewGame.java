package jules.rpg.view;

import jules.rpg.game.Game;
import jules.rpg.game.world.Map;

public interface ViewGame {

    void run();

    void printMap(Map map);
  
    void updateMap(Game game);

    void endGame();

    void showMsg(String message);

    void getVillian();

    void retreat(); 
}
