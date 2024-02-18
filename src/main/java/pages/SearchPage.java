package pages;

import manage.WebDriverManage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties_data.ConfigReaderLogin;
import providers.User;
import providers.UserDtoLombok;

public class SearchPage extends PageBase{
    public SearchPage() {
        PageFactory.initElements(WebDriverManage.getDriver(),this);
    }


    //@FindBy(xpath = "//a[@id='0']")
    @FindBy(xpath = "//h1[@class='title']")
    WebElement textSearchTitle;

    public String getPageTitle() {

        return textSearchTitle.getText();
        //Find your car now!
    }
    public boolean isTitleSearchPageContain(){

        System.out.println("SearchPageAppearsCorrect");
        return isTextContains(textSearchTitle,"Find your car now!",10);

    }

    //********* log in from Search page - list of elements situated on search page
   // @FindBy(xpath = "btnLoginNavigatorMenu")
    @FindBy(xpath = "//a[contains(@href, 'login')]")
    WebElement btnLoginNavigatorMenu;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmailLoginForm;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPasswordLoginForm;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYallaLoginForm;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textSuccessLoginPopUp;
    @FindBy(xpath = "//button[@type='button']")
    WebElement btnOkPopUp;
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    WebElement btnLogout;



  /* // By btnLoginNavigatorMenu = By.xpath(ConfigReaderLogin.getProperty("btnLoginNavigatorMenu"));
   // By inputEmailLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputEmailLoginForm"));
   // By inputPasswordLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputPasswordLoginForm"));
    //By btnYallaLoginForm = By.xpath(ConfigReaderLogin.getProperty("btnYallaLoginForm"));
    //By textSuccessLoginPopUp = By.xpath(ConfigReaderLogin.getProperty("textSuccessLoginPopUp"));

    String btnOkPopUpStr = ConfigReaderLogin.getProperty("btnOkPopUpStr");
    By btnOkPopUp = By.xpath(ConfigReaderLogin.getProperty("btnOkPopUp"));
    By checkBoxReg = By.xpath(ConfigReaderLogin.getProperty("checkBoxReg"));
    By btnUallaReg = By.xpath(ConfigReaderLogin.getProperty("btnUallaReg"));
    By textPopUpSuccessRegH1 = By.xpath(ConfigReaderLogin.getProperty("textPopUpSuccessRegH1"));
   By btnLogout = By.xpath(ConfigReaderLogin.getProperty("btnLogout"));
    By errorMessageIncorrectPasswordReg = By.xpath(ConfigReaderLogin.getProperty("errorMessageIncorrectPasswordReg"));*/


//login method

    public void loginUserDtoLombok(UserDtoLombok user) {
        System.out.println(user.getEmail());
        clickBase(btnLoginNavigatorMenu,30);
        sendTextBase(inputEmailLoginForm, 30, user.getEmail());
        sendTextBase( inputPasswordLoginForm, 30, user.getPassword());
        clickBase(btnYallaLoginForm,10);


    }
    public void popUpOK(){
        clickBase(btnOkPopUp, 30);
    }

    public boolean validatePopUpMessageSuccessAfterLogin() {
        return isTextContains(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgLoggedInSuccess"));

    }


    private boolean isTextContains(WebElement textSuccessLoginPopUp, String msgLoggedInSuccess) {
        return isTextEqual(textSuccessLoginPopUp, ConfigReaderLogin.getProperty("msgLoggedInSuccess"));
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

    // log in get data from propertyFile

    public void loginUser(User userPropertyFile) {
        System.out.println(userPropertyFile.getEmail());
        clickBase(btnLoginNavigatorMenu,30);
        sendTextBase(inputEmailLoginForm, 30, userPropertyFile.getEmail());
        sendTextBase( inputPasswordLoginForm, 30, userPropertyFile.getPassword());
        clickBase(btnYallaLoginForm,10);


    }
}
