package jules.rpg.game.characters;

import java.io.*;
import java.util.logging.*;
import java.util.Set;
import javax.validation.*;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import jules.rpg.game.world.Pos;
import jules.rpg.game.characters.*;

public class Hero extends Pos {

    // savefile
    private String savePath = "./src/main/java/jules/rpg/charfiles/";
    private File save;
    private PrintWriter savewrite;
    // stat block

    @NotNull(message = "Name this Champion")
    @Size(min = 1, max = 16)
    protected String name;

    @NotNull(message = "No Hero type")
    protected String type;

    @Range(min = 0, max = 10)
    protected int lvl;

    @Min(0)
    protected int xp;

    @Min(0)
    protected int atk;

    @Min(0)
    protected int def;

    @Min(1)
    protected int hp;

    @Min(0)
    protected int max;

    protected String[] heroclass = { "Warrior", "Ranger", "Rogue" };

    // new hero
    public Hero(String name, String type) {
        this.name = name;
        this.type = type;
        this.lvl = 0;
        this.xp = 0;

        if (type.equals(heroclass[1])) {
            this.atk = 20;
            this.def = 30;
            this.hp = 100;
            this.max = 100;
            save = new File(savePath + name + "_Warrior.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(this.name);
                savewrite.println(this.type);
                savewrite.println(this.lvl);
                savewrite.println(this.xp);
                savewrite.println(this.atk);
                savewrite.println(this.def);
                savewrite.println(this.hp);
                savewrite.println(this.max);
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (type.equals(heroclass[2]))
        {
            this.atk = 30;
            this.def = 20;
            this.hp = 100;
            this.max = 100;
            save = new File(savePath + name + "_Ranger.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(this.name);
                savewrite.println(this.type);
                savewrite.println(this.lvl);
                savewrite.println(this.xp);
                savewrite.println(this.atk);
                savewrite.println(this.def);
                savewrite.println(this.hp);
                savewrite.println(this.max);
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error: " + fnf.getMessage());
                return ;
            }
        }
        else if (type.equals(heroclass[3]))
        {
            this.atk = 30;
            this.def = 30;
            this.hp = 80;
            this.max = 80;
            save = new File(savePath + name + "_Rogue.txt");
            try {
                savewrite = new PrintWriter(save);
                savewrite.println(this.name);
                savewrite.println(this.type);
                savewrite.println(this.lvl);
                savewrite.println(this.xp);
                savewrite.println(this.atk);
                savewrite.println(this.def);
                savewrite.println(this.hp);
                savewrite.println(this.max);
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
        if (constraintViolations.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hero validation error(s): ");
            stringBuilder.append(constraintViolations.size());
            stringBuilder.append("\n");
            for (ConstraintViolation<Hero> cv : constraintViolations) {
                stringBuilder.append("property: [");
                stringBuilder.append(cv.getPropertyPath());
                stringBuilder.append("], value: [");
                stringBuilder.append(cv.getInvalidValue());
                stringBuilder.append("], message: [");
                stringBuilder.append(cv.getMessage());
                stringBuilder.append("]\n");
            }
            throw new HeroNotValid(stringBuilder.toString());
        }
    } 

    public String getName() {
        return name;
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

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHP() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public char getChar() {
        return ('H');
    }
}