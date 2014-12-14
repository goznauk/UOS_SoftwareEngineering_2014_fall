package DRSOS.view;

import DRSOS.entity.CONTEXT;
import DRSOS.entity.Coordinate;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class EntryView extends BaseView implements ActionListener {
    private MapListCallbackEvent mapListCallbackEvent;
    JScrollPane mapListScrollPane;
    JPanel mapListPanel;
    ArrayList<JToggleButton> mapListButtons;

    JPanel buttonPanel;
    JButton btn_simulate, btn_make;
    JToggleButton btn_peek, btn_reveal;

    JCheckBox chk_withAddon;
    JButton btn_start, btn_exit;

    public EntryView() {
        rightPanel.setLayout(new BorderLayout());

        mapListPanel = new JPanel();
        mapListPanel.setLayout(new BoxLayout(mapListPanel, BoxLayout.Y_AXIS));
        //mapListPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        btn_make = new JButton("+ make");
        btn_make.addActionListener(this);
        btn_make.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        mapListPanel.add(btn_make);

        mapListScrollPane = new JScrollPane(mapListPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mapListScrollPane.setPreferredSize(new Dimension(mapListScrollPane.getHeight(), mapListScrollPane.getWidth()));


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

        btn_simulate = new JButton("simulate");
        btn_peek = new JToggleButton("peek");
        btn_peek.addActionListener(this);
        btn_reveal = new JToggleButton("reveal");
        btn_reveal.addActionListener(this);

        btn_simulate.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn_peek.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn_reveal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        buttonPanel.add(btn_simulate);
        buttonPanel.add(btn_peek);
        buttonPanel.add(btn_reveal);


        rightPanel.add(mapListScrollPane);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);


        chk_withAddon = new JCheckBox("use ADDON");
        btn_start = new JButton("Start");
        btn_start.addActionListener(this);
        btn_exit = new JButton("Exit");
        btn_exit.addActionListener(this);

        bottomPanel.add(chk_withAddon);
        bottomPanel.add(btn_start);
        bottomPanel.add(btn_exit);

    }

    public void setMapNameList(ArrayList<String> mapNameList) {
        mapListButtons = new ArrayList<JToggleButton>();

        for(String s : mapNameList) {
            mapListButtons.add(new JToggleButton(s));
        }



        for(JToggleButton button : mapListButtons) {
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            button.addActionListener(this);
            button.setBorder(new LineBorder(Color.lightGray, 1));
            button.setBackground(Color.white);
            button.setOpaque(true);
            mapListPanel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_start) {
            if(chk_withAddon.isSelected()) {
                callbackEvent.onContextChangeRequested(CONTEXT.ADDONSIMULATOR);
            } else {
                callbackEvent.onContextChangeRequested(CONTEXT.SIMULATOR);
            }
        } else if (e.getSource() == btn_exit) {
            System.exit(0);
        } else if (e.getSource() == btn_peek) {
            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                callbackEvent.onPeekButtonClicked(true);
            } else {
                callbackEvent.onPeekButtonClicked(false);
            }
        } else if (e.getSource() == btn_reveal) {
            JToggleButton jToggleButton = (JToggleButton)e.getSource();
            if (jToggleButton.isSelected()) {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        callbackEvent.onRevealStateChanged(coordinate, mapViewPanel.isRevealed(coordinate));
                    }
                });
            } else {
                mapViewPanel.setCallbackEvent(new MapViewCallbackEvent() {
                    @Override
                    public void onButtonClicked(Coordinate coordinate) {
                        // DO NOTIHNG
                    }
                });
            }
        } else if (mapListButtons.contains(e.getSource())) {
            for (JToggleButton btn : mapListButtons) {
                btn.setSelected(false);
                btn.setBackground(Color.white);
            }
            ((JToggleButton)e.getSource()).setSelected(true);
            ((JToggleButton)e.getSource()).setBackground(Color.gray);
            mapListCallbackEvent.onMapClicked(((JToggleButton)e.getSource()).getText());
        }
    }

    public void setMapListCallbackEvent(MapListCallbackEvent mapListCallbackEvent) {
        this.mapListCallbackEvent = mapListCallbackEvent;
    }
}
