package jules.rpg.game.characters;

import java.io.*;
import java.util.logging.*;
import java.util.Set;
import javax.validation.*;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

public class Hero extends Entity {

    // savefile
    private String savePath = "./src/main/java/jules/rpg/charfiles/";
    private File save;
    private PrintWriter savewrite;

    @NotNull(message = "No Hero type")
    protected String type;

    @Min(value = 0, message = "Cannot be below lvl 0")
    protected int lvl;

    @Min(value = 0, message = "Cannot have < 0 xp")
    protected int xp;

    protected String[] heroclass = { "Warrior", "Ranger", "Rogue" };

    public Hero(String name, int atk, int def, int hp,
                String type, int lvl, int xp) {

        super(name, atk, def, hp);
        this.type = type;
        this.lvl = lvl;
        this.xp = xp;
    }

    public void saveMe(Hero hero) {

        if (hero.type.equals(heroclass[1])) {
            save = new File(savePath + name + "_Warrior.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (hero.type.equals(heroclass[2]))
        {
            save = new File(savePath + name + "_Ranger.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (hero.type.equals(heroclass[3]))
        {
            save = new File(savePath + name + "_Rogue.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(hero.name);
                savewrite.println(hero.type);
                savewrite.println(hero.lvl);
                savewrite.println(hero.xp);
                savewrite.println(hero.atk);
                savewrite.println(hero.def);
                savewrite.println(hero.hp);
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
    }

    public void validateHero() throws HeroNotValid {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(this);
        if (constraintViolations.size() != 0)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Hero validation error(s): ");
            sb.append(constraintViolations.size());
            sb.append("\n");
            for (ConstraintViolation<Hero> cv : constraintViolations)
            {
                sb.append("property: [");
                sb.append(cv.getPropertyPath());
                sb.append("], value: [");
                sb.append(cv.getInvalidValue());
                sb.append("], message: [");
                sb.append(cv.getMessage());
                sb.append("]\n");
            }
            throw new HeroNotValid(sb.toString());
        }
    }

    public String getType() {
        return type;
    }

    public int getLvl() {
        return lvl;
    }

    public int getxp() {
        return xp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setxp(int xp) {
        this.xp = xp;
    }

    public void addxp(int gains) {

        int nextLevel = (lvl + 1) * 1000 + lvl * lvl * 450;

        if (xp + gains >= nextLevel)
            levelUp();
        xp = xp + gains;
    }

    private void levelUp() {
        lvl++;
        hp = hp + 50 + lvl * 10;
        atk = atk + lvl * 3;
        def = def + lvl * 2;
    }
}