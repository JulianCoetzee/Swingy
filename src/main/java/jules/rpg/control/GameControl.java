package jules.rpg.control;

import jules.rpg.view.ViewGame;
import jules.rpg.game.Game;
import jules.rpg.game.world.Pos;

public class GameControl {

    private ViewGame view;
    private Game game;
    private Pos current;

    public GameControl(ViewGame view) {
        this.view = view;
        game = Game.getGame();
        current = new Pos(0, 0);
    }

    public void openMap() {
        view.printMap(game.getMap(), game.getHeroPos());
    }

    public void onPrintMap() {
        view.printMap(game.getMap(), game.getHeroPos());
        // view.updateMap(game);
    }

    public void moveMe(String move) {

        int x;
        int y;

        x = game.getHeroPos().getx();
        y = game.getHeroPos().gety();
        current.setPos(x, y);

        if (move.toLowerCase().equals("north"))
            y--;
        else if (move.toLowerCase().equals("east"))
            x++;
        else if (move.toLowerCase().equals("south"))
            y++;
        else if (move.toLowerCase().equals("west"))
            x--;
        else
            return ;
        
        if (x < 0 || x >= game.getmapSize() || y < 0 || y >= game.getmapSize())
        {
            endGame("win");
            return ;
        }

        game.getHeroPos().setPos(x, y);

        if (game.getHero().getHP() > 0);
            view.updateMap(game);
    }

    private void endGame(String worl) {
        
    }
    
    public void onClickBack() {
        view.retreat();
    }
}