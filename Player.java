import java.util.ArrayList;

public class Player {
    private static ArrayList<Hero> heros = new ArrayList<>();

    public static ArrayList<Hero> getHeros(){
        return heros;
    }

    public static void addHero(Hero hero){
        heros.add(hero);
    }

    public static void showHeros(){
        System.out.println("--------------------------YOUR HEROS--------------------------");
        for(int i = 0; i<heros.size();i++) {
            System.out.println("     [Name, level, HP, MP, strength, dexterity, agility, gold, experience]\n");
            System.out.print(i+" -- ");
            System.out.println(heros.get(i));
        }
    }
}
