package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.time.Duration;


public class Base {

    public static WebDriver driver;
    //DesiredCapabilities dc = new DesiredCapabilities();

//    @BeforeClass
//    public void setupGrid() throws MalformedURLException {
//
//        dc.setBrowserName("chrome");
//        driver = new RemoteWebDriver(new URL("http://192.168.100.5:4444"),dc);
//
//        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
//
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.manage().window().maximize();
//
//    }
@Parameters("browser")
@BeforeClass
    public static void setup(@Optional("chrome")String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver();
    }else if (browser.equalsIgnoreCase("edge")) {
        driver = new EdgeDriver();
    }else
        driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

@AfterClass
    public void tearDown(){
        driver.quit();
    }

}
