import java.util.ArrayList;

public class Armor  extends Item{
    private int damageReduction;

    public Armor(ArrayList<String> infos) {
        super(infos.get(0), Integer.parseInt(infos.get(1)), Integer.parseInt(infos.get(2)));
        this.damageReduction = Integer.parseInt(infos.get(3));
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public String toString(){
        return getName() + " - " + getLevel() + " - " + getPrice() + " - " + getDamageReduction();
    }
}
