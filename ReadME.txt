# CS611-Assignment 3
## Hero and Monster
---------------------------------------------------------------------------
Zhi Zheng
zhengz83@bu.edu
U92700642

## Files
---------------------------------------------------------------------------
1. dic<Legends_Monsters_and_Heroes>: text files, recording all informations
2. Armor.java: extends Item, Armor objects
3. ArmorFactory.java: read armor information file and record
4. Bag.java: contains all items of one hero
5. Battle.java: control the process of a battle
6. Cell.java: single element on the map, have market or monsters
7. Character.java: super class of Hero and Monster
8. Game: control the process of the game, including move, enter market, battle,
quit.
9. Hero.java: extends Character, class of hero object, contains attack/defense etc. operations
10. HeroFactory.java: read hero information file and record
11. Instruction.java: conatins output of the start and the end of the game
12. item.java: super class of Armor, Weapon, Spell and Potion
13. Main.java: class to run the project
14. Monster.java: extends Character, class of monster object, contains attack/defense etc. operations
15. MonsterFactory.java: read monster information file and record
16. Player.java: static class, contains a list of hero
17. Potion.java: extends Item, class of Potion object
18. PotionFactory.java: read potion information file and record
19. Spell.java: extends Item, class of Spell object
20. SpellFactory.java: read spell information file and record
21. Weapon.java: extends Item, class of Weapon object
22. WeaponFactory.java: read weapon information file and record

## How to compile and run
---------------------------------------------------------------------------
1. Unzip the files
2. Run the following instructions
javac Main.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
Welcome to the game: 'Legends: Heros and Monsters'!

1. You can add 1-3 heros in your team

2. There are three kinds of fields on the map, 'X'  is the inaccessible spot, 'M' is the market, 'H' is heros' position, and others are blank spots.

3. In the market, you can buy or sell items you have to gain money

4. You may meet monsters in blank areas and you will fight with them. Once ALL your hero dead, GAME OVER!

5. HIGHLY RECOMMEND go to the market first at the beginning of the game!

Below are the operations player can choose in the game:

+---------------------------------------+
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
I/i: Show information.   Q/q: Quit.
+---------------------------------------+

Have fun!
--------------------------WARRIORS--------------------------
     [Name, mana, strength, agility, dexterity, starting money, starting experience]
0 -- [Gaerdal_Ironhand, 100, 700, 500, 600, 1354, 7]
1 -- [Sehanine_Monnbow, 600, 700, 800, 500, 2500, 8]
2 -- [Muamman_Duathall, 300, 900, 500, 750, 2546, 6]
3 -- [Flandal_Steelskin, 200, 750, 650, 700, 2500, 7]
4 -- [Undefeated_Yoj, 400, 800, 400, 700, 2500, 7]
5 -- [Eunoia_Cyn, 400, 700, 800, 600, 2500, 6]
--------------------------PALADINS--------------------------
     [Name, mana, strength, agility, dexterity, starting money, starting experience]
0 -- [Parzival, 300, 750, 650, 700, 2500, 7]
1 -- [Sehanine_Moonbow, 300, 750, 700, 700, 2500, 7]
2 -- [Skoraeus_Stonebones, 250, 650, 600, 350, 2500, 4]
3 -- [Garl_Glittergold, 100, 600, 500, 400, 2500, 5]
4 -- [Amaryllis_Astra, 500, 500, 500, 500, 2500, 5]
5 -- [Caliber_Heist, 400, 400, 400, 400, 2500, 8]
-------------------------SORCERERS-------------------------
     [Name, mana, strength, agility, dexterity, starting money, starting experience]
0 -- [Rillifane_Rallathil, 1300, 750, 450, 500, 2500, 9]
1 -- [Segojan_Earthcaller, 900, 800, 500, 650, 2500, 5]
2 -- [Reign_Havoc, 800, 800, 800, 800, 2500, 8]
3 -- [Reverie_Ashels, 900, 800, 700, 400, 2500, 7]
4 -- [Kalabar, 800, 850, 400, 600, 2500, 6]
5 -- [Skye_Soar, 1000, 700, 400, 500, 2500, 5]
How many heros would you want to choose? (1-3)
2
Hero 1: What kind of hero would you want to choose? (warrior, paladin, sorcerer)
warrior
Please enter the index of the warrior
0
Hero 2: What kind of hero would you want to choose? (warrior, paladin, sorcerer)
paladin
Please enter the index of the paladin
2
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  H  |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
i
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  H  |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
--------------------------YOUR HEROS--------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 1354 - 7

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4

+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  H  |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
s
Market area! Do you want to enter the market? (y/n)
y
Welcome to the Market!

--------------------------ARMORS--------------------------
     [Name, cost, level, damage reduction]
0 -- [Platinum_Shield, 150, 1, 200]
1 -- [Breastplate, 350, 3, 600]
2 -- [Full_Body_Armor, 1000, 8, 1100]
3 -- [Wizard_Shield, 1200, 10, 1500]
4 -- [Guardian_Angel, 1000, 10, 1000]
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- [Sword, 500, 1, 800, 1]
1 -- [Bow, 300, 2, 500, 2]
2 -- [Scythe, 1000, 6, 1100, 2]
3 -- [Axe, 550, 5, 850, 1]
4 -- [TSwords, 1400, 8, 1600, 2]
5 -- [Dagger, 200, 1, 250, 1]
-------------------------ICESPELLS-------------------------
     [Name, cost, level, damage, mana cost]
0 -- [Snow_Cannon, 500, 2, 650, 250]
1 -- [Ice_Blade, 250, 1, 450, 100]
2 -- [Frost_Blizzard, 750, 5, 850, 350]
3 -- [Arctic_Storm, 700, 6, 800, 300]
-------------------------FIRESPELLS-------------------------
     [Name, cost, level, damage, mana cost]
0 -- [Flame_Tornado, 700, 4, 850, 300]
1 -- [Breath_of_Fire, 350, 1, 450, 100]
2 -- [Heat_Wave, 450, 2, 600, 150]
3 -- [Lava_Comet, 800, 7, 1000, 550]
4 -- [Hell_Storm, 600, 3, 950, 600]
-----------------------LIGHTNINGSPELLS-----------------------
     [Name, cost, level, damage, mana cost]
0 -- [Lightning_Dagger, 400, 1, 500, 150]
1 -- [Thunder_Blast, 750, 4, 950, 400]
2 -- [Electric_Arrows, 550, 5, 650, 200]
3 -- [Spark_Needles, 500, 2, 600, 200]
--------------------------POTIONS--------------------------
     [Name, cost, level, attribute increase, attribute affected]
0 -- [Healing_Potion, 250, 1, 100, Health]
1 -- [Strength_Potion, 200, 1, 75, Strength]
2 -- [Magic_Potion, 350, 2, 100, Mana]
3 -- [Luck_Elixir, 500, 4, 65, Agility]
4 -- [Mermaid_Tears, 850, 5, 100, Health/Mana/Strength/Agility]
5 -- [Ambrosia, 1000, 8, 150, All, Health/Mana/Strength/Dexterity/Defense/Agility]
Do you want to buy or sell items? b(buy)/s(sell)
b
Please enter the type of item you want to buy: (armor, weapon, spell, potion)
weapon
Please enter the index of the weapon you want to buy
2
--------------------------YOUR HEROS--------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 1354 - 7

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4

Please enter the index of the hero to pay
0
[Hero]Gaerdal_Ironhand> Level not enough! Purchase failed!
Purchase successes! Do you want to keep shopping? (y/n)
y
Do you want to buy or sell items? b(buy)/s(sell)
b
Please enter the type of item you want to buy: (armor, weapon, spell, potion)
weapon
Please enter the index of the weapon you want to buy
0
--------------------------YOUR HEROS--------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 1354 - 7

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4

Please enter the index of the hero to pay
0
Purchase successes! Do you want to keep shopping? (y/n)
n
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
| M/H |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
d
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |  H  |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
s
Inaccessible area! Please try another direction.
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |  H  |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
w
[1;31mMonsters! Ready to fight[0m
--------------------------MONSTER--------------------------
     [Name, level, HP, damage, defense]
0 -- Natsunomeryu - 1 - 100 - 100 - 200
1 -- BigBad-Wolf - 1 - 100 - 150 - 250
---------------------------HEROS---------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 854 - 7
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- Sword - 1 - 500 - 800

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4


[Hero] Gaerdal_Ironhand>Would you like to a(attack)/c(cast a spell)/p(use a potion)/e(equip weapon or armor)?
e
[Hero] Gaerdal_Ironhand> Would you want to equip armor/weapon for Gaerdal_Ironhand? a(armor)/w(weapon)/n(not equip)
w
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- Sword - 1 - 500 - 800

[Hero] Gaerdal_Ironhand>Which weapon would you want to equip for Gaerdal_Ironhand?
0
[Hero] Gaerdal_Ironhand> Equips weapon Sword
[Monster] Natsunomeryu> attack: damage=100
[Hero] Gaerdal_Ironhand: Dodged the attack!
--------------------------MONSTER--------------------------
     [Name, level, HP, damage, defense]
0 -- Natsunomeryu - 1 - 100 - 100 - 200
1 -- BigBad-Wolf - 1 - 100 - 150 - 250
---------------------------HEROS---------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 854 - 7
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- Sword - 1 - 500 - 800

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4


[Hero] Gaerdal_Ironhand>Would you like to a(attack)/c(cast a spell)/p(use a potion)/e(equip weapon or armor)?
a
[Hero] Gaerdal_Ironhand> regular attack: damage=740
[Monster] Natsunomeryu> attack: damage=100
[Hero] Gaerdal_Ironhand: Dodged the attack!
--------------------------MONSTER--------------------------
     [Name, level, HP, damage, defense]
0 -- Natsunomeryu - 1 - 0 - 100 - 200
1 -- BigBad-Wolf - 1 - 100 - 150 - 250
---------------------------HEROS---------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
0 -- Gaerdal_Ironhand - 1 - 100 - 100 - 700 - 600 - 500 - 854 - 7
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- Sword - 1 - 500 - 800

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]
1 -- Skoraeus_Stonebones - 1 - 100 - 250 - 650 - 350 - 600 - 2500 - 4


[Hero] Gaerdal_Ironhand>Would you like to a(attack)/c(cast a spell)/p(use a potion)/e(equip weapon or armor)?
a
[Hero] Gaerdal_Ironhand> regular attack: damage=740
Battle ends!
YOU WIN!

[Hero]Gaerdal_Ironhand> gain 100 gold.
[Hero]Gaerdal_Ironhand> gain 4 experience.
[Hero]Gaerdal_Ironhand> Level up!
[Hero]Skoraeus_Stonebones> gain 100 gold.
[Hero]Skoraeus_Stonebones> gain 4 experience.
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  H  |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
i
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  H  |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
--------------------------YOUR HEROS--------------------------
     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

0 -- Gaerdal_Ironhand - 2 - 220 - 121 - 771 - 630 - 551 - 954 - 1
--------------------------WEAPONS--------------------------
     [Name, cost, level, damage, required hands]
0 -- Sword - 1 - 500 - 800

     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]

1 -- Skoraeus_Stonebones - 1 - 110 - 275 - 650 - 350 - 600 - 2600 - 8

+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  &  |  M  |  &  |  M  |  &  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  &  |  M  |     |  M  |     |  M  |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |  &  |     |  M  |     |     |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |     |     |  M  |     |     |  M  |  &  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  H  |     |     |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |  M  |     |  M  |  &  |  &  |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|     |  &  |     |  &  |     |  M  |     |     |
+ --- + --- + --- + --- + --- + --- + --- + --- +
|  M  |     |     |  M  |     |     |     |  M  |
+ --- + --- + --- + --- + --- + --- + --- + --- +
&: Non accessible area, M: Market, H(M/H): Your Position
Choose one operation: W/w(Up), S/s(Down), A/a(Left), D/d(Right), I/i(Information), Q/q(Quit)
q
Game ends! Bye~