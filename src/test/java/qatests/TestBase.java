package qatests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.PageBase;
import pages.SearchPage;
import properties_data.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class TestBase {

   WebDriver driver;
    @BeforeSuite
  /*  public void openBrowser() {
        // pageBaseObject.init();
    }*/
 public void init() {
  if (driver == null) {
   driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // driver.get("https://ilcarro.web.app/search");
   driver.navigate().to(ConfigProperties.getProperty("url"));
   navigateToHomePage();
  }
     createPages();
 }

 public void createPages() {
 }

 public void navigateToHomePage(){
  driver.navigate().to(ConfigProperties.getProperty("url"));
 }
    @AfterSuite
    public void closeBrowser() {
       // pageBaseObject.tearDown();
    }
  /*  @AfterMethod(alwaysRun = true)
    public void quitBrowser(ITestResult result) throws Exception {
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            takeSnapShot(driver);

        }
        driver.quit();
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }*/
}

