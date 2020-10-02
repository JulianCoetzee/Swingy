package jules.rpg.console;

import jules.rpg.App;
import jules.rpg.control.NewGameControl;
import jules.rpg.view.ViewNewGame;

import java.util.*;

public class ConsoleNewGame implements ViewNewGame{
    
    private NewGameControl control;
    private Scanner scanner;

    @Override
    public void run() {
        control = new NewGameControl(this);

        userInput();
    }

    public void userInput() {

        String name;
		String type;

        scanner = App.getScanner();
        
        System.out.println("");
        System.out.println("Swingy Sword Console Mode");
        System.out.println("BACK - to return to start");
        System.out.println("");
        System.out.println("Hero Forge");
        System.out.println("");
        System.out.println("Hero name: ");
        System.out.println("");
        name = scanner.nextLine();
        if (name.toLowerCase().equals("back"))
        {
            control.onClickBack();
        }
        System.out.println("Class      Attack  Defense HP\n" +
        "WARRIOR    20      30      100\n" +
        "RANGER     30      20      100\n" +
        "ROGUE      30      30      80\n");
        System.out.println("Hero class: ");
        System.out.println("(not case sensitive)");
        System.out.println("");
        type = scanner.nextLine();
        if (type.toLowerCase().equals("back"))
        {
            control.onClickBack();
        }
        else if (type.toLowerCase().equals("warrior"))
        {
            control.onClickWar(name);
        }
        else if (type.toLowerCase().equals("ranger"))
        {
            control.onClickRanger(name);
        }
        else if (type.toLowerCase().equals("rogue"))
            control.onClickRogue(name);
        else
            System.out.println("Invalid command");
    }

    public void startNewGame() {
        new ConsoleGame().run();
    }

    @Override
    public void invalidHero(String err) {
        System.out.println(err);
        new ConsoleNewGame().run();
    }

    @Override
    public void retreat() {
        new ConsoleStart().run();
    }
}