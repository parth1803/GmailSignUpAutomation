package base;

import TestUtil.Constants;
import TestUtil.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static WebDriverWait wait;
    public static int waitTime = 10;

    public static WebDriver testBase() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, waitTime);

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        e_driver.manage().window().maximize();
        e_driver.get(Constants.BASEURL);

        return driver;
    }
//
//    public static void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
