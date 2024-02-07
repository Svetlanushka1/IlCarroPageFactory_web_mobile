package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@id='0']")
    WebElement textSearch;

       public String getPageTitle() {
           return textSearch.getText();
    }
/*
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

    public String getTextBase(WebElement element, int time) {
        wait(element, time);
        return element.getText().toUpperCase().trim();
    }
    protected void wait(WebElement element, int time) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(element));
    }


    public String getPageTitle() {
        getTextBase(textSearch,10);
        return textSearch.getText().toUpperCase().trim();
    }*/
}
