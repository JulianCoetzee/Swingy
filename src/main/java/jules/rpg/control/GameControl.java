package jules.rpg.control;

import java.util.concurrent.ThreadLocalRandom;

import jules.rpg.view.ViewGame;
import jules.rpg.game.Game;
import jules.rpg.game.characters.*;
import jules.rpg.game.gear.*;
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

        view.updateMap(game);
    }

    public void onPrintMap() {

        view.printMap(game.getMap(), game.getHeroPos());
        view.updateMap(game);
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

        if (game.getMap()[y][x])
            encounterTime();

        if (game.getHero().getHP() > 0)
            view.updateMap(game);
        else if (game.getHero().getHP() <= 0)
            endGame("AbigFatL");
    }

    private void gainXP(int xp) {

        int lvl;

        lvl = game.getHero().getLvl();
        game.getHero().addxp(xp);
        if (lvl < game.getHero().getLvl())
            view.showMsg("Your might grows!\nYou have gained a level!");
    }

    private void endGame(String worl) {

        if (worl == "win")
        {
            int gains = game.getmapSize() * 100;
            view.showMsg("You win! You gained " + gains + "xp!");
            gainXP(gains);
            save();
            view.endGameout();
        }
        else if (worl == "AbigFatL")
        {
            view.showMsg("YOU DIED");
            view.endGameout();
        }
    }

    public void encounterTime() {

        view.encounterOption();
    }

    public void fightclub() {

        Enemy enemy;
        int xp;

        enemy = game.makeEnemy();
        xp = game.encounter(enemy);

        if (xp >= 0)
        {
            view.showMsg("Glory! You have slain the " + enemy.getName() + "!\nYou gain " + xp + "xp!");
            gainXP(xp);
            game.getMap()[game.getHeroPos().gety()][game.getHeroPos().getx()] = false;
            setLootGear(enemy.getLoot());
            view.updateMap(game);
        }
        else
            endGame("AbigFatL");
    }

    public void fleeclub() {

        int Esc;
        
        Esc = ThreadLocalRandom.current().nextInt(0, 2);
        if (Esc == 1)
        {
            view.showMsg("You have fled.\nYou retreat to your previous position");
            game.getHeroPos().setPos(current.getx(), current.gety());
            view.updateMap(game);
        }
        else
        {
            view.showMsg("There is no Esc");
            fightclub();
        }
    }

    private void setLootGear(Equipment loot) {
        if (loot != null)
        {
            if (loot instanceof Armor)
            {
                if (game.getHero().getArmor() == null ||
                    view.newGear("Current Armor: " + game.getHero().getArmor() + "\n Loot:" + loot))
                    {
                        game.getHero().equipArmor((Armor) loot);
                        view.showMsg("Equipped" + loot.getName() + ".");
                    }
            }
            else if (loot instanceof Helmet)
            {
                if (game.getHero().getHelmet() == null ||
                    view.newGear("Current Helmet: " + game.getHero().getHelmet() + "\n Loot:" + loot))
                    {
                        game.getHero().equipHelmet((Helmet) loot);
                        view.showMsg("Equipped" + loot.getName() + ".");
                    }
            }
            else if (loot instanceof Sword)
            {
                if (game.getHero().getSword() == null ||
                    view.newGear("Current Sword: " + game.getHero().getSword() + "\n Loot:" + loot))
                    {
                        game.getHero().equipSword((Sword) loot);
                        view.showMsg("Equipped" + loot.getName() + ".");
                    }
            }
        }
    }

    private void save() {
        Hero hero = game.getHero();
        Save.saveMe(hero);
    }
    
    public void onClickBack() {
        view.retreat();
    }
}