import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonsterFactory {
    // monster need not to be selectable
    private static ArrayList<ArrayList<String>> dragons = initialize("Dragons.txt");
    private static ArrayList<ArrayList<String>> exos = initialize("Exoskeletons.txt");
    private static ArrayList<ArrayList<String>> spirits = initialize("Spirits.txt");

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

    public static ArrayList<ArrayList<String>> getDragons() {
        return dragons;
    }

    public static ArrayList<ArrayList<String>> getExos() {
        return exos;
    }

    public static ArrayList<ArrayList<String>> getSpirits() {
        return spirits;
    }
}
