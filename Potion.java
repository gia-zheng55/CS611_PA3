import java.util.ArrayList;

public class Potion extends Item{
    private int effect;
    // Health Mana Strength Dexterity Defense Agility
    // used when using the potion
    private boolean[] attributes;
    // used to show the attribute of the potion
    private String attr;

    public Potion(ArrayList<String> info) {
        super(info.get(0), Integer.parseInt(info.get(1)), Integer.parseInt(info.get(2)));
        // initialization
        this.effect = Integer.parseInt(info.get(3));
        this.attr = info.get(4);
        this.attributes = new boolean[]{false,false,false,false,false,false};
        String[] output = attr.split("/");
        for(String i: output) {
            if(i.equals("Health")) {this.attributes[0]=true;}
            else if(i.equals("Mana")) {this.attributes[1]=true;}
            else if(i.equals("Strength")) {this.attributes[2]=true;}
            else if(i.equals("Dexterity")) {this.attributes[3]=true;}
            else if(i.equals("Defense")) {this.attributes[4]=true;}
            else {this.attributes[5]=true;}
        }

    }

    public int getEffect() {
        return effect;
    }

    public boolean[] getAttributes() {
        return attributes;
    }

    public String getAttr() {
        return attr;
    }

    public String toString(){
        return getName() + " - " + getPrice() + " - " + getLevel() + " - " + getEffect() + " - " + getAttr();
    }
}
