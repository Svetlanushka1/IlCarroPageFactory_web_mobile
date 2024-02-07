package qatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class HomePageAppearCorrectTest {
    WebDriver driver;
    HomePage homePageObject;
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
    @Test
    public  void homePage_AppearsCorrect(){

    //Create Home Page object and put driver in it
        homePageObject = new HomePage(driver);

    // verify logo page title
        String homePageTitle = homePageObject.getPageTitle();
        Assert.assertTrue(homePageTitle.contains("Search"));
    // Assert.assertTrue(homePageObject.getHomePageTitleName().toLowerCase().contains(" Search "));

    }

}
