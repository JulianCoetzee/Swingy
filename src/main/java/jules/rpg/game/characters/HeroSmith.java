package jules.rpg.game.characters;

public abstract class HeroSmith {

    private static HeroForge forgeNew(String name) {

        HeroForge hf = new HeroForge();
        hf.setName(name);
        hf.setLvl(0);
        hf.setxp(0);

        return hf;
    }
    
    public static Hero forgeWarrior(String name) {

        HeroForge hf = forgeNew(name);
        hf.setAtk(20);
        hf.setDef(30);
        hf.setHP(120);
        hf.setType("Warrior");

        return (hf.getHero());
    }

    public static Hero forgeRanger(String name) {

        HeroForge hf = forgeNew(name);
        hf.setAtk(30);
        hf.setDef(20);
        hf.setHP(100);
        hf.setType("Ranger");

        return (hf.getHero());
    }

    public static Hero forgeRogue(String name) {

        HeroForge hf = forgeNew(name);
        hf.setAtk(30);
        hf.setDef(30);
        hf.setHP(80);
        hf.setType("Rogue");

        return (hf.getHero());
    }
}