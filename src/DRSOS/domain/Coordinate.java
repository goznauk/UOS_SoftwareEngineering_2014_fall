package DRSOS.domain;

import java.lang.*;
import java.util.Objects;

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
        return x + y * 20;
    }

    public static Coordinate getCoordinateFromID(int id) {
        return new Coordinate(id % 20, id / 20);
    }

    public Coordinate addDirection(DIRECTION d) {
        int newX = 0, newY = 0;
        if (d == DIRECTION.NORTH) {
            newY--;
        } else if (d == DIRECTION.EAST) {
            newX++;
        } else if (d == DIRECTION.SOUTH) {
            newY++;
        } else if (d == DIRECTION.WEST) {
            newX--;
        }

        newX = newX + x;
        newY = newY + y;

        if (newX < 0 || newX >= 20 || newY < 0 || newY >= 20) {
            return null;
        }

        return new Coordinate(newX, newY);
    }

    public DIRECTION calculateDirection(Coordinate coordinate) {
        int newX = coordinate.x - this.x, newY = coordinate.y - this.y;
        if(newX == -1) {
            return DIRECTION.WEST;
        }
        if(newX == 1) {
            return DIRECTION.EAST;
        }
        if(newY == 1) {
            return DIRECTION.SOUTH;
        }
        if(newY == -1) {
            return DIRECTION.NORTH;
        }
        return null;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
