package com.pa.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest {

	
@Test
 
public void chromeTest() {
		// TODO Auto-generated method stub
DesiredCapabilities dc =DesiredCapabilities.chrome();

URL url = null;
try {
	url = new URL("http://192.168.99.100:4444/wd/hub");
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

RemoteWebDriver driver=new RemoteWebDriver(url, dc);

driver.get("https://www.facebook.com/");

System.out.println(driver.getTitle());

driver.quit();
	}
	
}
