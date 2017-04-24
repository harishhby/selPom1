package com.unisys.pom.testcases.base;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.unisys.pom.util.Constants;
import com.unisys.pom.util.ExtentManager;
import com.unisys.pom.util.Xls_Reader;

public class BaseTest {
	public WebDriver driver;
	public ExtentReports extent=ExtentManager.getInstance();
	public ExtentTest test;
	public Xls_Reader xls=new Xls_Reader(Constants.DATA_XLS_PATH);


	public void init(String bType)
	{
		if(!Constants.GRID_RUN)
		{
			//local machine
			if(bType.equalsIgnoreCase("Chrome"))
			{
				//test.log(LogStatus.INFO, "Opening a browser - "+bType);
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
				driver=new ChromeDriver();

			}
			else if(bType.equalsIgnoreCase("Mozilla"))
			{
				System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
				driver=new FirefoxDriver();
			}
		}
		else{
			// grid
			try{
			 InetAddress iAddress = InetAddress.getLocalHost();
			  String currentIp = iAddress.getHostAddress();
			  System.out.println(currentIp);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			
			DesiredCapabilities cap=null;
			if(bType.equals("Mozilla")){
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.ANY);
				
			}else if(bType.equals("Chrome")){
				 cap = DesiredCapabilities.chrome();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.ANY);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://currentIp:4444/wd/hub"), cap);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser opened Successfully - "+bType);
	}
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=Constants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
}
