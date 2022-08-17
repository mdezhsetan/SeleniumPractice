package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Locators {
    public static WebDriver driver;
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://ultimateqa.com/automation/");
    }
    public void tearDown() {
        driver.quit();
    }

    public void findByLocators() throws InterruptedException {
        WebElement emailBox = driver.findElement(By.id("subscribe-field-blog_subscription-2"));
        emailBox.sendKeys("ABCD", Keys.ENTER);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement link = driver.findElement(By.linkText("Interactions with simple elements"));
        link.click();

        List<WebElement> option = driver.findElements(By.cssSelector("select"));

        for (WebElement element : option){
            System.out.println(element.getText());
        }
    }

}
