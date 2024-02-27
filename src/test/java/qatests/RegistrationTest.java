package qatests;

import org.testng.annotations.BeforeMethod;

public class RegistrationTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        searchPageObject.logoutIfDisplayed();
    }
}
