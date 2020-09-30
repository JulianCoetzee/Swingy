package jules.rpg.game.world;

public abstract class Pos {
    
    private int x;
    private int y;

    public Pos()
    {
        
    }

    public Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx() {
        return x;
    }
    
    public int gety() {
        return y;
    }
    
    public void setPos (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public abstract char getChar();
}