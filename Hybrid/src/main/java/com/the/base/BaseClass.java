package com.the.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.the.utilies.PropertyUtils;


public class BaseClass {

	public static WebDriver driver=null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static Logger log=Logger.getLogger(BaseClass.class);
	
	public static void intialization() throws Exception {
		log.info("initializing a browser"); // appears in console as well as file
		String browserName=PropertyUtils.readProperty("browser");
		if(browserName.equals("chrome")) {
			try {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			}catch(Exception e){
				log.error("chromedriver file is unavailable");
			}
			}
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("file:///D:/selenium%20files/Offline%20Website/index.html");
	}

	public static void reportInit() {
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}

	
}
