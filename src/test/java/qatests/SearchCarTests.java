package qatests;

public class SearchCarTests extends StartingEveryTest{

}
/*
 private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    }


    public void clickBase(By locator){
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator){
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text){
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult){
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)){
            return true;
        } else{
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }
 */