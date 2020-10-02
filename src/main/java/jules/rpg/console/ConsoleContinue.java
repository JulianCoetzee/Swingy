package jules.rpg.console;

import jules.rpg.App;
import jules.rpg.control.ContinueControl;
import jules.rpg.view.ViewContinue;

import java.util.*;
import java.io.*;

public class ConsoleContinue implements ViewContinue {
    
    private ContinueControl control;
    private Scanner scanner;
    // private List<String> charList;
    private File[] charFolder;

    @Override
    public void run() {
        control = new ContinueControl(this);

        userInput();
    }

    public void userInput() {

        String input;
        int i;

        scanner = App.getScanner();
        charFolder = new File("src/main/java/jules/rpg/charfiles").listFiles();
        // charList = new ArrayList<String>();

        System.out.println("");
        System.out.println("Swingy Sword Console Mode");
        System.out.println("BACK - to return to start");
        System.out.println("");
        System.out.println("Hero Reforge");
        System.out.println("");
        System.out.println("Select a Hero: (case sensitive)");
        System.out.println("");
        
        i = 0;
        while (i < charFolder.length)
        {
            if (charFolder[i].isFile())
            {
                // charList.add(charFolder[i].getName());
                System.out.println(charFolder[i].getName());
            }
            i++;
        }
        System.out.println();
        input = scanner.nextLine();
        i = 0;
        while (i < charFolder.length)
        {
            if (input.equals(charFolder[i].getName()) &&
                charFolder[i].isFile())
            {
                control.onClickLoad(input);
                break;
            }
            else if (input.toLowerCase().equals("back"))
            {
                control.onClickBack();
                break;
            }
            i++;
        }

        if (i >= charFolder.length)
        {
            System.out.println("Invalid Hero");
            new ConsoleContinue().run();
        }
    }

    @Override
    public void retreat() {

        new ConsoleStart().run();
    }

    @Override
    public void invalidHero(String err) {
        System.out.println(err);
        new ConsoleContinue().run();
    }

    @Override
    public void startGame() {
        
        new ConsoleGame().run();
    }
}
