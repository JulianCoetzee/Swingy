package jules.rpg.control;

import jules.rpg.game.characters.*;
import jules.rpg.game.Game;
import jules.rpg.view.ViewContinue;

public class ContinueControl {
    
    private ViewContinue view;
    private Hero hero;
    private Game game;
    
    public ContinueControl(ViewContinue view) {
        this.view = view;
        game  = Game.getGame();
    }
    
    public void onClickLoad(String saveFile) {
        try
        {
            hero = Save.loadMe(saveFile);
            hero.validateHero();
        }
        catch (HeroNotValid  e) 
        {
            view.invalidHero(e.getMessage());
            return ;
        }
        game.initGame(hero);
        view.startGame();
    }

    // public void onClickDel(String name) {
    //     view.delChar();
    // }

    public void onClickBack() {
        view.retreat();
    }  
}