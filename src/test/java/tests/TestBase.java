package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    protected static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }


    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserName) { //ça reste optionnel et chrome par défaut
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver(chromeOption());
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "headless-chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }

    @AfterSuite
    public void stopDriver() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

        driver.quit();
    }

    // take screenshot when the test case fail and ad it in the scrennshot folder
    @AfterMethod
    public void screnShotOnfailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("FAILURE");
            System.out.println("Take ScrenShots ...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }


}
