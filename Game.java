import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    // used to control yes/no question input and output
    public boolean yOrnProblem(){
        String yOrn = scanner.nextLine();
        while(!yOrn.equals("Y") && !yOrn.equals("y") && !yOrn.equals("N") && !yOrn.equals("n")){
            System.out.println("Not valid input! Please enter y/n");
            yOrn = scanner.nextLine();
        }
        if(yOrn.equals("Y") || yOrn.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    public boolean canParseInt(String str){
        if(str == null){
            return false;

        }
        return str.matches("\\d+");
    }

    // check if all hero dead
    public boolean endGame(){
        int count = 0;
        for(Hero h: Player.getHeros()){
            if(h.getHP() == 0){
                count++;
                if(count == Player.getHeros().size()){
                    return true;
                }
            }
        }
        return false;
    }

    // start a game
    public void start(){
        map = new Map();
        player = new Player();
        Instruction.introduction();
        chooseHero();
        while(!endGame()){
            move();
        }
        Instruction.quit();
    }

    // first step in the game
    // choose the number of hero
    // choose hero
    public void chooseHero(){
        HeroFactory.showHeros();
        System.out.println("How many heros would you want to choose? (1-3)");
        String input = scanner.nextLine();
        while(!canParseInt(input) || (Integer.parseInt(input) < 1 && Integer.parseInt(input) > 3)){
            System.out.println("Not valid input! Please enter an integer within 1 to 3");
            input = scanner.nextLine();
        };
        for(int i = 1; i <= Integer.parseInt(input); i++){
            System.out.println("Hero " + i + ": What kind of hero would you want to choose? (warrior, paladin, sorcerer)");
            String heroType = scanner.nextLine();
            while(!heroType.equals("warrior") && !heroType.equals("paladin") && !heroType.equals("sorcerer")){
                System.out.println("Not valid input! Please enter warrior/paladin/sorcerer");
                heroType = scanner.nextLine();
            };
            if(heroType.equals("warrior")){
                System.out.println("Please enter the index of the warrior");
                String itemNum = scanner.nextLine();
                while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 || Integer.parseInt(itemNum) > 5)){
                    System.out.println("Not valid input! Please enter an integer from 0 to 5");
                    itemNum = scanner.nextLine();
                }
                Player.addHero(new Hero(HeroFactory.getWarrior(Integer.parseInt(itemNum)), "warrior"));
            } else if(heroType.equals("paladin")){
                System.out.println("Please enter the index of the paladin");
                String itemNum = scanner.nextLine();
                while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 || Integer.parseInt(itemNum) > 5)){
                    System.out.println("Not valid input! Please enter an integer from 0 to 5");
                    itemNum = scanner.nextLine();
                }
                Player.addHero(new Hero(HeroFactory.getPaladin(Integer.parseInt(itemNum)), "paladin"));
            } else {
                System.out.println("Please enter the index of the sorcerer");
                String itemNum = scanner.nextLine();
                while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 || Integer.parseInt(itemNum) > 5)){
                    System.out.println("Not valid input! Please enter an integer from 0 to 5");
                    itemNum = scanner.nextLine();
                }
                Player.addHero(new Hero(HeroFactory.getSorcerer(Integer.parseInt(itemNum)), "sorcerer"));
            }
        }
    }

    // the main part of the game
    // direction -> market / inaccessible space / safe space / meet monster
    // show information
    // quit the game
    private void move(){
        map.printMap();
        System.out.println("Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)");
        String input = scanner.nextLine();
        while(!input.equals("W") && !input.equals("w") && !input.equals("S") && !input.equals("s")
                && !input.equals("A") && !input.equals("a") && !input.equals("D") && !input.equals("d")
                && !input.equals("I") && !input.equals("i") && !input.equals("Q") && !input.equals("q")){
            System.out.println("Not valid input! Please enter W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)");
            input = scanner.nextLine();
        };
        // choose to move up
        if (input.equals("W") || input.equals("w")) {
            if (map.getHeroPosition()[0] - 1 < 0) {
                System.out.println("End of the road! Please try another direction.");
            } else {
                // can't move into the inaccessible area
                if (map.getFigure(map.getHeroPosition()[0] - 1, map.getHeroPosition()[1]).equals("&")) {
                    System.out.println("Inaccessible area! Please try another direction.");
                }
                // move into the market
                else if (map.getFigure(map.getHeroPosition()[0] - 1, map.getHeroPosition()[1]).equals("M")) {
                    // update team's position
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    map.setHeroPosition(map.getHeroPosition()[0] - 1, map.getHeroPosition()[1]);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M/H");
                    System.out.println("Market area! Do you want to enter the market? (y/n)");
                    if(yOrnProblem()){
                        enterMarket();
                    }
                }
                else if (map.getFigure(map.getHeroPosition()[0] - 1, map.getHeroPosition()[1]).equals(" ")) {
                    // update hero's position
                    if(map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].getFigure().equals("M/H")){
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M");
                    } else {
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    }
                    map.setHeroPosition(map.getHeroPosition()[0] - 1, map.getHeroPosition()[1]);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("H");
                    map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).rollMonster();
                    if(map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).isHasMonster()){
                        // meet monsters
                        System.out.println("\u001B[1;31m" + "Monsters! Ready to fight\u001B[0m");
                        Battle battle = new Battle(Player.getHeros());
                        if(battle.startBattle()){
                            System.out.println("\u001B[1;31m" + "YOU LOSE!\u001B[0m Would you want to start a new game? (y/n)");
                            if(yOrnProblem()){
                                start();
                            }
                        }
                        // turn the area to safe
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setHasMonster(false);
                    }
                }
            }
        }

        // choose to move left
        else if (input.equals("A") || input.equals("a")) {
            if (map.getHeroPosition()[1] - 1 < 0) {
                System.out.println("End of the road! Please try another direction.");
            } else {
                // can't move into the inaccessible area
                if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] - 1).equals("&")) {
                    System.out.println("Inaccessible area! Please try another direction.");
                }
                // move into the market
                else if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] - 1).equals("M")) {
                    // update team's position
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    map.setHeroPosition(map.getHeroPosition()[0], map.getHeroPosition()[1] - 1);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M/H");
                    System.out.println("Market area! Do you want to enter the market? (y/n)");
                    if(yOrnProblem()){
                        enterMarket();
                    }
                }
                else if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] - 1).equals(" ")) {
                    // update hero's position
                    if(map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].getFigure().equals("M/H")){
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M");
                    } else {
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    }
                    map.setHeroPosition(map.getHeroPosition()[0], map.getHeroPosition()[1] - 1);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("H");
                    map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).rollMonster();
                    if(map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).isHasMonster()){
                        // meet monsters
                        System.out.println("\u001B[1;31m" + "Monsters! Ready to fight\u001B[0m");
                        Battle battle = new Battle(Player.getHeros());
                        if(battle.startBattle()){
                            System.out.println("\u001B[1;31m" + "YOU LOSE!\u001B[0m Would you want to start a new game? (y/n)");
                            if(yOrnProblem()){
                                start();
                            }
                        }
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setHasMonster(false);
                    }
                }
            }
        }

        // choose to move down
        else if (input.equals("S") || input.equals("s")) {
            if (map.getHeroPosition()[0] + 1 >= map.getMap().length) {
                System.out.println("End of the road! Please try another direction.");
            } else {
                // can't move into the inaccessible area
                if (map.getFigure(map.getHeroPosition()[0] + 1, map.getHeroPosition()[1]).equals("&")) {
                    System.out.println("Inaccessible area! Please try another direction.");
                }
                // move into the market
                else if (map.getFigure(map.getHeroPosition()[0] + 1, map.getHeroPosition()[1]).equals("M")) {
                    // update hero's position
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    map.setHeroPosition(map.getHeroPosition()[0] + 1, map.getHeroPosition()[1]);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M/H");
                    System.out.println("Market area! Do you want to enter the market? (y/n)");
                    if(yOrnProblem()){
                        enterMarket();
                    }
                }
                else if (map.getFigure(map.getHeroPosition()[0] + 1, map.getHeroPosition()[1]).equals(" ")) {
                    // update team's position
                    if(map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].getFigure().equals("M/H")){
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M");
                    } else {
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    }
                    map.setHeroPosition(map.getHeroPosition()[0] + 1, map.getHeroPosition()[1]);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("H");
                    map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).rollMonster();
                    if(map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).isHasMonster()){
                        // meet monsters
                        System.out.println("Monsters! Ready to fight");
                        Battle battle = new Battle(Player.getHeros());
                        if(battle.startBattle()){
                            System.out.println("YOU LOSE! Would you want to start a new game? (y/n)");
                            if(yOrnProblem()){
                                start();
                            }
                        }
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setHasMonster(false);
                    }
                }
            }
        }

        // choose to move right
        else if (input.equals("D") || input.equals("d")) {
            if (map.getHeroPosition()[1] + 1 >= map.getMap()[0].length) {
                System.out.println("End of the road! Please try another direction.");
            } else {
                // can't move into the inaccessible area
                if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] + 1).equals("&")) {
                    System.out.println("Inaccessible area! Please try another direction.");
                }
                // move into the market
                else if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] + 1).equals("M")) {
                    // update team's position
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    map.setHeroPosition(map.getHeroPosition()[0], map.getHeroPosition()[1] + 1);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M/H");
                    System.out.println("Market area! Do you want to enter the market? (y/n)");
                    if(yOrnProblem()){
                        enterMarket();
                    }
                }
                else if (map.getFigure(map.getHeroPosition()[0], map.getHeroPosition()[1] + 1).equals(" ")) {
                    // update team's position
                    if(map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].getFigure().equals("M/H")){
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("M");
                    } else {
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure(" ");
                    }
                    map.setHeroPosition(map.getHeroPosition()[0], map.getHeroPosition()[1] + 1);
                    map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setFigure("H");
                    map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).rollMonster();
                    if(map.getPosition(map.getHeroPosition()[0], map.getHeroPosition()[1]).isHasMonster()){
                        // meet monsters
                        System.out.println("Monsters! Ready to fight");
                        Battle battle = new Battle(Player.getHeros());
                        if(battle.startBattle()){
                            System.out.println("YOU LOSE! Would you want to start a new game? (y/n)");
                            if(yOrnProblem()){
                                start();
                            }
                        }
                        map.getMap()[map.getHeroPosition()[0]][map.getHeroPosition()[1]].setHasMonster(false);
                    }
                }
            }
        }

        // choose to show the information
        else if (input.equals("I") || input.equals("i")){
            map.printMap();
            Player.showHeros();
        }

        // choose to quit the game
        else {
            Instruction.quit();
        }
    }

    private void enterMarket(){
        System.out.println("Welcome to the Market!" + "\n");
        Market.showItems();
        boolean stayMarket = true;
        while(stayMarket){
            // hero can keep stay in the market and have many times of sell and buy
            System.out.println("Do you want to buy or sell items? b(buy)/s(sell)");
            String buyOrSell = scanner.nextLine();
            while (!buyOrSell.equals("b") && !buyOrSell.equals("s")){
                System.out.println("Not valid input! Please enter b/s");
                buyOrSell = scanner.nextLine();
            }
            // buy items
            if(buyOrSell.equals("b")){
                System.out.println("Please enter the type of item you want to buy: (armor, weapon, spell, potion)");
                String itemType = scanner.nextLine();
                while (!itemType.equals("armor") && !itemType.equals("weapon") && !itemType.equals("spell") && !itemType.equals("potion")){
                    System.out.println("Not valid input! Please enter armor/weapon/spell/potion");
                    itemType = scanner.nextLine();
                }
                // choose to buy armor
                if(itemType.equals("armor")){
                    System.out.println("Please enter the index of the armor you want to buy");
                    String itemNum = scanner.nextLine();
                    while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 4)){
                        System.out.println("Not valid input! Please enter an integer from 0 to 4");
                        itemNum = scanner.nextLine();
                    }
                    Armor armor = Market.getArmor(Integer.parseInt(itemNum));
                    Player.showHeros();
                    System.out.println("Please enter the index of the hero to pay");
                    String heroNum = scanner.nextLine();
                    while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                        System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                        heroNum = scanner.nextLine();
                    }
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < armor.getLevel()){
                        System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                    } else {
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= armor.getPrice()){
                            Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - armor.getPrice());
                            Player.getHeros().get(Integer.parseInt(heroNum)).addArmor(armor);
                        } else {
                            System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this armor");
                        }
                    }
                }
                // choose to buy weapon
                else if (itemType.equals("weapon")){
                    System.out.println("Please enter the index of the weapon you want to buy");
                    String itemNum = scanner.nextLine();
                    while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 5)){
                        System.out.println("Not valid input! Please enter an integer from 0 to 5");
                        itemNum = scanner.nextLine();
                    }
                    Weapon weapon = Market.getWeapon(Integer.parseInt(itemNum));
                    Player.showHeros();
                    System.out.println("Please enter the index of the hero to pay");
                    String heroNum = scanner.nextLine();
                    while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                        System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                        heroNum = scanner.nextLine();
                    }
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < weapon.getLevel()){
                        System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                    } else {
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= weapon.getPrice()){
                            Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - weapon.getPrice());
                            Player.getHeros().get(Integer.parseInt(heroNum)).addWeapon(weapon);
                        } else {
                            System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this weapon");
                        }
                    }
                }
                // choose to buy spells
                // need to specify the type of spell
                else if (itemType.equals("spell")){
                    System.out.println("Please enter the type of spell you want to buy: (ice, fire, light)");
                    String spellType = scanner.nextLine();
                    while (!spellType.equals("ice") && !spellType.equals("fire") && !spellType.equals("light")){
                        System.out.println("Not valid input! Please enter ice/fire/light");
                        spellType = scanner.nextLine();
                    }
                    // choose to buy ice spell
                    if(spellType.equals("ice")){
                        System.out.println("Please enter the index of the ice spell you want to buy");
                        String itemNum = scanner.nextLine();
                        while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 3)){
                            System.out.println("Not valid input! Please enter an integer from 0 to 3");
                            itemNum = scanner.nextLine();
                        }
                        Spell spell = Market.getSpell(Integer.parseInt(itemNum), "ice");
                        Player.showHeros();
                        System.out.println("Please enter the index of the hero to pay");
                        String heroNum = scanner.nextLine();
                        while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                            heroNum = scanner.nextLine();
                        }
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < spell.getLevel()){
                            System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                        } else {
                            if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= spell.getPrice()){
                                Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - spell.getPrice());
                                Player.getHeros().get(Integer.parseInt(heroNum)).addSpell(spell);
                            } else {
                                System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this spell");
                            }
                        }
                    }
                    // choose to buy fire spell
                    else if (spellType.equals("fire")){
                        System.out.println("Please enter the index of the fire spell you want to buy");
                        String itemNum = scanner.nextLine();
                        while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 4)){
                            System.out.println("Not valid input! Please enter an integer from 0 to 4");
                            itemNum = scanner.nextLine();
                        }
                        Spell spell = Market.getSpell(Integer.parseInt(itemNum), "fire");
                        Player.showHeros();
                        System.out.println("Please enter the index of the hero to pay");
                        String heroNum = scanner.nextLine();
                        while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                            heroNum = scanner.nextLine();
                        }
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < spell.getLevel()){
                            System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                        } else {
                            if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= spell.getPrice()){
                                Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - spell.getPrice());
                                Player.getHeros().get(Integer.parseInt(heroNum)).addSpell(spell);
                            } else {
                                System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this spell");
                            }
                        }
                    }
                    // choose to buy lightning spell
                    else {
                        System.out.println("Please enter the index of the lightning spell you want to buy");
                        String itemNum = scanner.nextLine();
                        while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 3)){
                            System.out.println("Not valid input! Please enter an integer from 0 to 3");
                            itemNum = scanner.nextLine();
                        }
                        Spell spell = Market.getSpell(Integer.parseInt(itemNum), "light");
                        Player.showHeros();
                        System.out.println("Please enter the index of the hero to pay");
                        String heroNum = scanner.nextLine();
                        while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                            heroNum = scanner.nextLine();
                        }
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < spell.getLevel()){
                            System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                        } else {
                            if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= spell.getPrice()){
                                Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - spell.getPrice());
                                Player.getHeros().get(Integer.parseInt(heroNum)).addSpell(spell);
                            } else {
                                System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this spell");
                            }
                        }
                    }
                }
                // choose to buy potion
                else {
                    System.out.println("Please enter the index of the potion you want to buy");
                    String itemNum = scanner.nextLine();
                    while(!canParseInt(itemNum) || (Integer.parseInt(itemNum) < 0 && Integer.parseInt(itemNum) > 5)){
                        System.out.println("Not valid input! Please enter an integer from 0 to 5");
                        itemNum = scanner.nextLine();
                    }
                    Potion potion = Market.getPotion(Integer.parseInt(itemNum));
                    Player.showHeros();
                    System.out.println("Please enter the index of the hero to pay");
                    String heroNum = scanner.nextLine();
                    while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                        System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                        heroNum = scanner.nextLine();
                    }
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getLevel() < potion.getLevel()){
                        System.out.println("[Hero]" + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Level not enough! Purchase failed!");
                    } else {
                        if(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() >= potion.getPrice()){
                            Player.getHeros().get(Integer.parseInt(heroNum)).setGold(Player.getHeros().get(Integer.parseInt(heroNum)).getGold() - potion.getPrice());
                            Player.getHeros().get(Integer.parseInt(heroNum)).addPotion(potion);
                        } else {
                            System.out.println("Purchase failed! " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + " can not afford this potion");
                        }
                    }
                }
                System.out.println("Purchase successes! Do you want to keep shopping? (y/n)");
                if(!yOrnProblem()){
                    stayMarket = false;
                }
            } else {
                // sell items
                Player.showHeros();
                int countEmpty = 0;
                for(Hero h: Player.getHeros()){
                    if(h.getBag().getArmors().size() == 0 && h.getBag().getWeapons().size() == 0 &&
                    h.getBag().getSpells().size() == 0 && h.getBag().getPotions().size() == 0){
                        countEmpty++;
                    }
                }
                if(countEmpty == Player.getHeros().size()){
                    // all hero's bag is empty, nothing to sell
                    System.out.println("All you hero's bag are empty! Cannot sell any items");
                    continue;
                }
                System.out.println("Please enter the index of the hero who sells items");
                String heroNum = scanner.nextLine();
                while(!canParseInt(heroNum) || (Integer.parseInt(heroNum) < 0 && Integer.parseInt(heroNum) >= Player.getHeros().size())){
                    System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().size()-1));
                    heroNum = scanner.nextLine();
                }
                System.out.println(Player.getHeros().get(Integer.parseInt(heroNum)));
                System.out.println("Please enter the type of item to sell. (armor/weapon/spell/potion)");
                String itemType = scanner.nextLine();
                while (!itemType.equals("armor") && !itemType.equals("weapon") && !itemType.equals("spell") && !itemType.equals("potion")){
                    System.out.println("Not valid input! Please enter armor/weapon/spell/potion");
                    itemType = scanner.nextLine();
                }
                // choose to sell armor
                if(itemType.equals("armor")){
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getArmors().size() == 0){
                        System.out.println("[Hero] " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Does not have any armors.");
                    } else {
                        System.out.println("Please enter the index of the armor to sell");
                        String itemIndex = scanner.nextLine();
                        while(!canParseInt(itemIndex) || (Integer.parseInt(itemIndex) < 0 && Integer.parseInt(itemIndex) >= Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getArmors().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getArmors().size()-1));
                            itemIndex = scanner.nextLine();
                        }
                        Player.getHeros().get(Integer.parseInt(heroNum)).sellArmor(Integer.parseInt(itemIndex));
                    }
                }
                // choose to sell weapon
                else if(itemType.equals("weapon")){
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getWeapons().size() == 0){
                        System.out.println("[Hero] " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Does not have any weapons.");
                    } else {
                        System.out.println("Please enter the index of the weapon to sell");
                        String itemIndex = scanner.nextLine();
                        while(!canParseInt(itemIndex) || (Integer.parseInt(itemIndex) < 0 && Integer.parseInt(itemIndex) >= Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getWeapons().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getWeapons().size()-1));
                            itemIndex = scanner.nextLine();
                        }
                        Player.getHeros().get(Integer.parseInt(heroNum)).sellWeapon(Integer.parseInt(itemIndex));
                    }
                }
                // choose to sell spell
                else if(itemType.equals("spell")){
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getSpells().size() == 0){
                        System.out.println("[Hero] " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Does not have any spells.");
                    } else {
                        System.out.println("Please enter the index of the spell to sell");
                        String itemIndex = scanner.nextLine();
                        while(!canParseInt(itemIndex) || (Integer.parseInt(itemIndex) < 0 && Integer.parseInt(itemIndex) >= Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getSpells().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getSpells().size()-1));
                            itemIndex = scanner.nextLine();
                        }
                        Player.getHeros().get(Integer.parseInt(heroNum)).sellSpell(Integer.parseInt(itemIndex));
                    }
                }
                // choose to sell potion
                else {
                    if(Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getPotions().size() == 0){
                        System.out.println("[Hero] " + Player.getHeros().get(Integer.parseInt(heroNum)).getName() + "> Does not have any potions.");
                    } else {
                        System.out.println("Please enter the index of the armor to sell");
                        String itemIndex = scanner.nextLine();
                        while(!canParseInt(itemIndex) || (Integer.parseInt(itemIndex) < 0 && Integer.parseInt(itemIndex) >= Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getPotions().size())){
                            System.out.println("Not valid input! Please enter an integer from 0 to " + (Player.getHeros().get(Integer.parseInt(heroNum)).getBag().getPotions().size()-1));
                            itemIndex = scanner.nextLine();
                        }
                        Player.getHeros().get(Integer.parseInt(heroNum)).sellPotion(Integer.parseInt(itemIndex));
                    }
                }
                System.out.println("Do you want to keep shopping? (y/n)");
                if(!yOrnProblem()){
                    stayMarket = false;
                }
            }
        }
    }
}
