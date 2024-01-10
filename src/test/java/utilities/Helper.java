package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    //Méthode to take screenshot when the test case fail
    public static void captureScreenshot(WebDriver driver, String screenshotname) throws IOException {

        // Définir le chemin du fichier de capture d'écran
        Path dest = Paths.get("./Screenshots", screenshotname + ".png");

        // Créer le répertoire parent du fichier s'il n'existe pas
        Files.createDirectories((dest.getParent()));

        try {

            // Créer un flux de sortie pour le fichier de capture d'écran
            FileOutputStream out = new FileOutputStream(dest.toString());//dest.toString() convert path to chaine de caracter

            // Écrire la capture d'écran dans le flux de sortie en octet
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

            // Fermer le flux de sortie
            out.close();

        } catch (IOException e) {
            // Afficher une exception si une erreur se produit
            System.out.println("Exception while taking screenshot: " + e.getMessage());

        }
    }

}
