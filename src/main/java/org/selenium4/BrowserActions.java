package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserActions {
    public static WebDriver driver;
    public String firstWindow;
    public String secondWindow;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void loadingPage() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        firstWindow = driver.getWindowHandle();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    public void changeUrl() {
        driver.navigate().to("https://automationstepbystep.com");
        secondWindow = driver.getWindowHandle();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().refresh();
    }

    public void changeWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(secondWindow);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void tearDown() {
        driver.quit();
    }
}
