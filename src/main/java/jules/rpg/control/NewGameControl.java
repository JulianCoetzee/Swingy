package jules.rpg.control;

import jules.rpg.view.ViewNewGame;
import jules.rpg.game.Game;
import jules.rpg.game.characters.*;

public class NewGameControl {

    private ViewNewGame view;
    private Hero hero;
    private Game game;
    
    public NewGameControl(ViewNewGame view) {
        this.view = view;
        game  = Game.getGame();
    }
    
    public void onClickWar(String name) {
        try 
        {
            hero = ForgeMe.newHero(name, "Warrior");
            hero.validateHero();
        }
        catch (HeroNotValid e) 
        {
            view.invalidHero(e.getMessage());
            return ;
        }
        game.initGame(hero);
        Save.saveMe(game.getHero());
        view.startNewGame();
    }

    public void onClickRanger(String name) {
        try
        {
            hero = ForgeMe.newHero(name, "Ranger");
            hero.validateHero();
        }
        catch (HeroNotValid e) 
        {
            view.invalidHero(e.getMessage());
            return ;
        }
        game.initGame(hero);
        Save.saveMe(game.getHero());
        view.startNewGame();
    }

    public void onClickRogue(String name) {
        try
        {
            hero = ForgeMe.newHero(name, "Rogue");
            hero.validateHero();
        }
        catch (HeroNotValid  e) 
        {
            view.invalidHero(e.getMessage());
            return ;
        }
        game.initGame(hero);
        Save.saveMe(game.getHero());
        view.startNewGame();
    }

    public void onClickBack() {
        view.retreat();
    }
}