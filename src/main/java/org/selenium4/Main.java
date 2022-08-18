package org.selenium4;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Alerts alerts = new Alerts();
        alerts.setUp();
        alerts.jsAlert();
        Thread.sleep(2000);
        alerts.jsConfirm();
        Thread.sleep((2000));
        alerts.jsPrompt();
        Thread.sleep(2000);
        alerts.tearDown();
    }
}