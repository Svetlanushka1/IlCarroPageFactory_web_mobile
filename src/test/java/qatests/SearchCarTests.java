package qatests;
import manage.WebDriverManage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;


public class SearchCarTests extends TestBase {
    @FindBy(className = "search-results")
    WebElement searchResults;
    @BeforeMethod(alwaysRun = true)
    public void returnHomePage(){
        searchPageObject.clickLogo();

    }

 @Test
    public void checkSearchPageAppearsCorrect(){
      searchPageObject.isTitleSearchPageContain();
       Assert.assertTrue(searchPageObject.getPageTitle().contains("Find your car now!"));

    }
    @Test
    public void searchCurrentMonthSuccess(){
        searchPageObject.searchCurrentMonth2("Tel Aviv","5/31/2024","6/31/2024");
        searchPageObject.submitForm();
        Assert.assertTrue(searchPageObject.isListOfCarsAppeared());
    }
    @Test
    public void searchCarTelAviv(){
        searchPageObject.fillSearchForm("Tel Aviv","04/25/2024","06/29/2024");
        searchPageObject.submitForm();
    }
/*
    @Test (groups = {"smoke"})
    public void searchNextMonthSuccess(){
        searchPageObject.searchNextMonth("Jerusalem Israel","11/25/2022","11/30/2022");
        // app.getSearch().searchNextMonth("Tel Aviv","11-25-22","11/30/2022");
        searchPageObject.submitForm();
        Assert.assertTrue(searchPageObject.isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriod(){
        searchPageObject.selectAnyPeriod("Haifa Israel","2/20/2023","6/10/2023");
        searchPageObject.submitForm();
        Assert.assertTrue(searchPageObject.isListOfCarsAppeared());
        Assert.assertTrue(searchPageObject.isDataCorrect("2/20/2023","6/10/2023"));
    }
    @Test
    public void searchInPast(){
        searchPageObject.typePeriodInPast("Rehovot Israel","10/5/2022","10/10/2022");
        searchPageObject.submitWithoutWait();
        Assert.assertTrue(searchPageObject.isYallaButtonNotActive());
        Assert.assertTrue(searchPageObject.isErrorMessageDisplayed());  ///You can't pick date before today}

TODO submitWithoutWait(),isYallaButtonNotActive(),isErrorMessageDisplayed()
 */





    @Test
    public void searchTest(){

        searchPageObject.fillSearchForm("Tel Aviv","04/25/2024","06/29/2024");
        //month/day/2024
        searchPageObject.submitForm();
        Assert.assertTrue(searchPageObject.isElementDisplayed(searchResults,3000));
                //By.className("search-results")));
    }

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