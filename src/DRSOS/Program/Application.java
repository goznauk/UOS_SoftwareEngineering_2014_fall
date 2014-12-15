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
        frame = new JFrame();
        frame.setTitle("DRSOS");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static Application getApplication() {
        if(application == null) {
            // unexpected call
            application = new Application();
        }
        return application;
    }

    public void refresh() {
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void run() {
        controller = new Controller();
    }

    public JFrame getFrame() {
        return frame;
    }

    public Controller getController() {
        return controller;
    }
}
