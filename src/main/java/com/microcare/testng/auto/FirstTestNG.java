package com.microcare.testng.auto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.microcare.testng.common.Common;

public class FirstTestNG extends Common{
	
	
	@Test(groups="test1")
	public void method1() throws InterruptedException, IOException {
		launch("http://the-internet.herokuapp.com/broken_images");
		screenshot("first.png");
	}
	
	@Test
	public void method3() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href=\"/broken_images\"]")).click();
		Thread.sleep(2000);
	}

}
