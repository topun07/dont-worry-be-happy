package com.techelevator;

import com.techelevator.util.BasicConsole;
import com.techelevator.util.SystemInOutConsole;

public class Application {

    public static void main(String[] args) {
        BasicConsole systemInOutConsole = new SystemInOutConsole();
        WordSearchController controller = new WordSearchController(systemInOutConsole);
        controller.run();
    }
}
