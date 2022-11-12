import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    private ArrayList<Hero> heros;
    private ArrayList<Monster> monsters;
    private Scanner scanner;

    public Battle(ArrayList<Hero> heros){
        this.heros = heros;
        monsters = new ArrayList<>();
        initializeMonster();
        scanner = new Scanner(System.in);
    }

    // the number of monsters is equals to hero
    // the level of monsters is equals to the highest live of hero
    public void initializeMonster(){
        int highestLevel = 0;
        for(Hero h: heros){
            if(h.getLevel() > highestLevel){
                highestLevel = h.getLevel();
            }
        }
        for(ArrayList<String> m: MonsterFactory.getDragons()){
            if(Integer.parseInt(m.get(1)) == highestLevel){
                monsters.add(new Monster(m));
            }
        }
        if(heros.size() >= 2){
            for(ArrayList<String> m: MonsterFactory.getExos()){
                if(Integer.parseInt(m.get(1)) == highestLevel){
                    monsters.add(new Monster(m));
                }
            }
        }
        if(heros.size() >=3){
            for(ArrayList<String> m: MonsterFactory.getSpirits()){
                if(Integer.parseInt(m.get(1)) == highestLevel){
                    monsters.add(new Monster(m));
                }
            }
        }
    }

    public boolean canParseInt(String str){
        if(str == null){
            return false;

        }
        return str.matches("\\d+");
    }

    // hero choose to equip armor or weapon
    private void equipment(Hero h){
        System.out.println("[Hero] " + h.getName() + "> Would you want to equip armor/weapon for " + h.getName() + "? a(armor)/w(weapon)/n(not equip)");
        String equip = scanner.nextLine();
        while(!equip.equals("a") && !equip.equals("w") && !equip.equals("n")){
            System.out.println("Not valid input! Please enter a/w/n");
            equip = scanner.nextLine();
        }
        // choose to equip armor
        if(equip.equals("a")){
            if(h.getBag().getArmors().size() == 0){
                System.out.println(h.getName() + " does not have any armors.");
            } else {
                h.getBag().showArmors();
                System.out.println("[Hero] " + h.getName() + ">Which armor would you want to equip for " + h.getName() + "?");
                String armorIndex = scanner.nextLine();
                while(!canParseInt(armorIndex) || (Integer.parseInt(armorIndex) < 0 || Integer.parseInt(armorIndex) >= h.getBag().getArmors().size())){
                    System.out.println("Not valid input! Please enter a correct index");
                    armorIndex = scanner.nextLine();
                }
                Armor a = h.getBag().getArmors().get(Integer.parseInt(armorIndex));
                h.equipArmor(a);
                System.out.println("[Hero] " + h.getName() + "> " + "Equips armor " + a.getName());
            }
        }
        // choose to equip weapon
        else if (equip.equals("w")){
            if(h.getBag().getWeapons().size() == 0){
                System.out.println(h.getName() + " does not have any weapons.");
            } else {
                h.getBag().showWeapons();
                System.out.println("[Hero] " + h.getName() + ">Which weapon would you want to equip for " + h.getName() + "?");
                String weaponIndex = scanner.nextLine();
                while(!canParseInt(weaponIndex) || (Integer.parseInt(weaponIndex) < 0 || Integer.parseInt(weaponIndex) >= h.getBag().getWeapons().size())){
                    System.out.println("Not valid input! Please enter a correct index");
                    weaponIndex = scanner.nextLine();
                }
                Weapon w = h.getBag().getWeapons().get(Integer.parseInt(weaponIndex));
                h.equipWeapon(w);
                System.out.println("[Hero] " + h.getName() + "> " + "Equips weapon " + w.getName());
            }
        }
    }

    // show information of hero and monsters
    public void showBattleGroups() {
        String battle = "";
        battle += "--------------------------MONSTER--------------------------\n";
        battle += "     [Name, level, HP, damage, defense]\n";
        for(int i = 0; i<monsters.size();i++) {
            battle += i+" -- ";
            battle += monsters.get(i) + "\n";
        }
        battle += "---------------------------HEROS---------------------------\n";
        for(int i = 0; i<heros.size();i++) {
            battle += "     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]\n";
            battle += i+" -- ";
            battle += heros.get(i) + "\n";
        }
        System.out.println(battle);
    }

    // used to control input and output
    private void heroOperations(Hero h, Monster m){
        System.out.println("[Hero] " + h.getName() + ">Would you like to a(attack)/c(cast a spell)/p(use a potion)/e(equip weapon or armor)?");
        String operation = scanner.nextLine();
        while(!operation.equals("a") && !operation.equals("c") && !operation.equals("p") && !operation.equals("e")){
            System.out.println("Not valid input! Please enter a/c/p/e");
            operation = scanner.nextLine();
        }
        // choose to attack
        if(operation.equals("a")){
            m.defend(h.attack());
        }
        // choose to cast a spell
        else if (operation.equals("c")){
            if(h.getBag().getSpells().size() != 0){
                h.getBag().showSpells();
                System.out.println("[Hero] " + h.getName() + "> which spell would you like to use?");
                String spellIndex = scanner.nextLine();
                while(!canParseInt(spellIndex) || (Integer.parseInt(spellIndex) < 0 || Integer.parseInt(spellIndex) >= h.getBag().getSpells().size())){
                    System.out.println("Not valid input! Please enter correct index");
                    spellIndex = scanner.nextLine();
                }
                Spell spell = h.getBag().getSpells().get(Integer.parseInt(spellIndex));
                if(spell.getType().equals("fire")){
                    m.reduceDefense(h.castSpell(spell));
                } else if (spell.getType().equals("ice")){
                    m.reduceDamage(h.castSpell(spell));
                } else {
                    // lightning spell
                    m.reduceDodge(h.castSpell(spell));
                }
            } else {
                System.out.println(h.getName() + " does not have any spells, choose operation again.");
                heroOperations(h,m);
            }
        }
        // choose to use a potion
        else if (operation.equals("p")){
            if(h.getBag().getPotions().size() != 0){
                h.getBag().showPotions();
                System.out.println("[Hero] " + h.getName() + "> which potion would you like to use?");
                String potionIndex = scanner.nextLine();
                while(!canParseInt(potionIndex) || (Integer.parseInt(potionIndex) < 0 || Integer.parseInt(potionIndex) >= h.getBag().getPotions().size())){
                    System.out.println("Not valid input! Please enter correct index");
                    potionIndex = scanner.nextLine();
                }
                Potion potion = h.getBag().getPotions().get(Integer.parseInt(potionIndex));
                h.heal(potion);
            } else {
                System.out.println(h.getName() + " does not have any potions, choose operation again.");
                heroOperations(h,m);
            }
        }
        // choose to equip an armor or a weapon
        else {
            equipment(h);
        }
    }

    public int endBattle(){
        int deadHero = 0;
        for(Hero h: heros){
            if(h.getHP() == 0){
                deadHero++;
                if(deadHero == heros.size()){
                    // monster wins
                    return 1;
                }
            }
        }
        int deadMonster = 0;
        for(Monster m: monsters){
            if(m.getHP() == 0){
                deadMonster++;
                if(deadMonster == monsters.size()){
                    // hero wins
                    return 2;
                }
            }
        }
        // not end
        return 0;
    }

    // hero/monster keep battle until it dead
    public boolean startBattle(){
        int heroIndex = 0;
        int monsterIndex = 0;
        while(endBattle() == 0){
            showBattleGroups();
            if(heros.get(heroIndex).getHP() != 0){
                heroOperations(heros.get(heroIndex), monsters.get(monsterIndex));
            } else {
                while(heros.get(heroIndex).getHP() == 0){
                    heroIndex = (heroIndex+1)%heros.size();
                }
                heroOperations(heros.get(heroIndex), monsters.get(monsterIndex));
            }
            if(endBattle() != 2){
                if(monsters.get(monsterIndex).getHP() != 0){
                    heros.get(heroIndex).defend(monsters.get(heroIndex).attack());
                } else {
                    while(monsters.get(monsterIndex).getHP() == 0){
                        monsterIndex = (monsterIndex+1)%monsters.size();
                    }
                    heros.get(heroIndex).defend(monsters.get(heroIndex).attack());
                }
            }
        }
        System.out.println("Battle ends!");
        if(endBattle() == 1){
            return true;
        } else {
            // endBattle() returns 2
            // hero wins
            System.out.println("YOU WIN!" + "\n");
            for(Hero h: heros){
                if(h.getHP() != 0){
                    // only hero who did not dead gain money and experience
                    h.win(monsters.get(0).getLevel() * 100, monsters.size() * 2);
                    h.setHP((int) (h.getHP() * 1.1));
                    h.setMP((int) (h.getMP() * 1.1));
                } else {
                    h.setHP(h.getLevel() * 100 / 2);
                    h.setMP(h.getInitialMP() / 2);
                }
            }
            return false;
        }
    }
}
