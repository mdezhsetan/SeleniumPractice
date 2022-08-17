package org.selenium4;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Locators locators = new Locators();

        locators.setUp();

        //locators.findByLocators();
        locators.findRelative();
        //locators.tearDown();
    }
}