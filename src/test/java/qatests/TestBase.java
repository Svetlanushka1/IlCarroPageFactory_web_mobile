package qatests;

import pages.LoginPage;
import pages.SearchPage;

public class TestBase {
   // PageBase pageBaseObject = new PageBase();

    SearchPage searchPageObject = new SearchPage();
    LoginPage loginPageObject = new LoginPage();
 //   SignUpPage signUpPage = new SignUpPage();
 //   MyCarsPage myCarsPage = new MyCarsPage();
  //  AddNewCarPage addNewCarPage = new AddNewCarPage();
   // RandomUtils randomUtils = new RandomUtils();

   /* UserDTO user = UserDTO.builder()
            .username("aaaaa@mail.com")
            .password("123456Aa$")
            .build();*/

  /*  @AfterMethod(alwaysRun = true)
    public void quitBrowser(ITestResult result) throws Exception {
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            takeSnapShot(driver);

        }
        driver.quit();
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }*/
}

