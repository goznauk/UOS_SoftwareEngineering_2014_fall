package DRSOS.model;

import DRSOS.entity.Map;
import DRSOS.model.SIM.AddOnSIM;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class ADDONSimulatorModel extends SimulatorModel {
    public ADDONSimulatorModel(Map map) {
        super(map);
        this.map = map;
        sim = new AddOnSIM(map);
    }
}
