package DRSOS.model;

import DRSOS.domain.*;

import java.util.Random;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SimulatorModel extends BaseModel implements IRobot {

    public SimulatorModel(Map map) {
        super(map);
    }


    // Robot Interface

    @Override
    public void move(DIRECTION d) {
        Coordinate target = map.getRobot().addDirection(d);
        if(target != null) {
            // fake move fault
            Random random = new Random();
            int rand = random.nextInt(100);
            if(rand < 2) {
                // Do not move
                return;
            } else if(rand > 98) {
                if(target.addDirection(d) != null) {
                    target = target.addDirection(d);
                }
            }

            map.setRobot(target);
            map.getBlocks()[target.toID()].reveal();
            callbackEvent.onMapChanged(map);
        }
    }

    @Override
    public boolean sensorHazard(DIRECTION d) {
        Coordinate target = map.getRobot().addDirection(d);
        if (target != null) {
            Block block = map.getBlocks()[target.toID()];
            if (block.getBlocktype() == BLOCKTYPE.HAZARD) {
                block.reveal();
                callbackEvent.onMapChanged(map);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public void sensorColorBlob() {
        Coordinate target;
        for(int i = 0; i < 4; i++) {
            target = map.getRobot().addDirection(DIRECTION.fromInteger(i));
            if (target != null) {
                if (map.getBlocks()[target.toID()].getBlocktype() == BLOCKTYPE.COLORBLOB) {
                    map.getBlocks()[target.toID()].reveal();
                }
            }
        }
        callbackEvent.onMapChanged(map);
    }

    @Override
    public Coordinate sensorPosition() {
        return map.getRobot();
    }
}
