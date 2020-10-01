package jules.rpg.game.characters;

public class HeroForge {

    private String name;
    private int atk;
    private int def;
    private int hp;
    private String type;
    private int lvl;
    private int xp;

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

    public void setType(String type) {
        this.type = type;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setxp(int xp) {
        this.xp = xp;
    }

    public Hero getHero() {
        return new Hero(name, atk, def, hp, type, lvl, xp);
    }
}