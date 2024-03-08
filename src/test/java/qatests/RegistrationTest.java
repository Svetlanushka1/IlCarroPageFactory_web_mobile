package qatests;

import org.testng.annotations.BeforeMethod;

public class RegistrationTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        searchPageObject.logoutIfDisplayed();
    }
}
/*
package tests;

import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test
    public void registrationPositiveTest(){

        int i = (int)((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "mail.com")
                .withPassword("$Asdf1234" + i);

        logger.info("registrationPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckbox();
        app.getUser().submitForm();

        logger.info("registrationPositiveTest completed");

        Assert.assertTrue(app.getUser().isRegisteredSuccess());

    }
    @Test(dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user){

        logger.info("registrationPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckbox();
        app.getUser().submitForm();

        logger.info("registrationPositiveTest completed");

        Assert.assertTrue(app.getUser().isRegisteredSuccess());

    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}

 */
