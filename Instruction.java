public class Instruction {

    // control the static instruction output of the game
    public static void introduction(){
        System.out.println("Welcome to the game: 'Legends: Heros and Monsters'!" + "\n");
        System.out.println("1. You can add " + "1-3" + " heros in your team" + "\n");
        System.out.println("2. There are three kinds of fields on the map, " + "'X' " +
                " is the inaccessible spot, " +
                "'M' is the market, " +
                "'H' is heros' position, and others are blank spots." + "\n");
        System.out.println("3. In the market, you can buy or sell items you have to gain money\n");
        System.out.println("4. You may meet monsters in blank areas and you will fight with them. " +
                "Once ALL your hero dead, GAME OVER!" + "\n");
        System.out.println("5. HIGHLY RECOMMEND go to the market first at the beginning of the game!" + "\n");
        System.out.println("Below are the operations player can choose in the game:" + "\n");
        System.out.println("+---------------------------------------+");
        System.out.print("W/w: Move up." + "            ");
        System.out.println("S/s: Move down.");
        System.out.print("A/a: Move left." + "          ");
        System.out.println("D/d: Move right");
        System.out.print("I/i: Show information." + "   ");
        System.out.println("Q/q: Quit.");
        System.out.println("+---------------------------------------+");
        System.out.println("\n" + "Have fun!");
    }

    public static void quit(){
        System.out.println("Game ends! Bye~" + "\n");
        System.exit(0);
    }
}
