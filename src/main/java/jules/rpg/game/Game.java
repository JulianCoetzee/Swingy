package jules.rpg.game;

import jules.rpg.game.characters.*;
import jules.rpg.game.world.*;

public class Game {

    private static Game gameI = null;
    
    private Hero hero;
    private Pos heroPos;
    private int mapSize;
    private boolean[][] map;

    private Game() {

    }

    public static Game getGame() {

        if (gameI == null)
            gameI = new Game();
        return (gameI);
    }

    public void initGame(Hero hero) {

        this.hero = hero;
        makeMap(hero);
        initHeroPos();
    }
 
    private void makeMap(Hero hero) {

        int mapLvl;
        
        mapLvl = hero.getLvl();
        mapSize = calcMapSize(mapLvl);
        map = new boolean[mapSize][mapSize];
    }

    public int calcMapSize(int lvl) {

        return ((lvl - 1) * 5 + 10 - (lvl % 2));
    }

    private void initHeroPos ()
    {
        int center = this.mapSize / 2;

        heroPos = new Pos(center, center);
        map[heroPos.getx()][heroPos.gety()] = false;
    }

    public Hero getHero() {

        return (hero);
    }

    public Pos getHeroPos() {

        return (heroPos);
    }

    public boolean[][] getMap() {

        return (map);
    }

    public int getmapSize() {
        return (mapSize);
    }

    public void setHero(Hero hero) {

        this.hero = hero;
    }
    
    public void setHeroPos(Pos heroPos) {

        this.heroPos = heroPos;
    }

    public void setMap(boolean[][] map) {

        this.map = map;
    }
}
