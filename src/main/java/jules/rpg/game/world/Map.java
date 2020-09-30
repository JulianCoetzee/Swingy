package jules.rpg.game.world;

import jules.rpg.game.characters.Hero;

public class Map {

    private Hero hero;
    private int mapSize;
    private int mapLvl;
    private Pos[][] entities;
    private int x;
    private int y;

    public Map(Hero hero) {

        this.hero = hero;
        this.mapLvl = hero.getLvl();
        initMap();
        initHeroPos();
    }

    public int getMapSize() {

        return ((this.mapLvl - 1) * 5 + 10 - (this.mapLvl % 2));
    }

    private void initMap() {

        mapSize = getMapSize();
        this.x = 0;
        this.y = 0;

        while (x < mapSize)
            x++;
        
        while (y < mapSize)
            y++;
    }

    private void initHeroPos ()
    {
        int center = this.mapSize / 2;

        this.entities[center][center] = hero;
        this.hero.setPos(center, center);
    }

    public Pos getHero () {

        return hero;
    }

    private void updatePos (int newx, int newy, Pos pos) {

        int oldx = pos.getx();
        int oldy = pos.gety();

        this.entities[oldx][oldy] = new EmptyPos();
        this.entities[newx][newy] = pos;
        pos.setPos(newx, newy);
    }

    private void delEntity (Pos pos) {

        int x = pos.getx();
        int y = pos.gety();

        this.entities[x][y] = new EmptyPos();
    }
}