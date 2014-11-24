package DRSOS.program;

import DRSOS.controller.Controller;

import javax.swing.*;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Application {
    private static Application application = new Application();
    private JFrame frame;
    private Controller controller;

    private Application() {
        frame = new JFrame();
        // init jframe

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
