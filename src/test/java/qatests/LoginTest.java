package qatests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import properties_data.ConfigProperties;
import providers.DataProviderLogin;
import providers.UserDtoLombok;

public class LoginTest extends TestBase{
    public LoginTest(){
        super();
    }

    LoginPage loginPageObject = null;

    @Override
    public void createPages() {
        loginPageObject = new LoginPage(driver);
    }

    @Test
    public void hardCodePositiveLogin(){
        UserDtoLombok user = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();
        loginPageObject.loginUserDtoLombok(user);
        Assert.assertTrue(loginPageObject.validatePopUpMessageSuccessAfterLogin());

    }


  /*  @Test
    public void positiveLoginFromConfigProperties() {
        UserDTO userPropertyFile = new UserDTO(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        //logger.info("take login from PROPERTIES file");
        TestBase.app.getUserHelper().login(userPropertyFile);
        Assert.assertTrue(TestBase.app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
       // logger.info("login using production PROPERTIES file");
    }*/
    // @Test(dataProvider = "datalogin.csv",dataProviderClass = DataProviderLogin.class)
    @Test(groups = {"smoke"}, dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    public void positiveLoginProvider(UserDtoLombok user){
        //logger.info("User: " + user.toString());
        loginPageObject.loginUserDtoLombok(user);
       // flagLogin = true;
       // flagPopUp = true;
        Assert.assertTrue(loginPageObject.validatePopUpMessageSuccessAfterLogin());
        //logger.info("login using CSV file");

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
