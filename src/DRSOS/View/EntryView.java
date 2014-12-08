package DRSOS.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class EntryView extends BaseView {
    public EntryView() {
        setLayout(new GridLayout(2, 0));
        add(new JLabel("Select the Option"));
        JButton saveButton = new JButton("Save");
        add(saveButton);
        // titlePanel
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Select the Option"));
        add(titlePanel);
    }

    public void setMapIdList(ArrayList<Integer> list) {

    }
}
