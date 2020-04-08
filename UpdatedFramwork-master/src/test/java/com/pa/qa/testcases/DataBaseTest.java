package com.pa.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pa.qa.base.TestBase;
import com.pa.qa.pages.HomePage;
import com.pa.qa.pages.MyAccountPageRegisterAndLogin;
import com.pa.qa.pages.SingleItemAddPage;
import com.pa.qa.reportlistener.CaptureScreenShot;
import com.pa.qa.reportlistener.Log;
import com.pa.qa.util.*;
import com.relevantcodes.extentreports.LogStatus;

public class DataBaseTest extends Constants {

	HomePage HomePage;
	SingleItemAddPage SingleItemAddPage;
	MyAccountPageRegisterAndLogin MyAccountPageRegisterAndLogin;


	@BeforeMethod
	public void setUp() throws MalformedURLException {

		TestBase.configureDataBase();
		Log.startTestCase(this.getClass().getSimpleName());
		test = extent.startTest(this.getClass().getSimpleName());
	}

	@Test(alwaysRun = true)
	public void DBLogInTest() throws SQLException {
		String userNamedata = DataBaseConnection.getDBLoginData("username");
		String pswdData = DataBaseConnection.getDBLoginData("passwd");
		MyAccountPageRegisterAndLogin = new MyAccountPageRegisterAndLogin();
		MyAccountPageRegisterAndLogin = MyAccountPageRegisterAndLogin.LogIn(userNamedata, pswdData, "", "");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = CaptureScreenShot.captureScreen(driver, this.getClass().getSimpleName());
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		}

		extent.endTest(test);
		Log.endTestCase(this.getClass().getSimpleName());
		driver.quit();

		try {
			connect.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
