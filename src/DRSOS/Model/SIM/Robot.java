package DRSOS.model.SIM;

import DRSOS.data.Coordinate;
import DRSOS.data.DIRECTION;
import DRSOS.data.Map;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Robot {
    private Map map;

    public Robot(Map map) {
        this.map = map;
    }


    public boolean sensorHazard(DIRECTION d) {
        return true;
    }

    public int sensorColorBlob() {
        // up down left right on binary : 1 for true, 0 for false
        return 1111;
    }

    public Coordinate sensorPositioning() {
        return new Coordinate(1,1);
    }

    public void move(DIRECTION d) {
        map.moveRobot(d);
    }
}
