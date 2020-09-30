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
            hero = HeroMaker.makeWarrior(name);
            hero.validateHero();
        }
        catch (HeroNotValid e) 
        {
            view.invalidHero(e.getMessage());
        }
        game.initGame(hero);
        view.startNewGame();
    }

    public void onClickRanger(String name) {
        try
        {
            hero = HeroMaker.makeRanger(name);
            hero.validateHero();
        }
        catch (HeroNotValid e) {
            view.invalidHero(e.getMessage());
        }
        game.initGame(hero);
        view.startNewGame();
    }

    public void onClickRogue(String name) {
        try
        {
            hero = HeroMaker.makeRogue(name);
            hero.validateHero();
        }
        catch (HeroNotValid  e) 
        {
            view.invalidHero(e.getMessage());
        }
        game.initGame(hero);
        view.startNewGame();
    }

    public void onClickBack() {
        view.retreat();
    }
}