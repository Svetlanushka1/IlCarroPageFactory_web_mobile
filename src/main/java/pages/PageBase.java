package pages;

import manage.WebDriverManage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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


//5. my type text

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
        if (actualRes.contains(expectedRes)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedRes +
                    " actual result: " + actualRes);
            return false;
        }
    }
    public boolean isElementDisplayed(WebElement element, int time) {
        try{
        wait(element, time);
        return element.isDisplayed();
    }catch (Exception ex){
        return  false;
        }
    }
    /*
   @FindBy(xpath = "//a[contains(@href, 'logout')]")
    WebElement btnLogout;
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    public List<WebElement> elementsListLogout;

   public void logout() {
        clickBase(btnLogout, 30);
    }


 //     **********  is element exist??????
    public boolean btnLogoutExist() {
       boolean isExist = false;
       if(elementsListLogout.size() > 0)
           isElementExist((WebElement) elementsListLogout);
       return isExist;
    }
    public boolean  isElementExist(WebElement element) {
        return elementsListLogout.size() > 0;
    }*/
}







