package DRSOS.view;

import DRSOS.domain.CONTEXT;
import DRSOS.domain.Coordinate;
import DRSOS.domain.DIRECTION;
import DRSOS.domain.SENSOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class SimulatorView extends BaseView implements ActionListener {

    JToggleButton btn_setStart, btn_sHazard;
    JButton btn_sColorBlob, btn_sPosition;
    JLabel displayL1, displayL2;

    JButton btn_start, btn_return, btn_exit;

    boolean startSet = false, hazardSensorOn = false;

    KeyAdapter keyAdapter;

    private class DirectionKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            if(btn_setStart.isEnabled()) {
                return;
            }

            displayL1.setText("");
            displayL2.setText("");

            DIRECTION direction;

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                direction = DIRECTION.NORTH;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                direction = DIRECTION.EAST;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                direction = DIRECTION.SOUTH;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                direction = DIRECTION.WEST;
            } else {
                direction = null;
            }

            if(hazardSensorOn) {
                callbackEvent.onHazardSensorUsed(direction);
                btn_sHazard.setSelected(false);
                hazardSensorOn = false;
            } else {
                callbackEvent.onRobotMoveTry(direction);
            }
        }
    }

    public SimulatorView() {
        btn_setStart = new JToggleButton("set start");
        btn_setStart.addActionListener(this);
        btn_sColorBlob = new JButton("ColorBlob");
        btn_sColorBlob.addActionListener(this);
        btn_sHazard = new JToggleButton("Hazard");
        btn_sHazard.addActionListener(this);
        btn_sPosition = new JButton("Position");
        btn_sPosition.addActionListener(this);
        displayL1 = new JLabel("");
        displayL2 = new JLabel("");

        btn_setStart.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_sColorBlob.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_sHazard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_sPosition.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        displayL1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        displayL2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        rightPanel.add(btn_setStart);
        rightPanel.add(btn_sColorBlob);
        rightPanel.add(btn_sHazard);
        rightPanel.add(btn_sPosition);
        rightPanel.add(displayL1);
        rightPanel.add(displayL2);


        btn_start = new JButton("Start");
        btn_start.addActionListener(this);
        btn_return = new JButton("Return");
        btn_return.addActionListener(this);
        btn_exit = new JButton("Exit");
        btn_exit.addActionListener(this);

        bottomPanel.add(btn_start);
        bottomPanel.add(btn_return);
        bottomPanel.add(btn_exit);

        keyAdapter = new DirectionKeyAdapter();
        addKeyListener(keyAdapter);
        requestFocus();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        displayL1.setText("");
        displayL2.setText("");

        if (e.getSource() == btn_setStart) {
            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                startSet = true;
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

        } else if (e.getSource() == btn_sColorBlob) {
            if(btn_setStart.isEnabled()) {
                return;
            }
            displayL1.setText("Sensing");
            displayL2.setText("ColorBlob");
            callbackEvent.onColorBlobSensorUsed();
            requestFocus();

        } else if (e.getSource() == btn_sHazard) {
            if(btn_setStart.isEnabled()) {
                return;
            }
            displayL1.setText("Sensing");
            displayL2.setText("Hazard");

            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                hazardSensorOn = true;

                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onRobotChanged(coordinate);
                    }
                });
            } else {
                hazardSensorOn = false;

                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        // DO NOTHING
                    }
                });
            }
            requestFocus();

        } else if (e.getSource() == btn_sPosition) {
            if(btn_setStart.isEnabled()) {
                return;
            }
            displayL1.setText("Position");
            Coordinate coordinate = callbackEvent.onPositionSensorUsed();
            displayL1.setText("( " + coordinate.getX() + " , " + coordinate.getY() + " )");

            requestFocus();

        } else if (e.getSource() == btn_start) {
            if(startSet) {
                callbackEvent.onSimulationStarted();
                requestFocus();
                // keyEvent enable
                btn_setStart.setEnabled(false);
            }
        } else if (e.getSource() == btn_return) {
            callbackEvent.onContextChangeRequested(CONTEXT.ENTRY);
        } else if (e.getSource() == btn_exit) {
            System.exit(0);
        }
    }



}
