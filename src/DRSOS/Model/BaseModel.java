package DRSOS.model;


import DRSOS.data.BLOCKTYPE;
import DRSOS.data.Coordinate;
import DRSOS.data.Map;

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
