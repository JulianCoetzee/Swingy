package jules.rpg.game.characters;

public abstract class HeroMaker {

    private HeroMaker() {

    }

    // public HeroMaker getHM() {
    //     this.HM = new HeroMaker();

    //     return (this.HM);
    // }
    
    public static Hero makeWarrior(String name) {
        return (new Hero(name, "Warrior"));
    }

    public static Hero makeRanger(String name) {
        return (new Hero(name, "Ranger"));
    }

    public static Hero makeRogue(String name) {
        return (new Hero(name, "Rogue"));
    }
}