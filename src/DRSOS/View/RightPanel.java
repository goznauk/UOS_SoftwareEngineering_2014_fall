package DRSOS.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 12. 14..
 */
public class RightPanel extends JPanel implements ActionListener {
    private GridBagLayout gridBaglayout = new GridBagLayout();

    private JButton jButton1 = new JButton("Button1");
    private JButton jButton2 = new JButton("Button2");
    private JButton jButton3 = new JButton("Button3");
    private JButton jButton4 = new JButton("Button4");

    private JLabel jLabel = new JLabel("test");

    public RightPanel() {
        initComponent();
        initActionListener();
    }

    private void initActionListener() {
        // TODO Auto-generated method stub
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
    }

    private void initComponent() {

        this.setLayout(gridBaglayout);

        this.add(jButton1,
                new GridBagConstraints(0, 0, 1, 1, 1.0, 0.2,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(5, 5, 5, 5), 0, 0));

        this.add(jButton2,
                new GridBagConstraints(0, 1, 1, 1, 1.0, 0.2,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(15, 5, 5, 5), 0, 0));

        this.add(jButton3,
                new GridBagConstraints(0, 2, 1, 1, 1.0, 0.2,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(15, 5, 5, 5), 0, 0));

        this.add(jButton4,
                new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(15, 5, 5, 5), 0, 0));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if ( e.getSource().equals(jButton1) ) {

        }
        else if ( e.getSource().equals(jButton2) ) {

        }
        else if ( e.getSource().equals(jButton3) ) {

        }
        else if ( e.getSource().equals(jButton4) ) {

        }
        else {

        }
    }

}
