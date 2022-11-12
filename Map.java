import java.util.HashSet;

public class Map {
    private Cell[][] map;
    // used to record the current position of player
    private int heroRow;
    private int heroCol;

    public Map(){
        map = new Cell[8][8];
        heroRow = 4;
        heroCol = 0;
        initializeMap();
    }

    public Cell[][] getMap() {
        return map;
    }

    public Cell getPosition(int row, int col){
        return map[row][col];
    }

    public int[] getHeroPosition() {
        return new int[]{heroRow, heroCol};
    }

    // update player's position after move
    public void setHeroPosition(int heroRow, int heroCol) {
        map[heroRow][heroCol].setFigure(" ");
        this.heroRow = heroRow;
        this.heroCol = heroCol;
        map[heroRow][heroCol].setFigure("H");
    }

    public String getFigure(int row, int col){
        return map[row][col].getFigure();
    }

    // initialize inaccessible area
    private void initializeStone(){
        map[0][2] = new Cell("&");
        map[2][1] = new Cell("&");
        map[6][1] = new Cell("&");
        map[2][2] = new Cell("&");
        map[6][3] = new Cell("&");
        map[0][4] = new Cell("&");
        map[0][6] = new Cell("&");
        map[0][7] = new Cell("&");
        map[5][5] = new Cell("&");
        map[5][6] = new Cell("&");
        map[1][0] = new Cell("&");
        map[2][7] = new Cell("&");
        map[3][7] = new Cell("&");
    }

    // initialize market area
    private void initializeMarket(){
        map[0][0] = new Cell("M");
        map[0][3] = new Cell("M");
        map[0][5] = new Cell("M");
        map[1][1] = new Cell("M");
        map[1][3] = new Cell("M");
        map[1][5] = new Cell("M");
        map[1][7] = new Cell("M");
        map[2][4] = new Cell("M");
        map[3][3] = new Cell("M");
        map[3][6] = new Cell("M");
        map[4][5] = new Cell("M");
        map[5][0] = new Cell("M");
        map[5][2] = new Cell("M");
        map[5][4] = new Cell("M");
        map[5][7] = new Cell("M");
        map[6][5] = new Cell("M");
        map[7][0] = new Cell("M");
        map[7][3] = new Cell("M");
        map[7][7] = new Cell("M");
    }

    public void initializeMap(){
        initializeStone();
        initializeMarket();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if (i == heroRow && j == heroCol){
                    map[i][j] = new Cell("H");
                } else if (map[i][j] == null){
                    map[i][j] = new Cell(" ");
                }
            }
        }
    }

    public void printMap(){
        String print = "";
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                print += "+ --- ";
            }
            print += "+\n";
            for(int j = 0; j < map[0].length; j++){
                String figure = map[i][j].getFigure();
                print += "| ";
                if(figure.equals("M")){
                    print += " " + figure +"  ";
                } else if(figure.equals("H")){
                    print += " " + figure +"  ";
                } else if (figure.equals("M/H")){
                    print += figure +" ";
                } else {
                    print += " " + figure + "  ";
                }
            }
            print += "|";
            print += "\n";
        }
        for(int i = 0; i < map[0].length; i++){
            print += "+ --- ";
        }
        print += "+\n";
        print += "&: Non accessible area, " + "M: Market, " + "H(M/H): Your Position  ";
        System.out.println(print);
    }
}
