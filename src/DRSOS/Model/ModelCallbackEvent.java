package DRSOS.model;

import DRSOS.data.Coordinate;
import DRSOS.data.Map;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public interface ModelCallbackEvent {
    public void onMapChanged(Map map);
}
