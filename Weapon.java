import java.util.ArrayList;

public class Weapon extends Item{
    private int damage;

    public Weapon(ArrayList<String> infos){
        super(infos.get(0), Integer.parseInt(infos.get(1)), Integer.parseInt(infos.get(2)));
        this.damage = Integer.parseInt(infos.get(3));
    }

    public int getDamage() {
        return damage;
    }

    public String toString(){
        return getName() + " - " + getLevel() + " - " + getPrice() + " - " + getDamage();
    }
}
