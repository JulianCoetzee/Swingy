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
                savewrite.print("");
                StringBuilder sb = new StringBuilder();
                sb.append("Name: ").append(hero.name).append("\n");
                sb.append("Class: ").append(hero.type).append("\n");
                sb.append("Level: ").append(hero.lvl).append("\n");
                sb.append("XP: ").append(hero.xp).append("\n");
                sb.append("ATK: ").append(hero.atk).append("\n");
                sb.append("DEF: ").append(hero.def).append("\n");
                sb.append("HP: ").append(hero.hp).append("\n");
        
                sb.append("Sword: ");
                if (hero.sword != null)
                    sb.append(hero.sword.getName()).append(" (attack +").append(hero.sword.getStats()).append(")\n");
                else
                    sb.append("\n");
        
                sb.append("Helmet: ");
                if (hero.helm != null)
                    sb.append(hero.helm.getName()).append(" (hp +").append(hero.helm.getStats()).append(")\n");
                else
                    sb.append("\n");
        
                sb.append("Armor: ");
                if (hero.armor != null)
                    sb.append(hero.armor.getName()).append(" (defense +").append(hero.armor.getStats()).append(")\n");
                else
                    sb.append("\n");
                savewrite.print(sb.toString());
            }
            catch (FileNotFoundException fnf) 
            {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
    }   
}
