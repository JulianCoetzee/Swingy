package jules.rpg.game.world;

public class Pos {
    
    private int x;
    private int y;

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

}