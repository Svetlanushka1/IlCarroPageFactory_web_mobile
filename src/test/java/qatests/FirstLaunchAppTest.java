package qatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class FirstLaunchAppTest extends TestBase {/*
   WebDriver driver;


    //@BeforeSuite
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

    //Create Page object and put driver in it
    searchPageObject = new SearchPage(driver);

    // verify logo page title
       // String searchPageTitle = searchPageObject.getPageTitle();
      //  Assert.assertTrue(searchPageTitle.contains("Search"));
    Assert.assertTrue(searchPageObject.getPageTitle().contains("Search"));
    }




    @Test
    public void checkUrlCorrect(){
        PageBase pageBaseObject = new PageBase(driver);

        pageBaseObject.isHomePageUrl();
    }
*/
}
