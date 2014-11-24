package DRSOS;


import DRSOS.program.Application;

public class Main {
    public static void main(String[] args) {
        Application application = Application.getApplication();
        application.run();
    }
}
