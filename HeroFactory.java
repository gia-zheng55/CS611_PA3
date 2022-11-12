import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeroFactory {
    private static ArrayList<ArrayList<String>> warriors = initialize("Warriors.txt");
    private static ArrayList<ArrayList<String>> paladins = initialize("Paladins.txt");
    private static ArrayList<ArrayList<String>> sorcerers = initialize("Sorcerers.txt");

    private static ArrayList<ArrayList<String>> initialize(String filename){
        String delimAlias = "/";
        String delimData = "\\s+";
        String file = System.getProperty("user.dir") + "/Legends_Monsters_and_Heroes/" + filename;
        List<String> lines = Collections.emptyList();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            List<String> aliasList = new ArrayList<String>(Arrays.asList(lines.get(0).split(delimAlias)));
            //System.out.println(aliasList);
            for (int i = 1; i < lines.size(); i++) {    // skip the first line of alias
                ArrayList<String> attriList = new ArrayList<String>(Arrays.asList(lines.get(i).split(delimData)));
                if (attriList.size() > 0 && !attriList.get(0).equals("")) {
                    result.add(attriList);
                }
            }
        }
        catch (IOException e) {
            System.out.println("ERROR (DataReader): File " + filename + " not found.");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> getWarriors() {
        return warriors;
    }

    public static ArrayList<ArrayList<String>> getPaladins() {
        return paladins;
    }

    public static ArrayList<ArrayList<String>> getSorcerers() {
        return sorcerers;
    }

    public static ArrayList<String> getWarrior(int index){
        return warriors.get(index);
    }

    public static ArrayList<String> getPaladin(int index){
        return paladins.get(index);
    }

    public static ArrayList<String> getSorcerer(int index){
        return sorcerers.get(index);
    }

    public static void showWarriors(){
        for(int i = 0; i<6;i++) {
            System.out.print(i+" -- ");
            System.out.println(warriors.get(i));
        }
    }

    public static void showPaladins(){
        for(int i = 0; i<6;i++) {
            System.out.print(i+" -- ");
            System.out.println(paladins.get(i));
        }
    }

    public static void showSorcerers(){
        for(int i = 0; i<6;i++) {
            System.out.print(i+" -- ");
            System.out.println(sorcerers.get(i));
        }
    }

    // used in choose hero phase
    public static void showHeros(){
        System.out.println("--------------------------WARRIORS--------------------------");
        System.out.println("     [Name, mana, strength, agility, dexterity, starting money, starting experience]");
        showWarriors();
        System.out.println("--------------------------PALADINS--------------------------");
        System.out.println("     [Name, mana, strength, agility, dexterity, starting money, starting experience]");
        showPaladins();
        System.out.println("-------------------------SORCERERS-------------------------");
        System.out.println("     [Name, mana, strength, agility, dexterity, starting money, starting experience]");
        showSorcerers();
    }
}
