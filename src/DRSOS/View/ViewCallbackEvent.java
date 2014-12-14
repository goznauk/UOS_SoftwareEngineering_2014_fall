package DRSOS.view;

import DRSOS.entity.BLOCKTYPE;
import DRSOS.entity.CONTEXT;
import DRSOS.entity.Coordinate;
import DRSOS.entity.SENSOR;

import java.awt.event.KeyEvent;

/**
 * Created by goznauk on 2014. 12. 15..
 */
public interface ViewCallbackEvent {
    public void onPeekButtonClicked(boolean peek);
    public void onBlockChanged(Coordinate coordinate, BLOCKTYPE blocktype);
    public void onRevealStateChanged(Coordinate coordinate, boolean isVisible);
    public void onSaveButtonClicked();
    public void onDeleteButtonClicked(String name);
    public void onRobotChanged(Coordinate coordinate);
    public void onGoalChanged(Coordinate coordinate);
    public void onSensorUsed(Coordinate coordinate, SENSOR sensor);
    public void onKeyboardInput(KeyEvent e);
    public void onContextChangeRequested(CONTEXT context);
}
