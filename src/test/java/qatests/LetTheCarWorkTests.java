package qatests;

import manage.WebDriverManage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties_data.ConfigProperties;
import providers.AddCarDTO;
import providers.User;

import java.util.Random;

public class LetTheCarWorkTests extends TestBase {
    @BeforeTest
    public void loginPreConditions() {

        WebDriverManage.navigateToHomePage();
        thisPageAppearCorrectly();
       /* User userPropertyFile = new User(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        //logger.info("take login from PROPERTIES file");
        searchPageObject.loginUser(userPropertyFile);
        Assert.assertTrue(searchPageObject.validatePopUpMessageSuccessAfterLogin());
        searchPageObject.popUpOK();*/
    }

   @Test
    public void thisPageAppearCorrectly(){
        WebDriverManage.navigateToPage("https://ilcarro.web.app/let-car-work");
    }
    @Test
    public void addNewCarTest() {

        Random random = new Random();
        String serNumber = String.valueOf(Math.round(random.nextFloat() * Math.pow(10, 12)));
        //int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        AddCarDTO car = AddCarDTO.builder()
                .serialNumber(serNumber)
                .manufacture("Toyota Camry2")
                .model("Sedan")
                .year(2023)
                .fuel("Hybrid")
                .seats(4)
                .carClass("luxury")
                .pricePerDay(400)
                .city("Tel Aviv")
                .build();
        // Tel Aviv, Israel
        letTheCarWorkPageObject.clickAddNewCar();
        letTheCarWorkPageObject.fillFormNewCar(car);
        Assert.assertTrue(letTheCarWorkPageObject.validateMessagePopUp());
    }
/*
    @AfterMethod
    public void logoutAfterConditions() {
        searchPageObject.logoutIfDisplayed();
        WebDriverManage.navigateToHomePage();
    }*/

}
    /*
    @Test(dataProvider = "negativeAddCarCSV",dataProviderClass = DataProviderCars.class)
    public void positiveLoginProvider(UserDtoLombok user){
        app.getUserHelper().loginUserDtoLombok(user);
        flagLogin = true;
        flagPopUp = true;
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }*/
    //span[@class='pac-item-query']
