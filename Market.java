public class Market {
    // show the info of all items
    private static ArmorFactory af = new ArmorFactory();
    private static WeaponFactory wf = new WeaponFactory();
    private static SpellFactory sf = new SpellFactory();
    private static PotionFactory pf = new PotionFactory();

    public static Armor getArmor(int index){
        return new Armor(af.getArmor(index));
    }

    public static Weapon getWeapon(int index){
        return new Weapon(wf.getWeapon(index));
    }

    // spell need to be filtered based on type
    public static Spell getSpell(int index, String type){
        if(type.equals("fire")){
            return new Spell(sf.getFireSpell(index), type);
        } else if (type.equals("ice")){
            return new Spell(sf.getIceSpell(index), type);
        } else {
            return new Spell(sf.getLightningSpell(index), type);
        }
    }

    public static Potion getPotion(int index){
        return new Potion(pf.getPotion(index));
    }

    public static void showItems(){
        System.out.println("--------------------------ARMORS--------------------------");
        System.out.println("     [Name, cost, level, damage reduction]");
        af.showArmories();
        System.out.println("--------------------------WEAPONS--------------------------");
        System.out.println("     [Name, cost, level, damage, required hands]");
        wf.showWeapons();
        System.out.println("-------------------------ICESPELLS-------------------------");
        System.out.println("     [Name, cost, level, damage, mana cost]");
        sf.showIceSpells();
        System.out.println("-------------------------FIRESPELLS-------------------------");
        System.out.println("     [Name, cost, level, damage, mana cost]");
        sf.showFireSpells();
        System.out.println("-----------------------LIGHTNINGSPELLS-----------------------");
        System.out.println("     [Name, cost, level, damage, mana cost]");
        sf.showLightningSpells();
        System.out.println("--------------------------POTIONS--------------------------");
        System.out.println("     [Name, cost, level, attribute increase, attribute affected]");
        pf.showPotions();
    }
}
