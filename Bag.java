import java.util.ArrayList;

public class Bag {
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;
    private ArrayList<Spell> spells;
    private ArrayList<Potion> potions;

    public Bag(){
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.spells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public Potion removePotion(int index){
        Potion potion = potions.remove(index);
        return potion;
    }

    public void addWeapon(Weapon item) {
        weapons.add(item);
    }

    public void addArmor(Armor item) {
        armors.add(item);
    }

    public void addSpell(Spell item) {
        spells.add(item);
    }

    public void addPotion(Potion item) {
        potions.add(item);
    }

    // used in battle
    public void showArmors(){
        String hero = "";
        if(armors.size() != 0){
            hero += "--------------------------ARMORS--------------------------\n";
            hero += "     [Name, cost, level, damage reduction]\n";
            for(int i = 0; i<armors.size();i++) {
                hero += i+" -- ";
                hero += armors.get(i) + "\n";
            }
        }
        System.out.println(hero);
    }

    public void showWeapons(){
        String hero = "";
        if(weapons.size() != 0){
            hero += "--------------------------WEAPONS--------------------------\n";
            hero += "     [Name, cost, level, damage, required hands]\n";
            for(int i = 0; i<weapons.size();i++) {
                hero += i+" -- ";
                hero += weapons.get(i) + "\n";
            }
        }
        System.out.println(hero);
    }

    public void showSpells(){
        String hero = "";
        if(spells.size() != 0){
            hero += "--------------------------SPELLS--------------------------\n";
            hero += "     [Name, cost, level, damage, mana cost]\n";
            for(int i = 0; i<spells.size();i++) {
                hero += i+" -- ";
                hero += spells.get(i) + "\n";
            }
        }
        System.out.println(hero);
    }

    public void showPotions(){
        String hero = "";
        if(potions.size() != 0){
            hero += "--------------------------POTIONS--------------------------\n";
            hero += "     [Name, cost, level, attribute increase, attribute affected]\n";
            for(int i = 0; i<potions.size();i++) {
                hero += i+" -- ";
                hero += potions.get(i) + "\n";
            }
        }
        System.out.println(hero);
    }

    public String toString(){
        String hero = "";
        if(armors.size() != 0){
            hero += "--------------------------ARMORS--------------------------\n";
            hero += "     [Name, cost, level, damage reduction]\n";
            for(int i = 0; i<armors.size();i++) {
                hero += i+" -- ";
                hero += armors.get(i) + "\n";
            }
        }
        if(weapons.size() != 0){
            hero += "--------------------------WEAPONS--------------------------\n";
            hero += "     [Name, cost, level, damage, required hands]\n";
            for(int i = 0; i<weapons.size();i++) {
                hero += i+" -- ";
                hero += weapons.get(i) + "\n";
            }
        }
        if(spells.size() != 0){
            hero += "--------------------------SPELLS--------------------------\n";
            hero += "     [Name, cost, level, damage, mana cost]\n";
            for(int i = 0; i<spells.size();i++) {
                hero += i+" -- ";
                hero += spells.get(i) + "\n";
            }
        }
        if(potions.size() != 0){
            hero += "--------------------------POTIONS--------------------------\n";
            hero += "     [Name, cost, level, attribute increase, attribute affected]\n";
            for(int i = 0; i<potions.size();i++) {
                hero += i+" -- ";
                hero += potions.get(i) + "\n";
            }
        }
        return hero;
    }

}
