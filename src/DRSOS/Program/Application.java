package DRSOS.program;

import DRSOS.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Application {
    private static Application application = new Application();
    private JFrame frame;
    private Controller controller;

    private Application() {
        // init jframe
        frame = new JFrame("DRSOS");
        frame.setLayout(new GridLayout(1,0));
        frame.getContentPane().setBounds(20, 20, 400, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Application getApplication() {
        if(application == null) {
            // unexpected call
            application = new Application();
        }
        return application;
    }

    public void run() {
        controller = new Controller();
    }

    public JFrame getFrame() {
        return frame;
    }
}
