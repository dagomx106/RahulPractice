package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDomTest {

    WebDriver driver = new ChromeDriver();

    @Test
    void domTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("chrome://settings/appearance");

        WebElement el = driver.findElement(By.cssSelector("settings-ui")).getShadowRoot()
                .findElement(By.cssSelector("settings-main#main")).getShadowRoot()
                .findElement(By.cssSelector("settings-basic-page[role='main']")).getShadowRoot()
                .findElement(By.cssSelector("div[id='basicPage']"));

        System.out.println(el.getText());

        driver.quit();
    }

}
