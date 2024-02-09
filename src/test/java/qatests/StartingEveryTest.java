package qatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class StartingEveryTest {
    WebDriver driver;
    SearchPage searchPageObject;
    @BeforeSuite
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ilcarro.web.app/search");
    }
    @AfterSuite
    public void tearDown(){
        // driver.quit();
    }
}
