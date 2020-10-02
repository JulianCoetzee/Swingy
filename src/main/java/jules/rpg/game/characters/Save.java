package jules.rpg.game.characters;

import java.io.*;
import java.util.*;

import jules.rpg.game.gear.*;

public abstract class Save {

    // savefile
    private static String savePath = "./src/main/java/jules/rpg/charfiles/";

    protected static String[] heroclass = { "Warrior", "Ranger", "Rogue" };

    public static void saveMe(Hero hero) {

        File save;
        PrintWriter savewrite;

        if (hero.type.equals(heroclass[0])) {
            save = new File(savePath + hero.name + "_Warrior.txt");
            try 
            {
                savewrite = new PrintWriter(save);
                savewrite.print("");
                StringBuilder sb = new StringBuilder();
                sb.append(hero.name).append("\n");
                sb.append(hero.getType()).append("\n");
                sb.append(hero.getLvl()).append("\n");
                sb.append(hero.getxp()).append("\n");
                sb.append(hero.getAtk()).append("\n");
                sb.append(hero.getDef()).append("\n");
                sb.append(hero.getHP()).append("\n");
        
                if (hero.getSword() != null)
                    sb.append(hero.getSword().getName()).append(" ").append(hero.getSword().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getHelmet() != null)
                    sb.append(hero.getHelmet().getName()).append(" ").append(hero.getHelmet().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getArmor() != null)
                    sb.append(hero.getArmor().getName()).append(" ").append(hero.getArmor().getStats());
                else
                    sb.append("\n");
                savewrite.print(sb.toString());
                savewrite.close();
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
                savewrite.print("");
                StringBuilder sb = new StringBuilder();
                sb.append(hero.name).append("\n");
                sb.append(hero.getType()).append("\n");
                sb.append(hero.getLvl()).append("\n");
                sb.append(hero.getxp()).append("\n");
                sb.append(hero.getAtk()).append("\n");
                sb.append(hero.getDef()).append("\n");
                sb.append(hero.getHP()).append("\n");
        
                if (hero.getSword() != null)
                    sb.append(hero.getSword().getName()).append(" ").append(hero.getSword().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getHelmet() != null)
                    sb.append(hero.getHelmet().getName()).append(" ").append(hero.getHelmet().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getArmor() != null)
                    sb.append(hero.getArmor().getName()).append(" ").append(hero.getArmor().getStats());
                else
                    sb.append("\n");
                savewrite.print(sb.toString());
                savewrite.close();
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
                sb.append(hero.name).append("\n");
                sb.append(hero.getType()).append("\n");
                sb.append(hero.getLvl()).append("\n");
                sb.append(hero.getxp()).append("\n");
                sb.append(hero.getAtk()).append("\n");
                sb.append(hero.getDef()).append("\n");
                sb.append(hero.getHP()).append("\n");
        
                if (hero.getSword() != null)
                    sb.append(hero.getSword().getName()).append(" ").append(hero.getSword().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getHelmet() != null)
                    sb.append(hero.getHelmet().getName()).append(" ").append(hero.getHelmet().getStats()).append("\n");
                else
                    sb.append("\n");
        
                if (hero.getArmor() != null)
                    sb.append(hero.getArmor().getName()).append(" ").append(hero.getArmor().getStats());
                else
                    sb.append("\n");
                savewrite.print(sb.toString());
                savewrite.close();
            }
            catch (FileNotFoundException fnf) 
            {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
    }
    
    public static Hero loadMe(String fileName) {

        try (BufferedReader buffRead = new BufferedReader(new FileReader(savePath + fileName)))
        {
            Hero hero;
            Sword sword;
            Helmet helm;
            Armor armor;
            String str;
            List<String> split;

            hero = null;
            split = new ArrayList<String>();
            while ((str = buffRead.readLine()) != null)
            {
                split.add(str);
            }
            buffRead.close();
            // System.out.println("Read success");
            try
            {
                String[] gear;
                hero = ForgeMe.newHero(split.get(0), split.get(1));
                hero.setLvl(Integer.parseInt(split.get(2)));
                hero.setxp(Integer.parseInt(split.get(3)));
                hero.setAtk(Integer.parseInt(split.get(4)));
                hero.setDef(Integer.parseInt(split.get(5)));
                hero.setHP(Integer.parseInt(split.get(6)));
                if (split.get(7) != null && split.get(7).length() > 1)
                {
                    gear = split.get(7).split(" ");
                    sword = new Sword(gear[0], Integer.parseInt(gear[1]));
                    hero.setSword(sword);
                }
                if (split.get(8) != null && split.get(8).length() > 1)
                {
                    gear = split.get(8).split(" ");
                    helm = new Helmet(gear[0], Integer.parseInt(gear[1]));
                    hero.setHelmet(helm);
                }
                if (split.get(9) != null && split.get(9).length() > 1)
                {
                    gear = split.get(9).split(" ");
                    armor = new Armor(gear[0], Integer.parseInt(gear[1]));
                    hero.setArmor(armor);
                }
                return hero;
            }
            catch (Exception err) 
            {
                System.out.println("Hero reforge error: " + err.getMessage());
                return null;
            }
        }
        catch (Exception err) 
        {
            System.out.println("Load error: " + err.getMessage());
            return null;
        }
    }
}