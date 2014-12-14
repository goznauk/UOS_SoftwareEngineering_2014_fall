package DRSOS.entity;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int toID() {
        return x + y*20;
    }

    public static Coordinate getCoordinateFromID(int id) {
        return new Coordinate(id%20, id/20);
    }
}
