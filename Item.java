public class Item {
    private String name;
    private int price;
    private int level;

    public Item(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }
}
