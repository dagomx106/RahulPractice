package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Base {

    public static WebDriver driver;
    public static DesiredCapabilities dc = new DesiredCapabilities();

@Parameters("browser")
@BeforeClass
    public static void setup(@Optional("chrome")String browser) throws MalformedURLException {
    if (browser.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver();
    }else if (browser.equalsIgnoreCase("edge")) {
        driver = new EdgeDriver();
    }else if (browser.equalsIgnoreCase("grid")) {
        dc.setBrowserName("MicrosoftEdge");
        driver = new RemoteWebDriver(new URL("http://169.254.3.142:4444"),dc);
    }else if (browser.equalsIgnoreCase("docker")) {
        dc.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://192.168.100.56:4444"),dc);
    } else
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
