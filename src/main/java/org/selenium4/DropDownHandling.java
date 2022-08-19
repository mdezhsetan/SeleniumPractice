package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownHandling {

    public static WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.get("https://trytestingthis.netlify.app/");
    }

    public void tearDown() {
        driver.quit();
    }

    public void dropDownHandling() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("option"));

        Select select = new Select(dropdown);

        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByValue("option 2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        select.selectByVisibleText("Option 3");
        Thread.sleep(2000);

        List<WebElement> allAvailableOptions = select.getOptions();

        //OR

        //List <WebElement> allAvailableOptions = driver.findElement(By.id("option"));

        for (WebElement eachOption : allAvailableOptions) {
            System.out.println(eachOption);
            System.out.println(eachOption.getText());
        }

        //Deselecting
        WebElement anotherdropdown = driver.findElement(By.id("owc"));
        Select select2 = new Select(anotherdropdown);

        select2.selectByIndex(1);
        Thread.sleep(1000);
        select2.selectByIndex(2);
        Thread.sleep(1000);
        select2.selectByIndex(3);
        Thread.sleep(1000);
        select2.deselectByIndex(1);
        Thread.sleep(2000);
        select2.deselectByValue("option 2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        select2.deselectByVisibleText("Option 3");
        Thread.sleep(2000);
    }

}
