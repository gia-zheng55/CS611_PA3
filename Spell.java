import java.util.ArrayList;

public class Spell extends Item{
    private final int damage;
    private final int mana;
    private final String type;

    public Spell(ArrayList<String> infos, String type) {
        super(infos.get(0), Integer.parseInt(infos.get(1)), Integer.parseInt(infos.get(2)));
        this.damage = Integer.parseInt(infos.get(3));
        this.mana = Integer.parseInt(infos.get(4));
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public int getMana() {
        return mana;
    }

    public String getType() {
        return type;
    }

    public String toString(){
        return getName() + " - " + getLevel() + " - " + getPrice() + " - " + getDamage() + " - " + getMana() + " - " + getType();
    }
}
