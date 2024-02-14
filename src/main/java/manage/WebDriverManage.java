package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import properties_data.ConfigProperties;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverManage {

    /*System.setProperty("webdriver.chrome.driver", "---Exact path to chromedriver.exe---");
   WebDriver driver = new ChromeDriver();*/
    public static WebDriver driver;
    // static String browser;

    public WebDriverManage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @BeforeSuite
    public static void init() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.get("https://ilcarro.web.app/search");
        driver.navigate().to(ConfigProperties.getProperty("url"));
        navigateToHomePage();

    }
    public static void navigateToHomePage(){
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }
    public boolean isHomePageUrl(){
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url: " + currentUrl);
        return currentUrl.equals(ConfigProperties.getProperty("url"));
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }
}
