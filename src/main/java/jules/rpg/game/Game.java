package jules.rpg.game;

import jules.rpg.control.GameControl;
import jules.rpg.game.characters.*;
import jules.rpg.game.world.*;

public class Game {

    private static Game gameI = null;
    private Hero hero;
    private Map map;

    private Game() {

    }

    public static Game getGame() {

        if (gameI == null)
            gameI = new Game();
        return (gameI);
    }

    public void initGame(Hero hero) {

        this.hero = hero;
        this.map = new Map(hero);
    }
    
    public Map getMap() {
        return (this.map);
    }

    public Hero getHero() {
        return (this.hero);
    }
    
}
