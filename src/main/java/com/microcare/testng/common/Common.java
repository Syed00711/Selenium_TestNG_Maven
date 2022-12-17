package com.microcare.testng.common;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;


public class Common {
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest(alwaysRun=true)
	public void setup(String browser) {
if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/sh030348/Downloads/git/BStackDemo/chromedriver");
		driver = new ChromeDriver();
}
else if(browser.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver", "/Users/sh030348/Downloads/geckodriver");
	driver = new FirefoxDriver();
}
else if(browser.equals("safari")) {
	System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
	driver = new SafariDriver();
}
	
		
		
		
	}
	
	public void launch(String URL) {
		driver.get(URL);
	}
	
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot srcfile =(TakesScreenshot)driver;
		File file =srcfile.getScreenshotAs(OutputType.FILE);
		File destFIle =new File(filename);
		Files.copy(file, destFIle);
	}

}
