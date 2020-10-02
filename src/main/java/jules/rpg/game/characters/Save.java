package jules.rpg.game.characters;

import java.io.*;

public abstract class Save {

    // savefile
    private static String savePath = "./src/main/java/jules/rpg/charfiles/";
    private static File save;
    private static PrintWriter savewrite;

    protected static String[] heroclass = { "Warrior", "Ranger", "Rogue" };

    public static void saveMe(Hero hero) {

        if (hero.type.equals(heroclass[0])) {
            save = new File(savePath + hero.name + "_Warrior.txt");
            try 
            {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
                savewrite.println(hero.armor);
                savewrite.println(hero.helm);
                savewrite.println(hero.sword);
            }
            catch (FileNotFoundException fnf) 
            {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (hero.type.equals(heroclass[1]))
        {
            save = new File(savePath + hero.name + "_Ranger.txt");
            try 
            {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
                savewrite.println(hero.armor);
                savewrite.println(hero.helm);
                savewrite.println(hero.sword);
            }
            catch (FileNotFoundException fnf) 
            {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (hero.type.equals(heroclass[2]))
        {
            save = new File(savePath + hero.name + "_Rogue.txt");
            try 
            {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
                savewrite.println(hero.armor);
                savewrite.println(hero.helm);
                savewrite.println(hero.sword);
            }
            catch (FileNotFoundException fnf) 
            {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
    }   
}
