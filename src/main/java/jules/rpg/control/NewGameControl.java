package jules.rpg.control;

import jules.rpg.view.ViewNewGame;
import jules.rpg.game.Game;
import jules.rpg.game.characters.*;

public class NewGameControl {

    private ViewNewGame view;
    private HeroMaker HM;
    private Hero hero;
    private Game game;
    
    public NewGameControl(ViewNewGame view) {
        this.view = view;
        game  = Game.getGame();
    }
    
    public void onClickWar(String name) {
        try 
        {
            hero = HM.getHM().makeWarrior(name);
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
            hero = HM.getHM().makeRanger(name);
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
            hero = HM.getHM().makeRogue(name);
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