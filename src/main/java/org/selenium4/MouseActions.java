package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseActions {
    public static WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
    }

    public void tearDown() {
        driver.quit();
    }

    public void mouseActions() throws InterruptedException {
        WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
        WebElement boxD = driver.findElement(By.xpath("//li[text()='D']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(boxA);
        actions.clickAndHold();
        actions.moveToElement(boxD);
        actions.release();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Right Click
        actions.contextClick(boxD);

        actions.doubleClick(boxD);

        actions.build().perform();

        Thread.sleep(3000);

        driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
        WebElement element1 = driver.findElement(By.id("draggable"));
        WebElement element2 = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(element1, element2);
        actions.build().perform();

        Thread.sleep(2000);
    }

}
