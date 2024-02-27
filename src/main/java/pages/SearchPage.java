package pages;

import manage.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties_data.ConfigReaderLogin;
import providers.User;
import providers.UserDtoLombok;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class SearchPage extends PageBase {

    public SearchPage() {

        PageFactory.initElements(WebDriverManage.getDriver(), this);
    }


    //@FindBy(xpath = "//a[@id='0']")
    @FindBy(xpath = "//h1[@class='title']")
    WebElement textSearchTitle;


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

    // *******************  search a car

    @FindBy(id = "city")
    WebElement cityID;

    @FindBy(css = "div.pac-item")
    WebElement pacitem;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitCity;

    @FindBy(id ="dates")
    WebElement dates;

    @FindBy(xpath="//button[@aria-label='Next month']")
    WebElement nextMonth;

    @FindBy(css =  "a.car-container")
    WebElement carContainer;

    @FindBy(css = ".header a.logo")
    WebElement headerLogo;

    //By btnLogout = By.xpath(ConfigReader.getProperty("btnLogout"));
// check that search page appears correctly:
    public String getPageTitle() {
        return textSearchTitle.getText();
        //Find your car now!
    }

    public boolean isTitleSearchPageContain() {

        System.out.println("SearchPageAppearsCorrect");
        return isTextContains(textSearchTitle, "Find your car now!", 10);

    }

// search methods without login:
    //driver + extends Pagebase methods
    //1.fillSearchForm(String city, String dateFrom, String dateTo)
    //2 selectPeriodYears(dateFrom, dateTo)
        public void fillSearchForm(String city, String dateFrom, String dateTo) {
            typeCity(city);
//        selectPeriod(dateFrom, dateTo);
//        selectPeriodYears(dateFrom, dateTo);
//        selectPeriodMonths(dateFrom, dateTo);
            selectPeriodYears(dateFrom, dateTo);
        }

    private void typeCity(String city) {
        // type(By.id("city"),city); pause(500);
        sendTextBase(cityID, 1000, city);
        //click(By.cssSelector("div.pac-item"));
        clickBase(pacitem, 1000);

    }
        public void submitForm() {
        clickBase(submitCity,2000);

        }

        private void selectPeriodYears(String dateFrom, String dateTo) {

            LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            LocalDate endDate = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            LocalDate nowDate = LocalDate.now();
            String locatorStart = String.format("//div[.=' %s ']", startDate.getDayOfMonth());
            String locatorEnd = String.format("//div[.=' %s ']", endDate.getDayOfMonth());

           clickBase(dates,3000);
            //                    01.01.2024            10.01.2023
            int startToEndMonth = startDate.getYear() - nowDate.getYear() == 0 ?
                    startDate.getMonthValue() - nowDate.getMonthValue() :
                    12 - nowDate.getMonthValue() + startDate.getMonthValue();
            for (int i = 0; i < startToEndMonth; i++) {
                clickBase(nextMonth, 3000);
            }
            click(By.xpath(locatorStart));

            startToEndMonth = endDate.getYear() - startDate.getYear() == 0 ?
                    endDate.getMonthValue() - startDate.getMonthValue() :
                    12 - startDate.getMonthValue() + endDate.getMonthValue()
            ;
            for (int i = 0; i < startToEndMonth; i++) {
                click(By.xpath(("//button[@aria-label='Next month']")));
            }
            click(By.xpath(locatorEnd));

        }



    //*******************    to find the current dates  ********************
    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

        typeCity(city);
       // click(By.id("dates"));
        clickBase(dates, 3000);
        //   "10/25/2022"
        // "aaa/fff/r"   ["aaa"] ["fff"] ["r"]
        String[] from =dataFrom.split("/");  /// ["10"] ["25"] ["2022"]  from[1] ="25"

        // String locator1 ="//div[text()=' 25 ']";
        String locator = "//div[text()=' "+from[1]+" ']";

        ///  "how are you, Dolli?"      names [Dolli] [Molli] [lis]
        //  "how are you, "+names[2]+"?"      how are you, lis?

        click(By.xpath(locator));


        // "10/30/2022"
        String [] to = dataTo.split("/");   /// to[1]
        String locator2 = "//div[text()=' "+to[1]+" ']";

        click(By.xpath(locator2));

    }
    public void searchCurrentMonth2(String city, String dataFrom, String dataTo) {

        typeCity(city);
        clearTextBoxDates();
        click(By.id("dates"));

        String[] from =dataFrom.split("/");


        //String locator = "//div[text()=' "+from[1]+" ']";
        String locator = String.format("//div[text()=' %s ']",from[1]) ;
        click(By.xpath(locator));


        String [] to = dataTo.split("/");

        String locator2 =  String.format("//div[text()=' %s ']",to[1]);

        click(By.xpath(locator2));

    }

    public void searchNextMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBoxDates();
        //click(By.id("dates"));
        clickBase(dates, 3000);
        //click(By.cssSelector("button[aria-label='Next month']"));
        clickBase(nextMonth,3000);

        //  "11/25/2022","11/30/2022"

        //div[text()=' 25 ']
        String [] from = dataFrom.split("/"); // ["11"] ["25"] ["2022"] from[1] = "25"

        String locator = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));

        String [] to =dataTo.split("/");
        String locator1 =String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator1));

    }

    public boolean isListOfCarsAppeared() {
        return isElementDisplayed(carContainer,3000);
                //(By.cssSelector("a.car-container"));
    }

    public void selectAnyPeriod(String city, String dataFrom, String dataTo) {
        // "11/10/2022"                   "6/10/2023"
        typeCity(city);
        clearTextBoxDates();
        click(By.id("dates"));
        //String  nowData = "10/20/2022";
        LocalDate now = LocalDate.now();
        LocalDate from=LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));


      //  logger.info("year --> " +now.getYear() );
       // logger.info("Day  of Month -->" +now.getDayOfMonth() );
       // logger.info("Month value -->" +now.getMonthValue() );

//        String [] from = dataFrom.split("/");//  from[2] = "2022";
//        int diffYear = Integer.parseInt(from[2]) -now.getYear();


        int diffYear;
        int diffMonth;
        diffYear = from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth= from.getMonthValue()-now.getMonthValue(); //11-10 = 1
        }else {
            diffMonth=12-now.getMonthValue()+from.getMonthValue();// 12-10+3 = 5
        }

        clickNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        ///****************
        diffYear = to.getYear()-from.getYear();
        if (diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        }else {
            diffMonth = 12-from.getMonthValue()+ to.getMonthValue();
        }
        clickNextMonth(diffMonth);
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));

    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }

    public boolean isDataCorrect(String from, String to) {
        WebElement element= WebDriverManage.getDriver().findElement(By.cssSelector("input[aria-haspopup='dialog']"));
        System.out.println(element.getText());
        return true;

    }

    public void typePeriodInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBoxDates();
        typePeriod(dataFrom,dataTo);
    }

    private void typePeriod(String dataFrom, String dataTo) {  // 9/25/2022 - 10/26/2022
       // type(By.id("dates"),dataFrom + " - "+dataTo);
        sendTextBase(dates, 3000, dataFrom + " - " + dataTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public void clickLogo() {
        //click(By.cssSelector(".header a.logo"));
        clickBase(headerLogo, 3000);
    }

    public void clearTextBoxDates(){
        WebElement  el = WebDriverManage.getDriver().findElement(By.id("dates"));
        String osName = System.getProperty("os.name");
        System.out.println(osName);   /// Mac OS X
        if(osName.startsWith("Mac")){
           // logger.info("OS is --->" +osName);
            // Command +a
            el.sendKeys(Keys.COMMAND,"a");
        }else {
          //  logger.info("OS is --->" +osName);
            el.sendKeys(Keys.CONTROL,"a");
            //  Cntr +a
        }
        el.sendKeys(Keys.DELETE);
    }


//*****************    login and logout ***********************

    public void loginUserDtoLombok(UserDtoLombok user) {
        System.out.println(user.getEmail());
        clickBase(btnLoginNavigatorMenu, 30);
        sendTextBase(inputEmailLoginForm, 30, user.getEmail());
        sendTextBase(inputPasswordLoginForm, 30, user.getPassword());
        clickBase(btnYallaLoginForm, 10);


    }

    public void popUpOK() {
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
        clickBase(btnLoginNavigatorMenu, 30);
        sendTextBase(inputEmailLoginForm, 30, userPropertyFile.getEmail());
        sendTextBase(inputPasswordLoginForm, 30, userPropertyFile.getPassword());
        clickBase(btnYallaLoginForm, 10);


    }

    public SearchPage logoutIfDisplayed() {
        if (isElementDisplayed(btnLogout, 30)) {
            System.out.println("Login is active. Do logout");
            btnLogout.click();
        }
        System.out.println("Logout is not necessary");
        return new SearchPage();
    }
}


