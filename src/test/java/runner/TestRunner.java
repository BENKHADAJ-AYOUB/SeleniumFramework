package runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import tests.TestBase;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue = {"steps"}
)
public class TestRunner extends TestBase {
    ImportToXray importToXray;
    @AfterClass
    public void testXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {
        importToXray = new ImportToXray();
        importToXray.importConfigJson();


    }

}

