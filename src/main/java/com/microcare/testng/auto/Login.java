package com.microcare.testng.auto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microcare.testng.common.Common;

public class Login extends Common{
	
	
	@Test(groups="login")
	@Parameters({"username","password"})
	public void checkLogin(String username,String password) throws InterruptedException {
	     driver.get("http://the-internet.herokuapp.com/login");
	     driver.findElement(By.id("username")).sendKeys(username+Keys.TAB);
	     Thread.sleep(2000);
	    
	     driver.findElement(By.id("password")).sendKeys(password+Keys.ENTER);
	    Thread.sleep(2000);
	}
	
	@Test(groups="images")
	public void brokenImages() throws IOException {
		launch("https://the-internet.herokuapp.com/broken_images");
		String width =driver.findElement(By.xpath("//img[@src=\"img/avatar-blank.jpg\"]")).getAttribute("naturalWidth");
		screenshot("brokenigae.png");
		Assert.assertEquals("160", width,"This is a comparision for checking images width");
	}

}
