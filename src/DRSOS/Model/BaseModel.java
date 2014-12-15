package DRSOS.model;


import DRSOS.domain.BLOCKTYPE;
import DRSOS.domain.Block;
import DRSOS.domain.Coordinate;
import DRSOS.domain.Map;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public abstract class BaseModel {
    protected Map map;
    protected ModelCallbackEvent callbackEvent;

    public BaseModel() {
        map = new Map();
    }
    
    public BaseModel(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public void setCallbackEvent(ModelCallbackEvent event) {
        this.callbackEvent = event;
    }

    public void peek(boolean isVisible) {
        for (Block b : map.getBlocks()) {
            if(isVisible) {
                b.reveal();
            } else {
                b.conceal();
            }
        }
        callbackEvent.onMapChanged(map);
    }

    public void changeRevealState(Coordinate coordinate, boolean isVisible) {
        map.setBlock(coordinate, isVisible);
        callbackEvent.onMapChanged(map);
    }

    public void changeRobotCoordinate(Coordinate coordinate) {
        map.setRobot(coordinate);
        callbackEvent.onMapChanged(map);
    }

    public void changeGoalCoordinate(Coordinate coordinate) {
        map.setGoal(coordinate);
        callbackEvent.onMapChanged(map);
    }

    public void setBlock(Coordinate coordinate, BLOCKTYPE blocktype) {
        map.setBlock(coordinate, blocktype);
        callbackEvent.onMapChanged(map);
    }

    public void setBlock(Coordinate coordinate, boolean isVisible) {
        map.setBlock(coordinate, isVisible);
        callbackEvent.onMapChanged(map);
    }

    public void setBlock(Coordinate coordinate, BLOCKTYPE blocktype, boolean isVisible) {
        map.setBlock(coordinate, blocktype, isVisible);
        callbackEvent.onMapChanged(map);
    }


}
