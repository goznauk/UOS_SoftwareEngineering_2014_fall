package DRSOS.entity;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Block {
    private Coordinate coordinate;
    private BLOCKTYPE blocktype;
    private boolean isVisible;


    public Block(Coordinate coordinate, BLOCKTYPE blocktype, boolean isVisible) {
        this.coordinate = coordinate;
        this.blocktype = blocktype;
        this.isVisible = isVisible;
    }


    public BLOCKTYPE getBlocktype() {
        return blocktype;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void conceal() {
        isVisible = false;
    }

    public void reveal() {
        isVisible = true;
    }
}
