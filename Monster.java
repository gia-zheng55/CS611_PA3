import java.util.ArrayList;

public class Monster extends Character{
    private int baseDamage;
    private int defense;

    public Monster(ArrayList<String> infos) {
        super(infos.get(0), Integer.parseInt(infos.get(1)));
        this.baseDamage = Integer.parseInt(infos.get(2));
        this.defense = Integer.parseInt(infos.get(3));
        setDodge(Integer.parseInt(infos.get(4)));
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String toString(){
        String monster = getName() + " - " + getLevel() + " - " + getHP() + " - " + getBaseDamage() + " - " + getDefense();
        return monster;
    }

    public int attack() {
        // return the value of monster's damage
        int hurtValue = baseDamage;
        System.out.println("[Monster] " + getName() + "> attack: damage=" + hurtValue);
        return hurtValue;
    }

    public boolean dodge() {
        // return whether monster dodge the attack by hero: if true --> dodge
        if (Math.random() < getDodge() * 0.01) {
            System.out.println("[Monster] " + getName() + " dodges the attack!");
            return true;
        }
        return false;
    }

    public void defend(int damage) {
        // defend against hero attacks
        if(!dodge()){
            int newHP = getHP() - damage + defense;
            if (newHP < 0) newHP = 0;
            if (newHP > getHP()) newHP = getHP();
            setHP(newHP);
        }
    }

    public void reduceDamage(double damage) {
        // when monster is hit by a ice spell, it may reduce damage
        if(!dodge()){
            int newDamage = (int) (baseDamage - damage * 0.1);
            setBaseDamage(newDamage);
        }
    }

    public void reduceDefense(double damage) {
        // when monster is hit by a fire spell, it may reduce defense
        if(!dodge()){
            int newDefense = (int) (defense - damage * 0.1);
            setDefense(newDefense);
        }
    }

    public void reduceDodge(double damage) {
        // when monster is hit by a lightning spell, it may reduce dodge chance
        if(!dodge()){
            int newDodge = (int) (getDodge() - damage * 0.1);
            setDodge(newDodge * 0.01);
        }
    }
}
