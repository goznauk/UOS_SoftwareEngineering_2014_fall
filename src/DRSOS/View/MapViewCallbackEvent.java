package DRSOS.view;

import DRSOS.entity.Coordinate;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public interface MapViewCallbackEvent {
    public void onButtonClicked(Coordinate coordinate);
}
