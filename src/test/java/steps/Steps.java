package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Steps {

    public static WebDriver driver;

    @Given("User is in login page")
    public void user_is_in_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://rahulshettyacademy.com/angularpractice/#");
        System.out.println("user is in login page");
    }

    @When("^user enters valid (.*) and (.*)$")
    public void userEntersValidUsernameAndPassword(String username, String password) {
        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
        System.out.println("user enters valid credentials");
    }

    @When("clicks submit button")
    public void clicks_submit_button() {
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println("user clicks submit button");
    }

    @Then("page displays a successful message")
    public void page_displays_a_successful_message() {
        String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println("successful message is displayed: " + text);
    }

    @And("page gets closed")
    public void pageGetsClosed() {
        System.out.println("Page gets closed");
        driver.quit();
    }

    @Given("User is in product page")
    public void user_in_product_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://rahulshettyacademy.com/angularpractice/shop");
        System.out.println("user is in product page");
    }

    @When("User clicks in add buttons for selected products")
    public void user_clicks_add_button_for_selected_products() {
        driver.findElement(By.xpath("//app-card[1]//div[1]//div[2]//button[1]")).click();
        System.out.println("user clicks submit button");
    }

    @And("products are added to cart")
    public void products_added_toCart() {
        String chkText = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText();
        System.out.println("products added to cart: " + chkText);
    }

    @Then("user clicks in cart button")
    public void user_clicks_cartButton() {
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        System.out.println("Clicks cart button");
    }

    @And("user clicks in checkout button")
    public void user_clicks_checkoutButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
        System.out.println("Clicks checkout button");
        driver.quit();
    }
}