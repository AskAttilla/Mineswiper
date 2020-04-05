
public class Bomb extends Tile{
    

    protected Bomb(int pRow, int pCol) {
        super(pRow, pCol);
    }

    @Override
    public boolean isBomb(){
        return false;
    }

}