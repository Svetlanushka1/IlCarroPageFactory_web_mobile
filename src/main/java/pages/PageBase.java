package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import properties_data.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class PageBase {

    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void init() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.get("https://ilcarro.web.app/search");
            //driver.navigate().to(ConfigProperties.getProperty("url"));
            navigateToHomePage();
        }



    }
    public void navigateToHomePage(){
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }
    public boolean isHomePageUrl(){
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url: " + currentUrl);
        return currentUrl.equals(ConfigProperties.getProperty("url"));
    }
}
