package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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


    public void frameSelection() {
        driver.navigate().to("https://www.play1.automationcamp.ir/");
        driver.findElement(By.cssSelector("[href='frames.html']")).click();
    }

    public void windowManagement() throws InterruptedException {
        System.out.println(driver.manage().window().getSize().height);
        System.out.println(driver.manage().window().getSize().width);

        Dimension size = driver.manage().window().getSize();
        System.out.println("Size= " + size);

        driver.manage().window().setSize(new Dimension(110, 140));

        System.out.println(driver.manage().window().getPosition().x);
        System.out.println(driver.manage().window().getPosition().y);

        Point position = driver.manage().window().getPosition();
        System.out.println("Position = " + position);

        driver.manage().window().setPosition(new Point(250, 250));
        driver.manage().window().setSize(new Dimension(800, 800));
        Thread.sleep(1000);

        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.manage().window().minimize();
    }

    public void takeScreenshot() throws IOException {

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./testScreenshots/ss.png"));
/*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.id("click_me_2")));
*/
        driver.switchTo().frame("frame1").switchTo().frame("frame2");
        WebElement webElement = driver.findElement(By.cssSelector("#click_me_2"));
        File srcFile2 = webElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("./testScreenshots/ss2.png"));
    }
}
