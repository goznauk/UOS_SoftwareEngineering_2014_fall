package DRSOS.model;

import DRSOS.entity.Map;
import DRSOS.model.SIM.SIM;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SimulatorModel extends BaseModel {
    protected SIM sim;


    public SimulatorModel(Map map) {
        super(map);
        sim = new SIM(map);
        sim.setCallbackEvent(callbackEvent);
    }
}
