package pages;

import manage.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties_data.ConfigReaderLogin;
import providers.UserDtoLombok;

import java.time.Duration;
import java.util.List;

public class LoginPage extends PageBase {
    public LoginPage() {

        PageFactory.initElements(WebDriverManage.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@class='message']")
    WebElement textSuccessLoginPopUp;
    By textPopUpSuccessRegH1 = By.xpath(ConfigReaderLogin.getProperty("textPopUpSuccessRegH1"));
    String btnOkPopUpStr = ConfigReaderLogin.getProperty("btnOkPopUpStr");
    By btnOkPopUp = By.xpath(ConfigReaderLogin.getProperty("btnOkPopUp"));
    // By btnLoginNavigatorMenu = By.xpath(ConfigReaderLogin.getProperty("btnLoginNavigatorMenu"));
    // By inputEmailLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputEmailLoginForm"));
    // By inputPasswordLoginForm = By.xpath(ConfigReaderLogin.getProperty("inputPasswordLoginForm"));
    //By btnYallaLoginForm = By.xpath(ConfigReaderLogin.getProperty("btnYallaLoginForm"));
    //By textSuccessLoginPopUp = By.xpath(ConfigReaderLogin.getProperty("textSuccessLoginPopUp"));
}



