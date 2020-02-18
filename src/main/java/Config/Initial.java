package Config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Initial {

    public static WebDriver driver;
    public static WebDriverWait gWait;
    public static JavascriptExecutor js;

    public static void invokeBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        gWait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;

    }
}
