package org.selenium4;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Locators locators = new Locators();
        Waits wt = new Waits();
        wt.setUp();
        wt.fluentWaitMethod();
        //locators.findByLocators();
        //locators.findRelative();
        //locators.tearDown();
    }
}