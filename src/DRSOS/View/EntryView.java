package DRSOS.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class EntryView extends BaseView {

    JButton btn_simulate, btn_make;

    JCheckBox chk_withAddon;
    JButton btn_start, btn_exit;

    public EntryView() {
        btn_simulate = new JButton("simulate");
        btn_make = new JButton("make");

        btn_simulate.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        btn_make.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        rightPanel.add(btn_simulate);
        rightPanel.add(btn_make);


        chk_withAddon = new JCheckBox("use ADDON");
        btn_start = new JButton("Start");
        btn_exit = new JButton("Exit");

        bottomPanel.add(chk_withAddon);
        bottomPanel.add(btn_start);
        bottomPanel.add(btn_exit);

    }

    public void setMapIdList(ArrayList<Integer> list) {

    }
}
