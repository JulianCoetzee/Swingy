package jules.rpg.console;

import java.util.*;

import jules.rpg.App;
import jules.rpg.control.GameControl;
import jules.rpg.game.Game;
import jules.rpg.game.world.Pos;
import jules.rpg.view.ViewGame;

public class ConsoleGame implements ViewGame {

    Scanner scanner;

    private GameControl control;
    
    @Override
    public void run() {

        control = new GameControl(this);
        control.openMap();
    }

    @Override
    public void printMap(boolean[][] map, Pos heroPos) {

        // int i = 0;
        // int j = 0;
        int ml = map.length;
        int heroPosx = heroPos.getx();
        int heroPosy = heroPos.gety();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("MAP %dx%d\n", ml, ml));

        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[i].length; j++) 
            {
                if (heroPosx == j && heroPosy == i)
                    sb.append("[H] ");
                else if (map[i][j])
                    sb.append("[X] ");
                else
                    sb.append("[ ] ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println("");
    }

    @Override
    public void updateMap(Game game) {

        System.out.println("Swingy Sword Console Mode");
        System.out.println("----------INFO----------");
        System.out.println(game.getHero().toString() +
                    "Position: " + "(" + game.getHeroPos().getx() +
                    "," + game.getHeroPos().gety() + ")");
        System.out.println("------------------------");

        printMap(game.getMap(), game.getHeroPos());
        userInput();
    }

    @Override
    public void encounterOption() {
        
        String input;

        System.out.println("You encountered an enemy!");
        System.out.println("FIGHT - to reolve combat");
        System.out.println("FLEE - to attempt to escape");
        System.out.println("");
        System.out.println("Fight or Flee?");
        System.out.println("");
        scanner = App.getScanner();
        while (scanner.hasNext())
        {   
            input = scanner.nextLine();
            if (input.toLowerCase().equals("fight"))
                control.fightclub();
            else if (input.toLowerCase().equals("flee"))
                control.fleeclub();
            else
            {
                System.out.println("Unknown command");
                System.out.println("FIGHT or FLEE?");
                System.out.println("");
            }
        }    
    }

    @Override
    public void endGameout() {
         
        System.out.println("");
        System.out.println("END");
        System.exit(1);
    }

    @Override
    public void showMsg(String message) {

        System.out.println("");
        System.out.println(message);
    }

    @Override
    public boolean newGear(String loot) {

        String input;

        System.out.println("");
        System.out.println("Would you like to equip " + loot + "?");
        System.out.println("EQUIP - to replace current slot");
        System.out.println("LEAVE - to ignore this gear");
        System.out.println("");
        System.out.println("Equip or leave?");
        System.out.println("");

        scanner = App.getScanner();
        while (scanner.hasNext())
        {
            input = scanner.nextLine();
            if (input.toLowerCase().equals("equip"))
                return true;
            else if (input.toLowerCase().equals("leave"))
                return false;
            else
            {
                System.out.println("");
                System.out.println("Unknown command");
                System.out.println("EQUIP or LEAVE?");
                System.out.println("");
            }    
        }
        return false;
    }

    @Override
    public void retreat() {

        new ConsoleStart().run();
    }
    
    private void userInput()
    {
        String input;

        System.out.println("NORTH, EAST, SOUTH, WEST");
        System.out.println("Directional Commands");
        System.out.println("");
        System.out.println("BACK - to return to start");
        System.out.println("");

        scanner = App.getScanner();
        while (scanner.hasNext())
        {
            input = scanner.nextLine();
            if (input.toLowerCase().equals("north") ||
                input.toLowerCase().equals("east") ||
                input.toLowerCase().equals("south") ||
                input.toLowerCase().equals("west"))
            {
                    control.moveMe(input);
                    break ;
            }
            else if (input.toLowerCase().equals("back"))
                control.onClickBack();
            else
            {
                System.out.println("");
                System.out.println("Unknown command");
                System.out.println("NORTH, EAST, SOUTH or WEST");
                System.out.println("");
            }
        }
    }
}
