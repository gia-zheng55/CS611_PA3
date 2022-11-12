import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeaponFactory {
    String WEAPON_MENU = "Weaponry.txt";
    private ArrayList<ArrayList<String>> weapons;

    public WeaponFactory(){
        weapons = initialize();
    }

    private ArrayList<ArrayList<String>> initialize(){
        String delimAlias = "/";
        String delimData = "\\s+";
        String file = System.getProperty("user.dir") + "/Legends_Monsters_and_Heroes/" + WEAPON_MENU;
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
            System.out.println("ERROR (DataReader): File " + WEAPON_MENU + " not found.");
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<String> getWeapon(int index){
        return weapons.get(index);
    }

    public void showWeapons(){
        for(int i = 0; i<6;i++) {
            System.out.print(i+" -- ");
            System.out.println(weapons.get(i));
        }
    }
}
