package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReaderData {
    //permet de lire des données sous forme d'octets bruts à partir d'un fichier. Elle est utilisée pour lire des fichiers binaires,
    // tels que des images, des vidéos ou des archives ZIP. Pour lire des fichiers texte
    static FileInputStream fis = null ;

    public FileInputStream getFileInputStream()
    {
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";

		/*La classe File est une classe Java qui représente un fichier ou un répertoire sur le système de fichiers.
		Elle fournit des méthodes pour accéder aux propriétés d'un fichier ou d'un répertoire,
		et pour effectuer des opérations sur eux, telles que la création, la lecture, l'écriture et la suppression.*/
        File srcFile = new File(filePath);

        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
            System.exit(0);
        }
        return fis ;
    }
    //Creation d'un objet tableau pour mettre dedans les lignes et colones Des element de notre excel
    public Object[][] getExcelData() throws IOException
    {
        fis = getFileInputStream();
        //XSSFWorkbook : fichier excel
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //return le premier shets (indice=0)
        XSSFSheet sheet = wb.getSheetAt(0);
        //+1 car àa commence de 0 jusqu'a row-1 donc nombre total des ligne sera last ligne +1
        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNumberOfCols = 4 ;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ;

        for (int i = 0; i < TotalNumberOfRows; i++)
        {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }

}

