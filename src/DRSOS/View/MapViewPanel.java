package DRSOS.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapViewPanel extends JPanel implements ActionListener {
    private JButton[] jButtons = new JButton[400];

    private final int BUTTON_LENGTH = 400;

    public MapViewPanel() {
        initComponent();
    }

    private void initComponent() {
        setLayout(new GridLayout(20, 0, 0, 0));
        setPreferredSize(new Dimension(15*20, 15*20));

        for ( int i = 0; i < BUTTON_LENGTH; i++ ) {
            jButtons[i] = new JButton();
            jButtons[i].setBackground(Color.white);
            jButtons[i].addActionListener(this);
            jButtons[i].setSize(15, 15);
            jButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(jButtons[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for ( int i = 0; i < BUTTON_LENGTH; i++ ) {
            if ( e.getSource() == jButtons[i] ) {
                if ( jButtons[i].getBackground().equals(Color.black)) {
                    jButtons[i].setBackground(Color.white);
                }
                else {
                    jButtons[i].setBackground(Color.black);
                }
            }
        }
    }



    private MapViewCallbackEvent callbackEvent;

    public void setCallbackEvent(MapViewCallbackEvent callbackEvent) {
        this.callbackEvent = callbackEvent;
    }

    public void enableClick(boolean clickable) {
        // TODO: Set all buttons clickable
    }

    // TODO: Grid Layout for MapView

    // when Button Clicked -> callbackEvent.onButtonClicked(Coordinate coordinate);
}
