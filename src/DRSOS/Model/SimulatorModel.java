package DRSOS.model;

import DRSOS.model.SIM.SIM;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SimulatorModel extends BaseModel {
    protected SIM sim;


    public SimulatorModel() {
        sim = new SIM(map);
        sim.setCallbackEvent(callbackEvent);
    }
}
