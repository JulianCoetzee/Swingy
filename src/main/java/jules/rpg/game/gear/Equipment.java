package jules.rpg.game.gear;

public abstract class Equipment {

    protected String name;
    private int stats;
    
    public Equipment(String name, int stats)
    {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {

        return name;
    }

    public int getStats() {

        return stats;
    }

    @Override
    public String toString() {

        return (name + " +" + stats);
    }
}
