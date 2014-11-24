package DRSOS.view;

import javax.swing.*;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapViewPanel extends JPanel {
    private MapViewCallbackEvent callbackEvent;

    public void setCallbackEvent(MapViewCallbackEvent callbackEvent) {
        this.callbackEvent = callbackEvent;
    }

    public void enableClick(boolean clickable) {
        // TODO: Set all buttons clickable
    }

    // TODO: Grid Layout for MapView

    // when Button Clicked -> callbackEvent.onButtonClicked(Coordinate coordinate);
}
