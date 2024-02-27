package pages;

import manage.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties_data.ConfigReaderLogin;


// @FindBy(xpath = "element") WebElement element ;
// By element = By.xpath(ConfigReaderLogin.getProperty("element"));

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
    public void click(By locator){
        WebDriverManage.getDriver().findElement(locator).click();
    }

//5. my type text

    public void sendTextBase(WebElement element, int time, String text) {
        wait(element, time);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    //6. is element exist
    public boolean isElementDisplayed(WebElement element, int time) {
        try{
            wait(element, time);
            return element.isDisplayed();
        }catch (Exception ex){
            return  false;
        }
    }
    // 7. is text contains
    public boolean isTextContains(WebElement element, String expectedRes, int time) {
        expectedRes = expectedRes.toUpperCase().trim();
        String actualRes = getTextBase(element, time);
        if (actualRes.contains(expectedRes)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedRes +
                    " actual result: " + actualRes);
            return false;
        }
    }
    public boolean validatePopUpMessageSuccessAfterLogin(WebElement textSuccessLoginPopUp, String msgLoggedInSuccess) {
        return isTextContains(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgLoggedInSuccess"));
    }
    public boolean validatePopUpMessageLoginIncorrect(WebElement textSuccessLoginPopUp, String msgLoggedInSuccess) {
        return isTextEqual(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgWrongLogin"));
    }

    private boolean isTextContains(WebElement textSuccessLoginPopUp, String msgLoggedInSuccess) {
        return isTextEqual(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgWrongLogin"));
    }

    private boolean isTextEqual(WebElement textSuccessLoginPopUp, String expectedResult) {

        String actualResult = textSuccessLoginPopUp.getText();
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }




}







