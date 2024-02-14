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


    public PageBase() {
        PageFactory.initElements(WebDriverManage.getDriver(), this);
    }

    protected void wait(WebElement element, int time) {
        new WebDriverWait(WebDriverManage.getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public String getTextBase(WebElement element, int time) {
        wait(element, time);
        return element.getText().toUpperCase().trim();
    }

    public void clickBase(WebElement element, int time) {
        wait(element, time);
        element.click();
    }


    public void sendTextBase(WebElement element, int time, String text) {
        wait(element, time);
        element.click();
        element.clear();
        element.sendKeys(text);

    }


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

