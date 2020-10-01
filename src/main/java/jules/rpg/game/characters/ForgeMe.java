package jules.rpg.game.characters;

public abstract class ForgeMe {

    public static Hero newHero(String name, String type) {

        if (type.toLowerCase().equals("warrior"))
        {
            return (HeroSmith.forgeWarrior(name));
        }
        else if (type.toLowerCase().equals("ranger"))
        {
            return (HeroSmith.forgeRanger(name));
        }
        else if (type.toLowerCase().equals("rogue"))
        {
            return (HeroSmith.forgeRogue(name));
        }
        else
            throw new IllegalArgumentException("Hero TYPE invalid. Only Warrior, Ranger OR Rogue");
    }
}