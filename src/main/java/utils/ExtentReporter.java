package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Pour générer des rapports
public class ExtentReporter {
	//creer la methode generateExtentReports et le configurer 
	public static ExtentReports generateExtentReport() throws Exception {
		ExtentReports extentReports = new ExtentReports();
		// utiliser la classe file pour manipuler le rapport genere (on pet le chemin du
		// rapport qu'on va generer)
		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReports.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		// on va personnaliser notre rapporteur :le theme
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("OpenCart Happy Path Report");
		sparkReporter.config().setTimeStampFormat("dd-mm-yyyy HH:MM:SS");
		sparkReporter.config().setDocumentTitle("Framework automatisation Tests");
		// on attache le spaRepoter a notre rapport qui va etre retourne extentReporter
		// on peut aussi personnaliser l'environnement , le browser, ..
		extentReports.attachReporter(sparkReporter);
		// creer un objet de type properties pour ajouter les infos utiles (url,
		// tests,browsers)
		Properties prop=new Properties();
		File propFile = new File (System.getProperty("user.dir")+"//src//main//java//listeners//config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		extentReports.setSystemInfo("Url de lapplication",prop.getProperty("qaUrl"));
		extentReports.setSystemInfo("Browserutilise pour les tests",prop.getProperty("BrowserName"));
		extentReports.setSystemInfo("Operating sys",prop.getProperty("os.name"));
		extentReports.setSystemInfo("realisateur de framework",prop.getProperty("user.name"));
		extentReports.setSystemInfo("version de jave",prop.getProperty("java.version"));
		System.getProperties();
		return extentReports;
	}
}
