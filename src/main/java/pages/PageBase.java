package pages;

import manage.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties_data.ConfigProperties;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageBase {

//1. init Elements
    public PageBase() {
        PageFactory.initElements(WebDriverManage.getDriver(), this);
    }
//2. wait until
    protected void wait(WebElement element, int time) {
        new WebDriverWait(WebDriverManage.getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }
//3.get text
    public String getTextBase(WebElement element, int time) {
        wait(element, time);
        return element.getText().toUpperCase().trim();
    }
//4. my click method
    public void clickBase(WebElement element, int time) {
        wait(element, time);
        element.click();
    }



//5. type text

    public void sendTextBase(WebElement element, int time, String text) {
        wait(element, time);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

//6. is text contains
    public boolean isTextContains(WebElement element, String expectedRes, int time) {
        expectedRes = expectedRes.toUpperCase().trim();
        String actualRes = getTextBase(element, time);
        if(actualRes.contains(expectedRes)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedRes +
                    " actual result: " + actualRes);
            return false;
        }
    }
}

