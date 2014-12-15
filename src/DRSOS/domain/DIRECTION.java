package DRSOS.domain;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public enum DIRECTION {
    NORTH, EAST, SOUTH, WEST;


    public static DIRECTION fromInteger(int x) {
        switch(x) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
        }
        return null;
    }
}
