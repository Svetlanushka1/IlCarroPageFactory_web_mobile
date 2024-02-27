package qatests;

import manage.WebDriverManage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class DoesAppDisplaysCorrectly extends WebDriverManage {
    public DoesAppDisplaysCorrectly(WebDriver driver) {
        super(driver);
    }
/*


    @Test
    public void doesAppDisplaysCorrectly() {
        Assert.assertTrue(new SearchPage(driver)
                .getPageTitle()
                .contains("IlCarro"));
    }

public class LoginTest extends AppiumConfig {
    @Test
    public void loginPositive(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openLoginForm()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin()
                .isLogoutButtonPresent()
                .returnToSerachScreen();


    }

//       new SearchScreen(driver)
//               .openMoreOptions()
//               .logout();


    }*/

}
