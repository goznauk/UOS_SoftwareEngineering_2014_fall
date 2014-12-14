package DRSOS.entity;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public enum BLOCKTYPE {
    DEFAULT, HAZARD, COLORBLOB;

    public static BLOCKTYPE fromInteger(int x) {
        switch(x) {
            case 0:
                return DEFAULT;
            case 1:
                return HAZARD;
            case 2:
                return COLORBLOB;
        }
        return null;
    }
}
