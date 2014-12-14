package DRSOS.view;

import DRSOS.entity.BLOCKTYPE;
import DRSOS.entity.Coordinate;
import DRSOS.entity.Map;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapViewPanel extends JPanel implements ActionListener {

    private Map map;

    private JButton[] buttons;

    public MapViewPanel() {
        init(new Map());
    }

    public void init(Map map) {
        removeAll();
        buttons = new JButton[400];
        setLayout(new GridLayout(20, 0, 0, 0));
        setPreferredSize(new Dimension(15*20, 15*20));

        for ( int i = 0; i < map.getBlocks().length; i++ ) {
            buttons[i] = new JButton();
            buttons[i].setBorder(new LineBorder(Color.lightGray, 1));
            if(!map.getBlocks()[i].isVisible()) {
                buttons[i].setBackground(Color.gray);
            } else if (map.getBlocks()[i].getBlocktype() == BLOCKTYPE.DEFAULT) {
                buttons[i].setBackground(Color.WHITE);
            } else if (map.getBlocks()[i].getBlocktype() == BLOCKTYPE.HAZARD) {
                buttons[i].setBackground(Color.red);
            } else if (map.getBlocks()[i].getBlocktype() == BLOCKTYPE.COLORBLOB) {
                buttons[i].setBackground(Color.yellow);
            }

            if(map.getGoal() != null && map.getGoal().toID() == i) {
                buttons[i].setText("X");
            } else if(map.getRobot() != null && map.getRobot().toID() == i) {
                buttons[i].setText("O");
            }
            buttons[i].setContentAreaFilled(false);
            buttons[i].setOpaque(true);
            buttons[i].addActionListener(this);
            buttons[i].setSize(15, 15);


            buttons[i].setUI(new MetalButtonUI() {
                @Override
                protected Color getSelectColor() {
                    return super.getSelectColor();
                }
            });
            this.add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // TODO Auto-generated method stub
        for ( int i = 0; i < buttons.length; i++ ) {
            if ( source == buttons[i] ) {
                System.out.println("clicked" + i);
                if (callbackEvent != null) {
                    callbackEvent.onButtonClicked(Coordinate.getCoordinateFromID(i));
                }
            }
        }
    }

    private MapViewCallbackEvent callbackEvent;

    public void setCallbackEvent(MapViewCallbackEvent callbackEvent) {
        this.callbackEvent = callbackEvent;
    }

    public boolean isRevealed(Coordinate coordinate) {
        return buttons[coordinate.toID()].getBackground() == Color.gray;
    }
}
