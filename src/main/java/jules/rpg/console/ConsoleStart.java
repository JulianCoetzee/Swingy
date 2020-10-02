package jules.rpg.console;

import jules.rpg.App;
import jules.rpg.control.StartControl;
import jules.rpg.view.ViewStart;

import java.util.*;

public class ConsoleStart implements ViewStart {

    private StartControl control;
    private Scanner scanner;

    @Override
    public void run() {

        control = new StartControl(this);

        userInput();
    }

    public void userInput() {

        String input;

        scanner = App.getScanner();
        
        System.out.println("");
        System.out.println("Swingy Sword Console Mode");
        System.out.println("Text based RPG");
        System.out.println("Start");
        System.out.println();
        System.out.println("COMMANDS:");
        System.out.println("(not case sensitive)");
        System.out.println();
        System.out.println("NEW - create a new character");
        System.out.println("CONTINUE - load a character");
        System.out.println("QUIT - to exit");
        System.out.println("");

        while (scanner.hasNext())
        {
            input = scanner.nextLine();

            if (input.toLowerCase().equals("new"))
            {
                control.onClickNewGame();
                break;
            }
            else if (input.toLowerCase().equals("continue"))
            {
                control.onClickContinue();
                break;
            }
            else if (input.toLowerCase().equals("quit"))
                control.onClickKwit();
            else
            {
                System.out.println("Unknown command");
                System.out.println("NEW, CONTINUE or QUIT");
            }
        }
    }

    @Override
    public void newGame() {

        new ConsoleNewGame().run();
    }

    @Override
    public void loadGame() {

        new ConsoleContinue().run();
    }

    @Override
    public void kwit() {

        System.exit(1);
    }
}
