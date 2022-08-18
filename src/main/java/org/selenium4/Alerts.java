package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {

    public static WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    public void tearDown() {
        driver.quit();
    }

    public void jsAlert() {
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
//        System.out.println(driver.getPageSource());
        if (driver.getPageSource().contains("You successfully clicked an alert"))
            System.out.println("Alert Method Worked Successfully\n\n\n");
    }

    public void jsConfirm() {
        driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
//        System.out.println(driver.getPageSource());
        if (driver.getPageSource().contains("You clicked: Cancel"))
            System.out.println("Confirm Method Worked Successfully\n\n");
    }

    public void jsPrompt() {
        driver.findElement(By.xpath("//*[text() = 'Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("ABCD");
        alert.accept();
//        System.out.println(driver.getPageSource());
        if (driver.getPageSource().contains("You successfully clicked an alert"))
            System.out.println("Prompt Method Worked Successfully");
    }
}
