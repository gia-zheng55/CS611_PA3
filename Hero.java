import java.util.ArrayList;

public class Hero extends Character{
    private int MP;
    private int initialMP;
    private int experience;
    private int strength;
    private int dexterity;
    private int agility;
    private int gold;
    private String type;
    private Bag bag;
    private ArrayList<Armor> armor;
    private ArrayList<Weapon> weapon;

    public Hero(ArrayList<String> infos, String type) {
        super(infos.get(0), 1);
        this.MP = Integer.parseInt(infos.get(1));
        this.initialMP = Integer.parseInt(infos.get(1));
        this.strength = Integer.parseInt(infos.get(2));
        this.agility = Integer.parseInt(infos.get(3));
        this.dexterity = Integer.parseInt(infos.get(4));
        this.gold = Integer.parseInt(infos.get(5));
        this.experience = Integer.parseInt(infos.get(6));
        this.type = type;
        setDodge(this.agility * 0.002);
        bag = new Bag();
        armor = new ArrayList<>();
        weapon = new ArrayList<>();
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getInitialMP() {
        return initialMP;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience += experience;
        if(this.experience >= getLevel() * 10){
            System.out.println("[Hero]" + getName() + "> Level up!");
            this.experience -= getLevel() * 10;
            addLevel();
            setMP((int) (MP * 1.1));
            strength = (int) (strength * 1.05);
            dexterity = (int) (dexterity * 1.05);
            setAgility((int) (agility * 1.05));
            if(type.equals("warrior")){
                strength = (int) (strength * 1.05);
                setAgility((int) (agility * 1.05));
            } else if (type.equals("paladin")){
                strength = (int) (strength * 1.05);
                dexterity = (int) (dexterity * 1.05);
            } else {
                dexterity = (int) (dexterity * 1.05);
                setAgility((int) (agility * 1.05));
            }
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
        setDodge(this.agility * 0.002);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addWeapon(Weapon item) {
        bag.addWeapon(item);
    }

    public void addArmor(Armor item) {
        bag.addArmor(item);
    }

    public void addSpell(Spell item) {
        bag.addSpell(item);
    }

    public void addPotion(Potion item) {
        bag.addPotion(item);
    }

    public Bag getBag() {
        return bag;
    }

    public Armor getArmor() {
        if(armor.size() != 0){
            return armor.get(0);
        }
        return null;
    }

    public Weapon getWeapon() {
        if(weapon.size() != 0){
            return weapon.get(0);
        }
        return null;
    }

    // the hero can only equip one item: armor/weapon
    public void equipArmor(Armor a){
        if(weapon.size() != 0){
            weapon.remove(0);
        }
        if(armor.size() != 0){
            armor.remove(0);
        }
        armor.add(a);
    }

    public void equipWeapon(Weapon w){
        if(weapon.size() != 0){
            weapon.remove(0);
        }
        if(armor.size() != 0){
            armor.remove(0);
        }
        weapon.add(w);
    }

    public String toString(){
        String hero = getName() + " - " + getLevel() + " - " + getHP() + " - " + getMP() + " - " + getStrength() +
                " - " + getDexterity() + " - " + getAgility() + " - " + getGold() + " - " + getExperience() + "\n";
        hero += bag.toString();
        return hero;
    }

    public int attack(){
        // for choose to attack
        int hurtValue = this.strength;
        if (getWeapon()  != null) {
            // add damage caused by equipped weapon
            hurtValue = (int) (hurtValue + getWeapon().getDamage() * 0.05);
        }
        System.out.println("[Hero] " + getName() + "> regular attack: damage=" + hurtValue);
        return hurtValue;
    }

    public void heal(Potion potion) {
        // for using a potion and increase the affected attributes
        //capped
        int healValue = potion.getEffect();
        if (potion.getAttributes()[0]) {
            setHP(getHP() + healValue);
        }
        if (potion.getAttributes()[1])
            MP += healValue;
        if (potion.getAttributes()[2])
            strength += healValue;
        if (potion.getAttributes()[3])
            dexterity += healValue;
        if (potion.getAttributes()[5])
            agility += healValue;
            setAgility(agility);
        System.out.println("Succeed: Use [Potion] " + potion);
    }

    public double castSpell(Spell spell) {
        // return the value of damage when hero cast the given spell
        if (MP < spell.getMana()) {
            System.out.println("Failed: " + getName() + " does not have enough MP to cast this spell!");
            return 0;
        }
        MP -= spell.getMana();
        System.out.println("[Hero] " + getName() + "> " + spell.getType() + "spell damage=" + spell.getDamage());
        return spell.getDamage() + ((dexterity/10000) * spell.getDamage());
    }

    public void defend(int val) {
        // defend against monster attacks
        if(!dodge()){
            int hurt = val;
            // if hero is armed
            if (getArmor() != null)
                hurt -= getArmor().getDamageReduction();
            if (hurt < 0) {
                System.out.print("[Hero] " + getName() + ": Defense all damage");
            }
            else {
                // hero reduce hp
                int currentHp = getHP() - hurt;
                if (currentHp < 0) {
                    currentHp = 0;
                }
                setHP(currentHp);
                System.out.print("[Hero] " + getName() + ": hp-" + hurt);
            }
            System.out.println("[Hero] " + getName() + ": Current hp: " + getHP());
        }
    }

    public boolean dodge() {
        // return whether hero dodge the attack by monster: if true --> dodge
        if (Math.random() < getDodge()) {
            System.out.println("[Hero] " + getName() + ": Dodged the attack!");
            return true;
        }
        return false;
    }

    // if the hero win the battle without dead, gain money and experience
    public void win(int money, int exp){
        System.out.println("[Hero]" + getName() + "> gain " + money + " gold.");
        setGold(getGold() + money);
        System.out.println("[Hero]" + getName() + "> gain " + exp + " experience.");
        setExperience(exp);
    }

    // Sell methods
    // remove the item from bag
    // gain half of the purchase price
    public void sellArmor(int index){
        if(bag.getArmors().size() != 0){
            gold += bag.getArmors().get(index).getPrice()/2;
            System.out.println("[Hero] " + getName() + ": Sells " + bag.getArmors().get(index).getName() + " and gain " + bag.getArmors().get(index).getPrice());
            bag.getArmors().remove(index);
        } else {
            System.out.println("[Hero] " + getName() + ": Does not have any armors");
        }
    }

    public void sellWeapon(int index){
        if(bag.getWeapons().size() != 0){
            gold += bag.getWeapons().get(index).getPrice()/2;
            System.out.println("[Hero] " + getName() + ": Sells " + bag.getWeapons().get(index).getName() + " and gain " + bag.getWeapons().get(index).getPrice());
            bag.getWeapons().remove(index);
        } else {
            System.out.println("[Hero] " + getName() + ": Does not have any weapons");
        }
    }

    public void sellSpell(int index){
        if(bag.getSpells().size() != 0){
            gold += bag.getSpells().get(index).getPrice()/2;
            System.out.println("[Hero] " + getName() + ": Sells " + bag.getSpells().get(index).getName() + " and gain " + bag.getSpells().get(index).getPrice());
            bag.getSpells().remove(index);
        } else {
            System.out.println("[Hero] " + getName() + ": Does not have any spells");
        }
    }

    public void sellPotion(int index){
        if(bag.getPotions().size() != 0){
            gold += bag.getPotions().get(index).getPrice()/2;
            System.out.println("[Hero] " + getName() + ": Sells " + bag.getPotions().get(index).getName() + " and gain " + bag.getPotions().get(index).getPrice());
            bag.getPotions().remove(index);
        } else {
            System.out.println("[Hero] " + getName() + ": Does not have any potions");
        }
    }
}
