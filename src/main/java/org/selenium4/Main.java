package org.selenium4;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BrowserActions ba = new BrowserActions();
        ba.setUp();
        // ba.changeUrl();
        ba.frameSelection();
        // ba.windowManagement();
        ba.takeScreenshot();
    }
}