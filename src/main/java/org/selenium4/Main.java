package org.selenium4;


public class Main {

    public static void main(String[] args) {
        BrowserActions ba = new BrowserActions();
        ba.setUp();
        ba.changeUrl();
    }
}