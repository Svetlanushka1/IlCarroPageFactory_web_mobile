package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties_data.ConfigReaderLogin;
import providers.UserDtoLombok;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    LoginPage loginPageObject = new LoginPage(driver);
 //******************************************************************** 

    @FindBy(xpath = "btnLoginNavigatorMenu")
    WebElement btnLoginNavigatorMenu;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmailLoginForm;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPasswordLoginForm;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYallaLoginForm;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textSuccessLoginPopUp;
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    WebElement btnLogout;
    @FindBy(xpath = "//input[@autocomplete='email']/..//div//div")
    WebElement errorMessageWrongEmailReg;
    @FindBy(xpath = "//input[@autocomplete='email']/..//div//div")


   // By btnLoginNavigatorMenu = By.xpath(ConfigReaderLogin.getProperty("btnLoginNavigatorMenu"));
   // By inputEmailLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputEmailLoginForm"));
   // By inputPasswordLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputPasswordLoginForm"));
    //By btnYallaLoginForm = By.xpath(ConfigReaderLogin.getProperty("btnYallaLoginForm"));
    //By textSuccessLoginPopUp = By.xpath(ConfigReaderLogin.getProperty("textSuccessLoginPopUp"));
    By btnOpenRegForm = By.xpath(ConfigReaderLogin.getProperty("btnOpenRegForm"));
    By inputNameReg = By.xpath(ConfigReaderLogin.getProperty("inputNameReg"));
    By inputLastNameReg = By.xpath(ConfigReaderLogin.getProperty("inputLastNameReg"));
    By inputEmailReg = By.xpath(ConfigReaderLogin.getProperty("inputEmailReg"));
    By inputPasswordReg = By.xpath(ConfigReaderLogin.getProperty("inputPasswordReg"));
    String btnRegNewUser = ConfigReaderLogin.getProperty("btnRegNewUser");
    String btnOkPopUpStr = ConfigReaderLogin.getProperty("btnOkPopUpStr");
    By btnOkPopUp = By.xpath(ConfigReaderLogin.getProperty("btnOkPopUp"));
    By checkBoxReg = By.xpath(ConfigReaderLogin.getProperty("checkBoxReg"));
    By btnUallaReg = By.xpath(ConfigReaderLogin.getProperty("btnUallaReg"));
    By textPopUpSuccessRegH1 = By.xpath(ConfigReaderLogin.getProperty("textPopUpSuccessRegH1"));
   // By btnLogout = By.xpath(ConfigReaderLogin.getProperty("btnLogout"));
   // By errorMessageWrongEmailReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageWrongEmailReg"));
    By errorMessageIncorrectPasswordReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageIncorrectPasswordReg"));


//***********************************************

    public void loginUserDtoLombok(UserDtoLombok user) {
        btnLoginNavigatorMenu.click();
        inputEmailLoginForm.sendKeys(user.getEmail());
        inputPasswordLoginForm.sendKeys(user.getPassword());
        btnYallaLoginForm.click();
    }

    public boolean validatePopUpMessageSuccessAfterLogin() {
        return isTextContains(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgLoggedInSuccess"));
    }

    private boolean isTextContains(WebElement textSuccessLoginPopUp, String msgLoggedInSuccess) {
        return isTextEqual(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgWrongLogin"));
    }

    private boolean isTextEqual(WebElement textSuccessLoginPopUp, String expectedResult) {

        String actualResult = textSuccessLoginPopUp.getText();
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }

  /*  public String getTextBase(By locator) {
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }
    private WebElement findElementBase(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }*/
    /*
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

    public boolean validatePopUpMessageLoginIncorrect() {
        return isTextEqual(textSuccessLoginPopUp, ConfigReader.getProperty("msgWrongLogin"));
    }



    //    solution for not exist button
    public boolean btnLogoutExist() {
        return isElementExist(btnLogout);
    }

    public void logout() {
        clickBase(btnLogout);
    }
    public void clickOkPopUpSuccessLogin() {
//        clickBase(btnOkPopUp);
//        clickBase(textPopUpSuccessRegH1);
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
