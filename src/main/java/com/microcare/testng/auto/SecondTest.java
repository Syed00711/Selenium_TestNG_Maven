package com.microcare.testng.auto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.microcare.testng.common.Common;

public class SecondTest extends Common{
	
	@Test(groups="test1")
	public void method2() throws IOException {
		System.out.println(driver.getCurrentUrl());
		screenshot("second.png");
		//System.out.println(driver.findElement(By.xpath("//div[@class=\"example\"]/h3")).getText());
	}

}
