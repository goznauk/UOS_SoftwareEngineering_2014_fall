package DRSOS.view;

import DRSOS.data.Coordinate;
import DRSOS.data.Map;
import DRSOS.program.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class BaseView extends JPanel {
    private MapViewPanel mapViewPanel;

    public void init() {
        JFrame frame = Application.getApplication().getFrame();
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void addActionListener(ActionListener actionListener) {

    }

    public void updateMap(Map map) {

    }

}
