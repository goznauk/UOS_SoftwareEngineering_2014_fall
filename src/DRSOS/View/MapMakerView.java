package DRSOS.view;

import DRSOS.domain.BLOCKTYPE;
import DRSOS.domain.CONTEXT;
import DRSOS.domain.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapMakerView extends BaseView implements ActionListener {

    JToggleButton btn_setColorBlob, btn_setHazard;

    JButton btn_return, btn_save, btn_exit;

    public MapMakerView() {
        btn_setColorBlob = new JToggleButton("set ColorBlob");
        btn_setColorBlob.addActionListener(this);
        btn_setHazard = new JToggleButton("set Hazard");
        btn_setHazard.addActionListener(this);

        btn_setColorBlob.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_setHazard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        rightPanel.add(btn_setColorBlob);
        rightPanel.add(btn_setHazard);


        btn_save = new JButton("Save");
        btn_save.addActionListener(this);
        btn_return = new JButton("Return");
        btn_return.addActionListener(this);
        btn_exit = new JButton("Exit");
        btn_exit.addActionListener(this);

        bottomPanel.add(btn_save);
        bottomPanel.add(btn_return);
        bottomPanel.add(btn_exit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_setColorBlob) {
            if(btn_setHazard.isSelected()) {
                btn_setHazard.setSelected(false);
            }

            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onBlockChanged(coordinate, BLOCKTYPE.COLORBLOB);
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
        } else if (e.getSource() == btn_setHazard) {
            if(btn_setColorBlob.isSelected()) {
                btn_setColorBlob.setSelected(false);
            }

            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onBlockChanged(coordinate, BLOCKTYPE.HAZARD);
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
        } else if (e.getSource() == btn_save) {
            callbackEvent.onSaveButtonClicked();
            callbackEvent.onContextChangeRequested(CONTEXT.ENTRY);
        } else if (e.getSource() == btn_return) {
            callbackEvent.onContextChangeRequested(CONTEXT.ENTRY);
        } else if (e.getSource() == btn_exit) {
            System.exit(0);
        }
    }
}
