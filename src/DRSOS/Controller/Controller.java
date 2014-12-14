package DRSOS.controller;

import DRSOS.entity.*;
import DRSOS.model.*;
import DRSOS.program.Application;
import DRSOS.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Controller {
    private BaseModel model;
    private BaseView view;
    private ActionListener actionListener;

    public Controller() {
        view = new EntryView();
        model = new EntryModel();
        ((EntryView)view).setMapNameList(((EntryModel)model).getMapNameList());
        ((EntryView)view).setMapListCallbackEvent(new MapListCallbackEvent() {
            @Override
            public void onMapClicked(String name) {
                ((EntryModel)model).setMapByName(name);
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

            }

            @Override
            public void onRevealStateChanged(Coordinate coordinate, boolean isVisible) {
                model.changeRevealState(coordinate, isVisible);
            }

            @Override
            public void onRobotChanged(Coordinate coordinate) {
                model.changeRobotCoordinate(coordinate);
            }

            @Override
            public void onGoalChanged(Coordinate coordinate) {
                model.changeGoalCoordinate(coordinate);
            }

            @Override
            public void onSensorUsed(Coordinate coordinate, SENSOR sensor) {

            }

            @Override
            public void onKeyboardInput(KeyEvent e) {

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
        } else if (context == CONTEXT.SIMULATOR) {
            System.out.println(model.getMap());
            view = new SimulatorView();
            model = new SimulatorModel(model.getMap());
            view.updateMap(model.getMap());
        } else if (context == CONTEXT.ADDONSIMULATOR) {
            System.out.println(model.getMap());
            view = new ADDONSimulatorView();
            model = new ADDONSimulatorModel(model.getMap());
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
