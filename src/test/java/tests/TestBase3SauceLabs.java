package tests;

import data.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase3SauceLabs {
    //Sauce Labs configuration
    public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("userName");
    public static final String ACCESKEY = LoadProperties.sauceLabsData.getProperty("accesKey");
    public static final String URLSAUCE = "https://"+USERNAME+":"+ACCESKEY+LoadProperties.sauceLabsData.getProperty("seleniumUrl");
    public static String baseUrl="https://demo.nopcommerce.com/";
    //ThreadLocal ça permet d'ouvrir plusieurs thread
    protected ThreadLocal<RemoteWebDriver> driver =null;
   /* En utilisant ThreadLocal<RemoteWebDriver>, vous vous assurez que chaque thread exécutant un test a sa propre instance de RemoteWebDriver, isolée des autres. Cela est crucial pour l'exécution de tests en parallèle
    car cela évite les interférences et les conditions de course entre les threads.*/
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser)throws MalformedURLException {
        driver = new ThreadLocal<>();
        //DesiredCapabilities est utilisé pour définir les propriétés du navigateur désiré.
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",browser);

        //
        driver.set(new RemoteWebDriver(new URL(URLSAUCE),caps));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        getDriver().navigate().to(baseUrl);
    }
    //Cette méthode renvoie l'instance actuelle de WebDriver pour le thread en cours.
    public WebDriver getDriver()
    {
        return this.driver.get();

    }
    @AfterClass
    public void stopDriver() {
        getDriver().quit();
        //dellete threads
        driver.remove();
    }
    @AfterMethod
    public void screnShotOnfailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("FAILURE");
            System.out.println("Take ScrenShots ...");
            Helper.captureScreenshot(getDriver(), result.getName());
        }
    }
}
