package pages;

import manage.WebDriverManage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
