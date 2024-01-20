package tests;

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

public class TestBase2SeleniumGrid {
    public static String baseUrl="https://demo.nopcommerce.com/";
    //RemoteWebDriverpr acceder au gride
    //ThreadLocal ça permet d'ouvrir plusieurs thread
    protected ThreadLocal<RemoteWebDriver> driver =null;
   /* En utilisant ThreadLocal<RemoteWebDriver>, vous vous assurez que chaque thread exécutant un test a sa propre instance de RemoteWebDriver, isolée des autres. Cela est crucial pour l'exécution de tests en parallèle
    car cela évite les interférences et les conditions de course entre les threads.*/
    @BeforeClass
    @Parameters(value = {"browser", "nodeUrl"})
    public void setUp(@Optional("chrome") String browser,@Optional("http://localhost:4444") String nodeUrl) throws MalformedURLException {
        driver = new ThreadLocal<>();
        //DesiredCapabilities est utilisé pour définir les propriétés du navigateur désiré.
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",browser);
        //new RemoteWebDriver(new URL("http://localhost:4444"), caps) crée une instance
        // de RemoteWebDriver pour interagir avec Selenium Grid.
        driver.set(new RemoteWebDriver(new URL(nodeUrl),caps));
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
