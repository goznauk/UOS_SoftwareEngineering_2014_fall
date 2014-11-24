package DRSOS.controller;

import DRSOS.data.BLOCKTYPE;
import DRSOS.data.Coordinate;
import DRSOS.data.Map;
import DRSOS.data.SENSOR;
import DRSOS.model.*;
import DRSOS.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        ((EntryView)view).setMapIdList(((EntryModel)model).getMapIdList());
        init();
    }

    private void init() {
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == "startButton") {
                    onStartButtonClicked();
                }


            }
        });

        model.setCallbackEvent(new ModelCallbackEvent() {
            @Override
            public void onMapChanged(Map map) {
                view.updateMap(map);
            }
        });
    }

    public void changeContext(BaseView view, BaseModel model) {
        this.view = view;
        this.model = model;
        init();
    }

    private void onMapListClicked(int id) {
        ((EntryModel)model).setMapById(id);
    }

    private void onManageMapButtonClicked(Map map) {
        changeContext(new MapMakerView(), new MapMakerModel(map));
    }

    private void onMapViewClicked(Coordinate coordinate) {

    }

    private void onSimulateButtonClicked(boolean hasADDON) {
        changeContext(new SimulatorView(), new SimulatorModel());
        changeContext(new ADDONSimulatorView(), new ADDONSimulatorModel());
    }

    private void onStartButtonClicked() {
        // SIM start?
    }

    private void onResetButtonClicked() {

    }

    private void onReturnButtonClicked() {
        changeContext(new EntryView(), new EntryModel());
        ((EntryView)view).setMapIdList(((EntryModel)model).getMapIdList());
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
