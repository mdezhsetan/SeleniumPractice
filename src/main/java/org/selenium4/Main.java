package org.selenium4;


public class Main {

    public static void main(String[] args) throws InterruptedException {

MouseActions mouseActions = new MouseActions();

mouseActions.setUp();
mouseActions.mouseActions();
mouseActions.tearDown();
    }
}