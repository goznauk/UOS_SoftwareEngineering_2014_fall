package DRSOS.model.SIM;

import DRSOS.entity.Coordinate;
import DRSOS.entity.DIRECTION;
import DRSOS.entity.Map;
import DRSOS.model.ModelCallbackEvent;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SIM {
    protected Map map;
    protected Robot robot;
    protected ModelCallbackEvent callbackEvent;

    public SIM(Map map) {
        this.map = map;
        robot = new Robot(map);
    }

    public void moveRobot(DIRECTION d) {
        callbackEvent.onMapChanged(map);
    }

    public boolean sensorHazard(DIRECTION d) {

        callbackEvent.onMapChanged(map);
        return true;
    }

    public void sensorColorBlob() {
        // update map
        callbackEvent.onMapChanged(map);
    }

    public Coordinate sensorPositioning() {

        callbackEvent.onMapChanged(map);
        return new Coordinate(1,1);
    }

    public void setCallbackEvent(ModelCallbackEvent event) {
        this.callbackEvent = event;
    }



}
