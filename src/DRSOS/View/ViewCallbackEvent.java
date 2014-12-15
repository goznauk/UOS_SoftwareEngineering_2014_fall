package DRSOS.view;

import DRSOS.domain.*;

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
    public void onSimulationStarted();
    public void onRobotMoveTry();
    public void onRobotMoveTry(DIRECTION d);
    public void onGoalChanged(Coordinate coordinate);
    public void onColorBlobSensorUsed();
    public void onHazardSensorUsed(DIRECTION direction);
    public Coordinate onPositionSensorUsed();
    public void onContextChangeRequested(CONTEXT context);
}
