package com.pa.qa.reportlistener;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pa.qa.util.Constants;

public class CaptureScreenShot {

	public static String captureScreen(WebDriver driver, String screenName) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "//TestResults//Test-ScreenShots//" + screenName
				+ Constants.TimeStamp + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static void captureScreenOfAnElement(WebElement we, String name) {

		File src = we.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "//TestResults//Test-ScreenShots//" + name + Constants.TimeStamp
				+ ".png";
		File target = new File(dest);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

//previous code

/*
 * public static String generateFileName(ITestResult result){ Date date = new
 * Date(); String fileName = result.getName()+ "_" + dateFormat.format(date);
 * return fileName;
 * 
 * private static final DateFormat dateFormat = new
 * SimpleDateFormat("yyyy_MM_dd SSS");
 * 
 * }
 */