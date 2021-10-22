package pages;

import TestUtil.CheckBox;
import TestUtil.GenericUtil;
import TestUtil.HighlightElement;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Gmail_SignUp_PageLocator extends TestBase {

    public static WebDriverWait wait;
    public static GenericUtil genericUtil;
    public static CheckBox objCheckBox;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement FirstName;
    @FindBy(xpath = "//span[contains(text(),'Create your Google Account')]")
    public WebElement FormHeading;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='Username']")
    public WebElement UserName;

    @FindBy(xpath = "//input[@name='Passwd']")
    public WebElement Password;

    @FindBy(xpath = "//input[@name='ConfirmPasswd']")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement ShowPassword;

    @FindBy(xpath = "//*[@id=\"accountDetailsNext\"]/div/button/div[2]")
    public WebElement Nextbutton;

    @FindBy(xpath = "//span[contains(text(),'parth, welcome to Google')]")
    public WebElement SecondPageHeader;

    @FindBy(xpath = "//input[@id='phoneNumberId']")
    public WebElement PhoneNo;

    @FindBy(xpath = "//select[@id='month']")
    public WebElement Month;

    @FindBy(xpath = "//input[@id='day']")
    public WebElement Day;

    @FindBy(xpath = "//input[@id='year']")
    public WebElement Year;

    @FindBy(xpath = "//select[@id='gender']")
    public WebElement Gender;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")
    public WebElement SecondPageNextbutton;

    public Gmail_SignUp_PageLocator(WebDriver driver) {
        TestBase.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
    }

    /**
     *
     * @param txtfirstname
     * @param txtlastname
     * @param txtusername
     * @param txtPassword
     * @param txtconfirmpassword
     * @param Phone
     * @param txtmonth
     * @param txtday
     * @param txtyear
     * @param txtgender
     */



    public void SignUp(String txtfirstname, String txtlastname, String txtusername, String txtPassword, String txtconfirmpassword,String Phone, String txtmonth, String txtday, String txtyear, String txtgender ) {

        genericUtil = new GenericUtil();
        try {
//            wait.until(ExpectedConditions.visibilityOf(FormHeading));
            HighlightElement.highlightElement(FormHeading);
            genericUtil.click(FormHeading);

            HighlightElement.highlightElement(FirstName);
            genericUtil.writeTextWithPause(FirstName,txtfirstname,500);

            HighlightElement.highlightElement(LastName);
            genericUtil.writeTextWithPause(LastName,txtlastname,500);

            HighlightElement.highlightElement(UserName);
            genericUtil.writeTextWithPause(UserName,txtusername,500);

            HighlightElement.highlightElement(Password);
            genericUtil.writeTextWithPause(Password,txtPassword,500);

            HighlightElement.highlightElement(ConfirmPassword);
            genericUtil.writeTextWithPause(ConfirmPassword,txtconfirmpassword,500);


            try {
                objCheckBox = new CheckBox();
                HighlightElement.highlightElement(ShowPassword);
                objCheckBox.Select_The_Checkbox(ShowPassword);
                genericUtil.pause(1200);
                HighlightElement.highlightElement(ShowPassword);
                objCheckBox.DeSelect_The_Checkbox(ShowPassword);
                genericUtil.pause(1200);

            } catch (Exception e) {
                e.printStackTrace();
            }
            HighlightElement.highlightElement(Nextbutton);
            genericUtil.clearWithPause(Nextbutton,1000);

            /**  Second Page */

            HighlightElement.highlightElement(SecondPageHeader);
            genericUtil.clearWithPause(SecondPageHeader,1000);

            HighlightElement.highlightElement(PhoneNo);
            genericUtil.writeTextWithPause(PhoneNo,Phone,1000);

            HighlightElement.highlightElement(Month);
            Select month = new Select(Month);
            month.selectByVisibleText(txtmonth);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(Day);
            genericUtil.writeTextWithPause(Day,txtday,1000);

            HighlightElement.highlightElement(Year);
            genericUtil.writeTextWithPause(Year,txtyear,1000);


            HighlightElement.highlightElement(Gender);
            Select gender = new Select(Gender);
            gender.selectByVisibleText(txtgender);
            genericUtil.pause(1000);

            HighlightElement.highlightElement(SecondPageNextbutton);
            genericUtil.clickWithPause(SecondPageNextbutton,1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
