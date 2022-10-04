package com.GCReddy_v1.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.GCReddy_v1.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rConfig=new ReadConfig();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {
		logger = Logger.getLogger("GCReddy");
		PropertyConfigurator.configure("log4j.properties");
		String browser="chrome";
		if(browser=="FireFox") {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\USER\\eclipse-workspace\\GCReddy_v1\\Drivers\\geckodriver.exe" );
		driver=new FirefoxDriver(); logger.info("Fire fox launched");
		}
		else if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\eclipse-workspace\\GCReddy_v1\\Drivers\\chromedriver.exe" );
			driver=new ChromeDriver(); logger.info("Chrome browser launched");
		}
		else {
			System.setProperty("webdriver.edge.driver","C:\\Users\\USER\\eclipse-workspace\\GCReddy_v1\\Drivers\\msedgedriver.exe" );
			driver=new ChromeDriver(); logger.info("Chrome browser launched");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://gcreddy.com/project/admin/login.php"); 
		logger.info("URL opend");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	public String getURL() {
		return driver.getCurrentUrl();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException   {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String getTitle() {
		return driver.getTitle();
	}

}
