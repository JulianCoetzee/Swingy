package jules.rpg.game;

import java.util.concurrent.ThreadLocalRandom;

import jules.rpg.game.characters.*;
import jules.rpg.game.gear.*;
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

        setHero(hero);
        makeMap(hero);
        seedEnemies();
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
        setHeroPos(heroPos);
        map[heroPos.getx()][heroPos.gety()] = false;
    }

    private Equipment makeLoot() {
        
        int lootluck;
        int typeluck;
        Equipment loot;
        String[] hat = {"Bucket", "GuardCap", "Helm"};
        String[] blade = {"Knife", "Gladius", "Glamdring"};
        String[] shirt = {"Belt", "Leather", "DrakeSkin"};

        lootluck = ThreadLocalRandom.current().nextInt(1, 21);
        typeluck = ThreadLocalRandom.current().nextInt(1, 3) - 1;
        loot = null;
        if (lootluck > 10 && lootluck < 14)
        {
            loot = new Helmet(hat[typeluck], ThreadLocalRandom.current().nextInt(1, 9 * (hero.getLvl() + 1)));
        }
        else if (lootluck > 13 && lootluck < 17)
        {
            loot = new Armor(shirt[typeluck], ThreadLocalRandom.current().nextInt(1, 5 * (hero.getLvl() + 1)));
        }
        else if (lootluck > 17 && lootluck < 21)
        {
            loot = new Sword(blade[typeluck], ThreadLocalRandom.current().nextInt(1, 7 * (hero.getLvl() + 1)));
        }
        return loot;
    }

    public Enemy makeEnemy() {

        String[] type = {"Goblin", "Orc", "Demon", "Kobold", "Werewolf"};
        int atk;
        int def;
        int hp;
        int typeSelect;
        Equipment loot;

        atk = ThreadLocalRandom.current().nextInt(hero.getAtk() - 15, hero.getAtk() + 2 * hero.getLvl());
        def = ThreadLocalRandom.current().nextInt(hero.getDef() - 15, hero.getDef() + 2 * hero.getLvl());
        hp = ThreadLocalRandom.current().nextInt(hero.getHP() - 30, hero.getHP() + 5 * hero.getLvl());
        typeSelect = ThreadLocalRandom.current().nextInt(1, 6) - 1;
        loot = makeLoot();

        return new Enemy(type[typeSelect], atk, def, hp, loot);
    }

    private void seedEnemies() {
        
        int i;
        int j;
        int seed;
        int mapLvl;
        
        i = 0;
        j = 0;
        mapLvl = hero.getLvl();
        while (i < mapSize)
        {
            while (j < mapSize)
            {
                seed = ThreadLocalRandom.current().nextInt(0, 101);
                if (seed <= (mapLvl + 1) * 10)
                    map[i][j] = true;
                j++;
            }
            i++;
        }
    }

    public int encounter(Entity enemy) {

        int xpgains;

        xpgains = enemy.getAtk() + enemy.getDef() + enemy.getHP();

        if (hero.fightMe(enemy))
            return xpgains;
        else
            return (-1);
    }

    public Hero getHero() {

        return (hero);
    }

    public Pos getHeroPos() {

        return (this.heroPos);
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
