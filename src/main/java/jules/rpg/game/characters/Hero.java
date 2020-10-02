package jules.rpg.game.characters;

import java.util.logging.*;
import java.util.Set;
import javax.validation.*;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

import jules.rpg.game.gear.*;

public class Hero extends Entity {

    @NotNull(message = "No Hero type")
    protected String type;

    @Min(value = 0, message = "Cannot be below lvl 0")
    protected int lvl;

    @Min(value = 0, message = "Cannot have < 0 xp")
    protected int xp;

    protected Armor armor;
    protected Helmet helm;
    protected Sword sword;

    public Hero(String name, int atk, int def, int hp,String type, int lvl,
                int xp, Armor armor, Helmet helm, Sword sword) {

        super(name, atk, def, hp);
        this.type = type;
        this.lvl = lvl;
        this.xp = xp;
        this.armor = armor;
        this.helm = helm;
        this.sword = sword;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Class: ").append(type).append("\n");
        sb.append("Level: ").append(lvl).append("\n");
        sb.append("XP: ").append(xp).append("\n");
        sb.append("ATK: ").append(atk).append("\n");
        sb.append("DEF: ").append(def).append("\n");
        sb.append("HP: ").append(hp).append("\n");

        sb.append("Weapon: ");
        if (sword != null)
            sb.append(sword.getName()).append(" (attack +").append(sword.getStats()).append(")\n");
        else
            sb.append(" no weapon\n");

        sb.append("Helmet: ");
        if (helm != null)
            sb.append(helm.getName()).append(" (hp +").append(helm.getStats()).append(")\n");
        else
            sb.append(" no helmet\n");

        sb.append("Armor: ");
        if (armor != null)
            sb.append(armor.getName()).append(" (defense +").append(armor.getStats()).append(")\n");
        else
            sb.append(" no armor\n");
        return sb.toString();
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

    public Armor getArmor() {
        return armor;
    }

    public Helmet getHelmet() {
        return helm;
    }

    public Sword getSword() {
        return sword;
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

    public void equipArmor(Armor armor) {
        if (this.armor != null)
            this.def = this.def - this.armor.getStats();
        this.def = this.def + armor.getStats();
        this.armor = armor;
    }

    public void equipHelmet(Helmet helm) {
        if (this.armor != null)
        {
            this.hp = this.hp - this.helm.getStats();
            if (this.hp + helm.getStats() < 1)
            {
                this.hp = this.hp + this.helm.getStats();
                return ;
            }
        }
        this.hp = this.hp + helm.getStats();
        this.helm = helm;
    }

    public void equipSword(Sword sword) {
        if (this.sword != null)
            this.atk = this.atk - this.sword.getStats();
        this.atk = this.atk + sword.getStats();
        this.sword = sword;
    }

    public void addxp(int gains) {

        int nextLevel = (lvl + 1) * 1000 + lvl * lvl * 450;

        if (xp + gains >= nextLevel)
            levelUp();
        xp = xp + gains;
    }

    private void levelUp() {
        
        lvl++;        
        atk = atk + lvl * 3;
        def = def + lvl * 2;
        hp = hp + 50 + lvl * 10;
    }
}