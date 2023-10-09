package utils;
//creer des methodes qui nous serrons utiles 
// des methodes static qui seront vues dans toutes les autres classes
// appeler les methodes static par la classe elle meme
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
		//remove hardcoded wait time in Base class
		public static final int Implicit_WaitTime=10;
		public static final int pageWaitTime=5;

		//generer un nouveau email à chaque nouvelle execution de test avec le timeStamp
		//utiliser pour débloquer  les tentatives successives de login avec invalid email
		//generate an email with a different prefix+timestamp
		public static String generateTimeStamp() {
			Date date = new Date();
			String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
			return "tester"+timeStamp+"@gmail.com";
			
	//Dans le teardown supprimer l'email créé, pour éviter le surcharge de la base de données		

		}
		//generer two Dimensions Table
		//un fichier execel un workbook
		//lire les donnees a partir d'excel
		
		public static Object[][] getDataFromExcel(String sheetName) throws Exception {
			//XSSFWorkbook workbook = null;
		    File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\testData\\ninjaTestData.xlsx");
		    FileInputStream fis = new FileInputStream(excelFile);
		    @SuppressWarnings("resource")
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheet(sheetName);
		    int rows = sheet.getLastRowNum();
		    System.out.println("-------------------------------------------------------"+rows);
		    int columns = sheet.getRow(0).getLastCellNum();
		    Object[][] data = new Object[rows][columns];

		    for (int i = 0; i < rows; i++) {
		        XSSFRow row = sheet.getRow(i + 1);
		        for (int j = 0; j < columns; j++) {
		            XSSFCell cell = row.getCell(j);
		            if (cell == null) {
		                System.out.println("Cell at row " + row.getRowNum() + " and column " + j + " is null.");
		            } else {
		                CellType cellType = cell.getCellType();
		                switch (cellType) {
		                    case STRING:
		                        data[i][j] = cell.getStringCellValue();
		                        break;
		                    case NUMERIC:
		                        data[i][j] = Integer.toString((int) cell.getNumericCellValue());
		                        break;
		                    case BOOLEAN:
		                        data[i][j] = cell.getBooleanCellValue();
		                        break;
		                    default:
		                    	System.out.println("erreur excel");
		                        break;
		                }
		            }
		        }
		    }
		    return data;
		}

		public static String captureScreenShot (WebDriver driver, String testName) {
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
			try {
				FileHandler.copy(screenshot, new File(destinationScreenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return destinationScreenshotPath;
		}
		
	}

