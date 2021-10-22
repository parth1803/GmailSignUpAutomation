package testcase;

import TestUtil.*;
import base.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;

public class Gmail_SIgnUpPageTests extends TestBase{

    public Gmail_SignUp_PageLocator objSignUpPage;

    @BeforeTest
    public void initialBrowserDriver() {
        driver = TestBase.testBase();
    }

    @Test()
    public void SignUpForm(){
        try {
            objSignUpPage = new Gmail_SignUp_PageLocator(driver);
           objSignUpPage.SignUp("parth","patel","pp7420627@gmail.com","parth@183","parth@183", "1234567890", "March", "18", "1995", "Male" );

            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
