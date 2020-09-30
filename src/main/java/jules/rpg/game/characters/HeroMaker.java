package jules.rpg.game.characters;

public class HeroMaker {

    private HeroMaker HM;

    private HeroMaker() {

    }

    public HeroMaker getHM() {
        HM = new HeroMaker();

        return (HM);
    }
    
    public Hero makeWarrior(String name) {
        return (new Hero(name, "Warrior"));
    }

    public Hero makeRanger(String name) {
        return (new Hero(name, "Ranger"));
    }

    public Hero makeRogue(String name) {
        return (new Hero(name, "Rogue"));
    }
}