package qatests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import properties_data.ConfigProperties;
import providers.DataProviderLogin;
import providers.User;
import providers.UserDtoLombok;

public class LoginTest extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {

        //logoutIflogin();
    }



    @Test
    public void hardCodePositiveLogin(){
        searchPageObject.getPageTitle();
        UserDtoLombok user = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
        searchPageObject.loginUserDtoLombok(user);
        //Assert.assertTrue(searchPageObject.validatePopUpMessageSuccessAfterLogin());
        searchPageObject.popUpOK();

    }
    // data from prod.properties file
     @Test
    public void positiveLoginFromConfigProperties() {
        User userPropertyFile = new User(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        //logger.info("take login from PROPERTIES file");
         searchPageObject.loginUser(userPropertyFile);
        Assert.assertTrue(searchPageObject.validatePopUpMessageSuccessAfterLogin());
        searchPageObject.popUpOK();
       // logger.info("login using production PROPERTIES file");
    }
    //data from datalogin.csv    file
    // @Test(dataProvider = "datalogin.csv",dataProviderClass = DataProviderLogin.class)

    @Test(groups = {"smoke"}, dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    public void positiveLoginProvider(UserDtoLombok userCSV){
        //logger.info("User: " + user.toString());
        searchPageObject.loginUserDtoLombok(userCSV);
       // flagLogin = true;
       // flagPopUp = true;
      //  Assert.assertTrue(searchPageObject.validatePopUpMessageSuccessAfterLogin());
        //logger.info("login using CSV file");
        searchPageObject.popUpOK();

    }


  /*  @Test(dataProvider = "negativeLoginCSV", dataProviderClass = DataProviderLogin.class)
    public void negativeDataLoginCSV(UserDtoLombok user) {
        loginPageObject.loginUserDtoLombok(user);
       // flagPopUp = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(loginPageObject.validatePopUpMessageLoginIncorrect());
    }*/

//TODO adapt find element like @Find by

}
