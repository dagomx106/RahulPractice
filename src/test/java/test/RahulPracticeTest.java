package test;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RahulPracticeTest extends Base {


    @Test(priority = 1)
    void firstSectionTest(){
        System.out.println(driver.getTitle());
        System.out.println("__________________");
        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Radio Button Example']")).getText());

        driver.findElement(By.xpath("//input[@value='radio1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());

        if(driver.findElement(By.xpath("//input[@value='radio1']")).getDomProperty("checked").equals("true")){
            System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).getDomProperty("value"));
        }

        System.out.println("__________________");
        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Suggession Class Example']")).getText());

        driver.findElement(By.id("autocomplete")).sendKeys("ico");
        List<WebElement> countries = driver.findElements(By.className("ui-menu-item"));
        String countryvalue = null;
        for (WebElement country :countries){
          if (country.getText().equals("Mexico")){
              System.out.println(country.getText());
              countryvalue = country.getText();
              country.click();
          }
        }
        Assert.assertEquals(countryvalue,"Mexico");
        System.out.println("__________________");
        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Dropdown Example']")).getText());

        Select drop = new Select(driver.findElement(By.id("dropdown-class-example")));
        drop.selectByIndex(2);
        String selvalue =null;
        for(WebElement sel :drop.getAllSelectedOptions()) {
            System.out.println(sel.getText());
            selvalue = sel.getText();
        }
        Assert.assertEquals(selvalue,"Option2");
        System.out.println("__________________");
        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Checkbox Example']")).getText());


        driver.findElement(By.id("checkBoxOption3")).click();
        List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));
        String ckvalue=null;
        for(WebElement chk : checks){
        if(chk.isSelected()){
            System.out.println(chk.getAttribute("value"));
            ckvalue = chk.getAttribute("value");
        }}
        Assert.assertEquals(ckvalue,"option3");
        System.out.println("__________________");
    }

    @Test(priority = 2)
    void secondSectionTest() {

        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Switch Window Example']")).getText());
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handIt = handles.iterator();
        String handler1=handIt.next();
        String handler2=handIt.next();
        for (String hand : handles){
            System.out.println(hand);
        }
        driver.switchTo().window(handler2);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        driver.close();
        driver.switchTo().window(handler1);
        System.out.println(driver.getTitle());
        System.out.println("__________________");

        System.out.println(driver.findElement(By.xpath("//legend[@class='switch-tab']")).getText());
        driver.findElement(By.id("opentab")).click();
        Set<String> handlesTabs = driver.getWindowHandles();
        Iterator<String> handIt2 = handlesTabs.iterator();
        String handlerTab1=handIt2.next();
        String handlerTab2=handIt2.next();
        for (String hand : handlesTabs){
            System.out.println(hand);
        }
        driver.switchTo().window(handlerTab2);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        driver.close();
        driver.switchTo().window(handlerTab1);
        System.out.println(driver.getTitle());
        System.out.println("__________________");

        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Switch To Alert Example']")).getText());
        driver.findElement(By.id("name")).sendKeys("Dago");
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains("Dago"));
        driver.switchTo().alert().accept();
        System.out.println("__________________");

        driver.findElement(By.id("name")).sendKeys("Dago");
        driver.findElement(By.id("confirmbtn")).click();
        String alertText2 = driver.switchTo().alert().getText();
        System.out.println(alertText2);
        Assert.assertTrue(alertText2.contains("Dago"));
        driver.switchTo().alert().dismiss();
        System.out.println("__________________");

    }

    @Test(priority = 3)
    void thirdSectionTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,6000)");

        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Web Table Example']")).getText());
        List<WebElement> prices = driver.findElements(By.cssSelector(".left-align #product tr td:nth-child(3)"));
        int total = 0;
        for (WebElement price : prices) {
            System.out.println(price.getText());
            total += Integer.parseInt(price.getText());
        }
        System.out.println("Total price: "+total);
        System.out.println("__________________");

        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Element Displayed Example']")).getText());
        driver.findElement(By.id("hide-textbox")).click();
        System.out.println("Click in Hide button");
        WebElement field = driver.findElement(By.id("displayed-text"));
        System.out.println(field.getDomAttribute("style"));
        driver.findElement(By.id("show-textbox")).click();
        System.out.println("Click in Show button");
        System.out.println(field.getDomAttribute("style"));
        driver.findElement(By.id("displayed-text")).sendKeys("Dago");
        System.out.println("__________________");


        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Web Table Fixed header']")).getText());
        List<WebElement> cities = driver.findElements(By.cssSelector(".right-align #product tr td:nth-child(3)"));
        List<WebElement> names = driver.findElements(By.cssSelector(".right-align #product tr td:nth-child(1)"));
        List<WebElement> positions = driver.findElements(By.cssSelector(".right-align #product tr td:nth-child(2)"));
        List<WebElement> amounts = driver.findElements(By.cssSelector(".right-align #product tr td:nth-child(4)"));

        List<WebElement> headers = driver.findElements(By.cssSelector(".right-align #product tr th"));
        System.out.println(headers.get(headers.size()-4).getText()+" "+headers.get(headers.size()-3).getText()+" "+headers.get(headers.size()-2).getText()+" "+headers.get(headers.size()-1).getText());
        System.out.println("......................");
        for(int i=0; i< cities.size();i++){
            if(cities.get(i).getText().contains("Chennai")){

                System.out.println(names.get(i).getText()+" "+positions.get(i).getText()+" "+cities.get(i).getText()+" "+amounts.get(i).getText());

            }
        }
        System.out.println("__________________");

    }

    @Test(priority = 4)
    void fourthSectionTest(){
        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='Mouse Hover Example']")).getText());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//legend[normalize-space()='Mouse Hover Example']")));
        driver.findElement(By.id("mousehover")).click();
        List<WebElement> hovers = driver.findElements(By.className("mouse-hover-content"));
        for(WebElement hover:hovers){
            if(hover.getText().contains("Top")){
                System.out.println(hover.getText());
                hover.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Practice Page']")).isDisplayed());
        js.executeScript("window.scrollBy(0,1300)");
        System.out.println("__________________");

        System.out.println(driver.findElement(By.xpath("//legend[normalize-space()='iFrame Example']")).getText());

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='courses-iframe']")));

        //Assert.assertEquals(driver.getTitle(),"Selenium, API Testing, Software Testing & More QA Tutorials  | Rahul Shetty Academy");
        System.out.println(driver.getTitle());
    }
}