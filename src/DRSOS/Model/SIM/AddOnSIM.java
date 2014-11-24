package DRSOS.model.SIM;

import DRSOS.data.Coordinate;
import DRSOS.data.Map;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class AddOnSIM extends SIM {
    private ADDON addon;

    public AddOnSIM(Map map) {
        super(map);
    }

    public boolean move(Coordinate i, Coordinate f) {

        return true;
    }
}
