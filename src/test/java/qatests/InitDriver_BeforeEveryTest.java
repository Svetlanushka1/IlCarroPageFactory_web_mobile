package qatests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import pages.PageBase;
import pages.SearchPage;

public class InitDriver_BeforeEveryTest {
    WebDriver driver;
    PageBase homePageObject;
    SearchPage searchPageObject;

    @BeforeSuite
    public void init() {
       /* if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.get("https://ilcarro.web.app/search");
            driver.navigate().to(ConfigProperties.getProperty("url"));

        }
    }

    @AfterSuite
    public void tearDown() {
        // driver.quit();
    }*/
    }
}

