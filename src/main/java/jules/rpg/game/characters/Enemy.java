package jules.rpg.game.characters;

import jules.rpg.game.gear.*;

public class Enemy extends Entity {

    private Equipment loot;

    public Enemy(String name, int atk, int def, int hp, Equipment loot) {

        super(name, atk, def, hp);
        this.loot = loot;
    }

    public Equipment getLoot() {

        return loot;
    }  
}