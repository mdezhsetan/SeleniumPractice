package org.selenium4;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        DropDownHandling ddh = new DropDownHandling();
        ddh.setUp();
        ddh.dropDownHandling();
        ddh.tearDown();
    }
}