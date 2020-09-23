package jules.rpg;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import jules.rpg.gui.GuiStart;
import jules.rpg.console.ConsoleStart;

public class App {
    // gui/console element init
    private static JFrame frame;
    private static Scanner scanner;

    public static void main(String[] args) {
        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
            System.exit(1);
        }

        if (args[0].equals("gui"))
            new GuiStart().run();
        else if (args[0].equals("console"))
                new ConsoleStart().run();
        }

    //gui display/window behaviour
    public static JFrame getFrame() {
        if (frame == null) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frameListener();
        }
        return frame;
    }

    public static void showFrame() {
        if (frame != null)
            frame.setVisible(true);
    }

    public static void hideFrame() {
        if (frame != null)
            frame.setVisible(false);
    }

    public static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

    private static void frameListener() {
        getFrame().addWindowListener(new WindowAdapter() {
        @Override
            public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            }
        });
    } 
}