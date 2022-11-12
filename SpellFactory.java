import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpellFactory {
    private ArrayList<ArrayList<String>> iceSpells;
    private ArrayList<ArrayList<String>> fireSpells;
    private ArrayList<ArrayList<String>> lightningSpells;

    public SpellFactory(){
        iceSpells = initialize("IceSpells.txt");
        fireSpells = initialize("FireSpells.txt");
        lightningSpells = initialize("LightningSpells.txt");
    }

    private ArrayList<ArrayList<String>> initialize(String filename){
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

    public ArrayList<ArrayList<String>> getIceSpells() {
        return iceSpells;
    }

    public ArrayList<ArrayList<String>> getFireSpells() {
        return fireSpells;
    }

    public ArrayList<ArrayList<String>> getLightningSpells() {
        return lightningSpells;
    }

    public ArrayList<String> getIceSpell(int index){
        return iceSpells.get(index);
    }

    public ArrayList<String> getFireSpell(int index){
        return fireSpells.get(index);
    }

    public ArrayList<String> getLightningSpell(int index){
        return lightningSpells.get(index);
    }

    // used when buying a specific type of spell
    public void showIceSpells(){
        for(int i = 0; i<4;i++) {
            System.out.print(i+" -- ");
            System.out.println(iceSpells.get(i));
        }
    }

    public void showFireSpells(){
        for(int i = 0; i<5;i++) {
            System.out.print(i+" -- ");
            System.out.println(fireSpells.get(i));
        }
    }

    public void showLightningSpells(){
        for(int i = 0; i<4;i++) {
            System.out.print(i+" -- ");
            System.out.println(lightningSpells.get(i));
        }
    }
}
