public class Tile {
    Tile north = null;
    Tile east = null;
    Tile south = null;
    Tile west = null;

    int col;
    int row;

    boolean visited;

    protected Tile(int pRow, int pCol) {
        col = pCol;
        row = pRow;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setNeighbour(Tile tile, String dir) {
        switch (dir) {
            case "north":
                north = tile;
                break;
            case "east":
                east = tile;
                break;
            case "south":
                south = tile;
                break;
            case "west":
                west = tile;
                break;
        }
    }

    public void printNeighbours() {
        System.out.println("CurrentTile: " + this);
        System.out.println("North: " + north);
        System.out.println("East: " + east);
        System.out.println("South: " + south);
        System.out.println("West: " + west);
    }

    public boolean equal(Tile t) {
        if (t == null) {
            return false;
        } else if (getCol() == t.getCol() && getRow() == t.getRow()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return getRow() + ", " + getCol();
    }

    public void setVisited(boolean visit) {
        visited = visit;
    }

    public boolean isBomb(){
        return false;
    }
}