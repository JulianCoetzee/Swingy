package jules.rpg.game.characters;

import java.util.concurrent.ThreadLocalRandom;

import javax.validation.constraints.*;

public abstract class Entity {

    @NotNull(message = "Name this thing")
    @Size(min = 1, max = 16)
    protected String name;

    @Min(value = 0, message = "Attack should not be less than 0")
    protected int atk;

    @Min(value = 0, message = "Defense should not be less than 0")
    protected int def;

    @Min(value = 1, message = "Hit points should not be less than 1")
    protected int hp;
    
    public Entity(String name, int atk, int def, int hp) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHP() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }


    public void attack(Entity vs) {

        int dmg;
        int luck;

        while (vs.getHP() > 0 && this.getHP() > 0)
        {
            luck = ThreadLocalRandom.current().nextInt(1, 7);
            if (this.atk > vs.def)
            {
                dmg = this.atk - vs.def;
                vs.setHP(vs.getHP() - dmg);
            }
            else if (luck > 5)
                vs.setHP(vs.getHP() - this.atk);
        }
    }

    public boolean fightMe(Entity vs) {

        while (vs.getHP() > 0 && this.getHP() > 0)
        {
            this.attack(vs);
            vs.attack(this);
        }
        return (this.getHP() > 0);
    }
}
