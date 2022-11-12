public class Character {
    private String name;
    private int level;
    private int HP;
    private double dodge;

    public Character(String name, int level){
        this.name = name;
        this.level = level;
        this.HP = level * 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void addLevel() {
        this.level++;
        setHP(level * 100);
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }
}
