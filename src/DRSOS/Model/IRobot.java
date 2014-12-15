package DRSOS.model;

import DRSOS.domain.Coordinate;
import DRSOS.domain.DIRECTION;

/**
 * Created by goznauk on 2014. 12. 15..
 */
public interface IRobot {
    public void move(DIRECTION d);
    public boolean sensorHazard(DIRECTION d);
    public void sensorColorBlob();
    public Coordinate sensorPosition();
}
