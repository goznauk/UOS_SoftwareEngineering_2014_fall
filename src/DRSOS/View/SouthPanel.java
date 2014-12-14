package DRSOS.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 12. 14..
 */
public class SouthPanel extends JPanel implements ActionListener{
    private GridBagLayout gridBaglayout = new GridBagLayout();

    private JButton jButton1 = new JButton("Button1");
    private JButton jButton2 = new JButton("Button2");
    private JButton jButton3 = new JButton("Button3");
    private JPanel jPanel = new JPanel();

    public SouthPanel() {
        initComponent();
        initActionListener();
    }


    private void initActionListener() {
        // TODO Auto-generated method stub
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
    }


    private void initComponent() {
        this.setLayout(gridBaglayout);
        JPanel drawPanel = new JPanel() {
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                int width = 10;
                g2d.setStroke(new BasicStroke(width));
                g2d.setColor(Color.black);
                g2d.drawLine(0, 0, this.getWidth(), 0);
            }
        };

        this.add(drawPanel,
                new GridBagConstraints(0, 0, 7, 1, 7.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(5, 5, 5, 5), 0, 0));

        this.add(jPanel,
                new GridBagConstraints(0, 1, 4, 1, 4.0, 1.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(5, 5, 5, 5), 0, 0));

        this.add(jButton1,
                new GridBagConstraints(4, 1, 1, 1, 1.0, 1.0,
                        GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                        new Insets(5, 5, 5, 5), 0, 0));

        this.add(jButton2,
                new GridBagConstraints(5, 1, 1, 1, 1.0, 1.0,
                        GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                        new Insets(5, 5, 5, 5), 0, 0));

        this.add(jButton3,
                new GridBagConstraints(6, 1, 1, 1, 1.0, 1.0,
                        GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                        new Insets(5, 5, 5, 5), 0, 0));

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
        else {

        }
    }
}
