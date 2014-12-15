package DRSOS.controller;

import DRSOS.domain.*;
import DRSOS.model.*;
import DRSOS.program.Application;
import DRSOS.dao.FileManager;
import DRSOS.view.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Controller {
    private BaseModel model;
    private IRobot robot;
    private ADDON addon;
    private BaseView view;
    private ActionListener actionListener;

    public Controller() {
        view = new EntryView();
        model = new EntryModel();
        ((EntryView)view).setMapNameList(((EntryModel) model).getMapNameList());
        ((EntryView)view).setMapListCallbackEvent(new MapListCallbackEvent() {
            @Override
            public void onMapClicked(String name) {
                ((EntryModel) model).setMapByName(name);
            }
        });
        init();
    }

    private void init() {
        Application.getApplication().getFrame().getContentPane().removeAll();

        model.setCallbackEvent(new ModelCallbackEvent() {
            @Override
            public void onMapChanged(Map map) {
                view.updateMap(map);
            }
        });
        view.init();
        view.setCallbackEvent(new ViewCallbackEvent() {

            @Override
            public void onPeekButtonClicked(boolean isVisible) {
                model.peek(isVisible);
            }

            @Override
            public void onBlockChanged(Coordinate coordinate, BLOCKTYPE blocktype) {
                model.setBlock(coordinate, blocktype);
            }

            @Override
            public void onRevealStateChanged(Coordinate coordinate, boolean isVisible) {
                model.changeRevealState(coordinate, isVisible);
            }

            @Override
            public void onSaveButtonClicked() {
                FileManager.saveMapAsCsv(model.getMap());
            }

            @Override
            public void onDeleteButtonClicked(String name) {
                FileManager.deleteMapByName(name);
                changeContext(CONTEXT.ENTRY);
            }


            @Override
            public void onRobotChanged(Coordinate coordinate) {
                model.changeRobotCoordinate(coordinate);
            }

            @Override
            public void onSimulationStarted() {
                model.setBlock(model.getMap().getRobot(), true);
            }

            @Override
            public void onRobotMoveTry() {
                addon.init();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        addon.moveRobot(model.getMap().getRobot(), model.getMap().getGoal());
                    }
                };
                Thread thread = new Thread(r);
                thread.start();
            }

            @Override
            public void onRobotMoveTry(DIRECTION d) {
                robot.move(d);
            }

            @Override
            public void onGoalChanged(Coordinate coordinate) {
                model.changeGoalCoordinate(coordinate);
            }

            @Override
            public void onColorBlobSensorUsed() {
                    robot.sensorColorBlob();
            }

            @Override
            public void onHazardSensorUsed(DIRECTION direction) {
                System.out.println(robot.sensorHazard(direction));

            }

            @Override
            public Coordinate onPositionSensorUsed() {
                return robot.sensorPosition();
            }


            @Override
            public void onContextChangeRequested(CONTEXT context) {
                changeContext(context);
            }
        });
    }

    public void changeContext(CONTEXT context) {
        if(context == CONTEXT.ENTRY) {
            view = new EntryView();
            model = new EntryModel();
            ((EntryView)view).setMapNameList(((EntryModel)model).getMapNameList());
            ((EntryView)view).setMapListCallbackEvent(new MapListCallbackEvent() {
                @Override
                public void onMapClicked(String name) {
                    ((EntryModel)model).setMapByName(name);
                }
            });
        } else if (context == CONTEXT.MAPMAKER) {
            view = new MapMakerView();
            model = new MapMakerModel();
            view.updateMap(model.getMap());
        } else if (context == CONTEXT.SIMULATOR) {
            System.out.println(model.getMap());
            view = new SimulatorView();
            model = new SimulatorModel(model.getMap());
            robot = (SimulatorModel)model;
            view.updateMap(model.getMap());
        } else if (context == CONTEXT.ADDONSIMULATOR) {
            System.out.println(model.getMap());
            view = new ADDONSimulatorView();
            model = new SimulatorModel(model.getMap());
            robot = (SimulatorModel)model;
            addon = new ADDON(robot);
            view.updateMap(model.getMap());
        }
        init();
    }


    private void onMapViewClicked(Coordinate coordinate) {

    }


    private void onStartButtonClicked() {
        // SIM start?
    }

    private void onResetButtonClicked() {

    }


    private void onExitButtonClicked() {

    }

    private void onSetButtonClicked(BLOCKTYPE blocktype) {

    }

    private void onSensorButtonClicked(SENSOR sensor) {

    }

    private void onSaveButtonClicked() {

    }
}
