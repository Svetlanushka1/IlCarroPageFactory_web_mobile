package pages;

public class RegistrationPage {
//*******************  REGISTRATION form
/*
    @FindBy(xpath = "//input[@autocomplete='email']/..//div//div")
    WebElement errorMessageWrongEmailReg;
    @FindBy(xpath = "//input[@autocomplete='email']/..//div//div")

    By btnOpenRegForm = By.xpath(ConfigReaderLogin.getProperty("btnOpenRegForm"));
    By inputNameReg = By.xpath(ConfigReaderLogin.getProperty("inputNameReg"));
    By inputLastNameReg = By.xpath(ConfigReaderLogin.getProperty("inputLastNameReg"));
    By inputEmailReg = By.xpath(ConfigReaderLogin.getProperty("inputEmailReg"));
    By inputPasswordReg = By.xpath(ConfigReaderLogin.getProperty("inputPasswordReg"));
    String btnRegNewUser = ConfigReaderLogin.getProperty("btnRegNewUser");
     By checkBoxReg = By.xpath(ConfigReaderLogin.getProperty("checkBoxReg"));
    By btnUallaReg = By.xpath(ConfigReaderLogin.getProperty("btnUallaReg"));
    String btnOkPopUpStr = ConfigReaderLogin.getProperty("btnOkPopUpStr");
    By btnOkPopUp = By.xpath(ConfigReaderLogin.getProperty("btnOkPopUp"));
  // By btnLoginNavigatorMenu = By.xpath(ConfigReaderLogin.getProperty("btnLoginNavigatorMenu"));
   // By inputEmailLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputEmailLoginForm"));
   // By inputPasswordLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputPasswordLoginForm"));
    //By btnYallaLoginForm = By.xpath(ConfigReaderLogin.getProperty("btnYallaLoginForm"));
    //By textSuccessLoginPopUp = By.xpath(ConfigReaderLogin.getProperty("textSuccessLoginPopUp"));
   By textPopUpSuccessRegH1 = By.xpath(ConfigReaderLogin.getProperty("textPopUpSuccessRegH1"));
   By btnLogout = By.xpath(ConfigReaderLogin.getProperty("btnLogout"));
    By errorMessageIncorrectPasswordReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageIncorrectPasswordReg"));
    By errorMessageWrongEmailReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageWrongEmailReg"));
    By errorMessageIncorrectPasswordReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageIncorrectPasswordReg"));

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnOpenRegForm);
        typeTextBase(inputNameReg, user.getName());
        typeTextBase(inputLastNameReg, user.getLastName());
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickByXY(checkBoxReg, 5, 15);
        //jsClickBase(btnRegNewUser);
        clickBase(btnUallaReg);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "Registered".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);
    }




    public void clickOkPopUpSuccessLogin() {
       clickBase(btnOkPopUp);
        clickBase(textPopUpSuccessRegH1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.textMatches(textSuccessLoginPopUp, Pattern.compile("[\\w]*")));
        jsClickBase(btnOkPopUpStr);

    }

    public boolean validateMessageIncorrectEmailReg() {
        return isTextEqual(errorMessageWrongEmailReg, "Wrong email format");
    }

    public boolean validateMessageWrongPasswordReg() {
        return isTextEqual(errorMessageIncorrectPasswordReg,
                "PASSWORD MUST CONTAIN 1 UPPERCASE LETTER, 1 LOWERCASE LETTER, 1 NUMBER AND ONE SPECIAL SYMBOL OF [@$#^&*!]");
    }

    public boolean validateErrorEmptyEmailReg() {
        return isTextEqual(errorMessageWrongEmailReg, "Email is required");
    }
}
   */


}
