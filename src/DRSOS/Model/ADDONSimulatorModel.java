package DRSOS.model;

import DRSOS.model.SIM.AddOnSIM;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class ADDONSimulatorModel extends SimulatorModel {
    public ADDONSimulatorModel() {
        sim = new AddOnSIM(map);
    }
}
