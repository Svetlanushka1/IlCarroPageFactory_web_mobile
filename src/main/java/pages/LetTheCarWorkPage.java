package pages;

import manage.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import providers.AddCarDTO;


import java.time.Duration;

public class LetTheCarWorkPage extends PageBase {
    public LetTheCarWorkPage() {

        PageFactory.initElements(WebDriverManage.getDriver(), this);
    }

//1) add new car button
    @FindBy(xpath = "//a[contains(@href,'let-car-work')]")
    WebElement btnAddNewCarMenu;
     //2) placeholder="Enter your address"  - city
    @FindBy(xpath = "//*[@id='pickUpPlace'] ")
    WebElement inputLocationXPath;   //By locationInputLocator=By.xpath("//input[@id='pickUpPlace']");
    @FindBy(xpath = "//div[contains(@class, 'pac-container pac-logo hdpi') and not(contains(@style, 'display: none'))]")
    WebElement containerCities ;//containerCities= //div[contains(@class, 'pac-container pac-logo hdpi') and not(contains(@style, 'display: none'))]
//3) type manufacture
    @FindBy(xpath = "//input[@id='make']")
    WebElement inputManifacturexPath;
// 4) type model
    @FindBy(xpath = "//input[@id='model']")
    WebElement inputModelxPath;//inputModelxPath = //input[@id='model']
 // 5) type year
     @FindBy(id = "year")
     WebElement inputYearId;
//6) select fuel Diesel - [1]
    @FindBy(id = "fuel")
    WebElement selectFuelId;
//7)type seats
    @FindBy(id = "seats")
    WebElement inputSeatsId;
//8)type class
    @FindBy(id = "class")
    WebElement inputClassId;
// 9) type Car registration number
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumberId;
// 10) type price
    @FindBy(id = "price")
    WebElement inputPriceId ;
    @FindBy(xpath = "//div[@class='dialog-container']//h1[@class='title']")
    WebElement textPopUpTitle ;// By textPopUpTitle=By.xpath("//div[@class='dialog-container']//h1[@class='title']");
    @FindBy(xpath = "//button[contains(@class, 'negative-button')]")
    WebElement btnAddAnotherCarPopUp;
    @FindBy(id = "about")//By inputAbout=By.id("about");
    WebElement inputAbout ;
    @FindBy(id = "photos")//By labelPhoto=By.id("photos");
    WebElement labelPhoto ;
    @FindBy(xpath = "//button[@type='submit']") //By btnSubmitNewCar=By.xpath("//button[@type='submit']");
    WebElement btnSubmitNewCar ;
/*
    public void clickAddNewCar() {
        clickBase(btnAddNewCarMenu,3000);
    }

    public void fillFormNewCar(AddCarDTO car) {

            enterLocationWithAutocomplete(car.getCity());
            sendTextBase(inputManifacturexPath, 10, car.getManufacture());

    sendTextBase(inputModelxPath,10,car.getModel());

}

    private void enterLocationWithAutocomplete(String city) {

        sendTextBase(inputLocationXPath, 10, city);
        selectFirstOptionFromGooglePlacesDropdown();
    }

    private void selectFirstOptionFromGooglePlacesDropdown() {

        Actions builder = new Actions(WebDriverManage.getDriver());
        builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

*/
    public boolean validateMessagePopup(){
        return isTextEqual(textPopUpTitle,"Car added".trim().toUpperCase());
    }


        public By getOptionFuel(String str) {
            return By.xpath(String.format("//option[@value='%s']", str));
        }


        public void clickAddNewCar() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickBase(btnAddNewCarMenu,3000);
        }

        public void clickAddNewCarPopUp() {
            clickBase(btnAddAnotherCarPopUp, 3000);
        }

        public void fillFormNewCar(AddCarDTO car) {
            //enterLocationWithAutocomplete(car.getCity());
            sendTextBase(inputLocationXPath,300, car.getCity());
            sendTextBase(inputManifacturexPath, 3000,car.getManufacture());
            sendTextBase(inputModelxPath,3000, car.getModel());
            sendTextBase(inputYearId,300, String.valueOf(car.getYear()));
            clickBase(selectFuelId,3000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            click(getOptionFuel(car.getFuel()));
            sendTextBase(inputSeatsId, 3000, String.valueOf(car.getSeats()));
            sendTextBase(inputClassId, 3000, car.getCarClass());
            sendTextBase(inputSerialNumberId, 3000, car.getSerialNumber());
            sendTextBase(inputPriceId, 3000, String.valueOf(car.getPricePerDay()));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickBase(btnSubmitNewCar,3000);
            // location
        }



    public boolean validateMessagePopUp() {
            return isTextEqual(textPopUpTitle, "Car added".trim().toUpperCase());
        }

    /*    private void enterLocationWithAutocomplete(String location) {
                        sendTextBase(locationInputLocator,3000, location);
            selectFirstOptionFromGooglePlacesDropdown();
        }

        private void selectFirstOptionFromGooglePlacesDropdown() {
            WebDriverWait wait = new WebDriverWait(WebDriverManage.getDriver(), Duration.ofSeconds(20));
//        WebElement autoCompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(containerCities));
            Actions builder = new Actions(WebDriverManage.getDriver());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

//        builder.moveToElement(autoCompleteResult).perform();
            builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        }
       public boolean isElementPresent(By locator, int waitTime, String text){
            return new WebDriverWait(WebDriverManage.getDriver(),waitTime)
                    .until(ExpectedConditions.textToBePresentInElement(WebDriverManage.getDriver().findElement(locator),text));
        }
*/

}
