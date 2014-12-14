package DRSOS.view;

import DRSOS.entity.CONTEXT;
import DRSOS.entity.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SimulatorView extends BaseView implements ActionListener {

    JToggleButton btn_setStart, btn_setGoal;

    JButton btn_return, btn_start, btn_exit;

    public SimulatorView() {
        btn_setStart = new JToggleButton("set start");
        btn_setStart.addActionListener(this);
        btn_setGoal = new JToggleButton("set goal");
        btn_setGoal.addActionListener(this);

        btn_setStart.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_setGoal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        rightPanel.add(btn_setStart);
        rightPanel.add(btn_setGoal);


        btn_start = new JButton("Start");
        btn_start.addActionListener(this);
        btn_return = new JButton("Return");
        btn_return.addActionListener(this);
        btn_exit = new JButton("Exit");
        btn_exit.addActionListener(this);

        bottomPanel.add(btn_start);
        bottomPanel.add(btn_return);
        bottomPanel.add(btn_exit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_setStart) {
            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onRobotChanged(coordinate);
                    }
                });
            } else {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        // DO NOTHING
                    }
                });
            }
        } else if (e.getSource() == btn_setGoal) {
            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onGoalChanged(coordinate);
                    }
                });
            } else {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        // DO NOTHING
                    }
                });
            }
        } else if (e.getSource() == btn_start) {
            callbackEvent.onContextChangeRequested(CONTEXT.SIMULATOR);
        } else if (e.getSource() == btn_return) {
            callbackEvent.onContextChangeRequested(CONTEXT.ENTRY);
        } else if (e.getSource() == btn_exit) {
            System.exit(0);
        }
    }
}
