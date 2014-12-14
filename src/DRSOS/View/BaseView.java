package DRSOS.view;

import DRSOS.entity.Map;
import DRSOS.program.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class BaseView extends JPanel {
    protected MapViewPanel mapViewPanel = new MapViewPanel();
    protected JPanel rightPanel, bottomPanel;
    protected ViewCallbackEvent callbackEvent;

    public BaseView() {
        mapViewPanel = new MapViewPanel();
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    public void init() {
        try {
            GridBagLayout gbl = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();

            setLayout(gbl);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.ipadx = 0;
            gbc.ipadx = 0;

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.gridheight = 2;
            gbc.insets = new Insets(10, 10, 10, 5);
            gbl.setConstraints(mapViewPanel, gbc);
            add(mapViewPanel);

            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            gbc.insets = new Insets(10, 5, 10, 10);
            gbl.setConstraints(rightPanel, gbc);
            add(rightPanel);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 3;
            gbc.gridheight = 1;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbl.setConstraints(bottomPanel, gbc);
            add(bottomPanel);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = Application.getApplication().getFrame();
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        Dimension scrDim = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (scrDim.width - frame.getWidth()) / 2;
        int yPos = (scrDim.height - frame.getHeight()) / 2;
        frame.setLocation(xPos, yPos);
    }

    public void addActionListener(ActionListener actionListener) {

    }

    public void updateMap(Map map) {
        mapViewPanel.init(map);
        Application.getApplication().getFrame().setVisible(true);
    }

    public void setCallbackEvent(ViewCallbackEvent callbackEvent) {
        this.callbackEvent = callbackEvent;
    }
}
