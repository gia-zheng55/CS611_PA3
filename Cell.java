import java.util.Random;

public class Cell {
    private String figure;
    private boolean hasMonster;

    public Cell(String figure){
        this.figure  = figure;
        hasMonster = false;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    protected void rollMonster() {
        // initially all cells are safe
        // randomly assign monsters to cell
        Random random = new Random();
        setHasMonster(random.nextBoolean());
    }

    // everytime the hero win a battle, turn the cell return to safe
    public void setHasMonster(boolean hasMonster){
        this.hasMonster = hasMonster;
    }
}
