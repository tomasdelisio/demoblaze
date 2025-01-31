package test_register;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import data.Data;
import driver.Driver;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;
import report.Report;

public class Register {
	/*** DRIVER ***/
	private WebDriver driver = null;

	/*** PAGES ***/
	private BasePage basePage = null;
	private RegisterPage registerPage = null;
	private LoginPage loginPage = null;

	/*** VARIABLES ***/
	private static final String URL = "https://www.demoblaze.com/index.html";

	/*** REPORTS ***/
	private ExtentReports report = null;

	/*** METHODS ***/
	// Pre-Config
	@BeforeMethod
	public void configurateTest() {
		driver = Driver.configurate();

		report = Report.configurate();

		basePage = new BasePage(driver);
		basePage.navigateTo(URL);

		registerPage = new RegisterPage();
		loginPage = new LoginPage();
	}

	// Tests
	@Test(dataProvider = "Register", dataProviderClass = Data.class, priority = 1)
	public void register(String usr, String pass) {
		ExtentTest test = report.createTest("Register Test");
		String message = null;
		String alert = null;

		test.log(Status.INFO, "REGISTER TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsr(usr);
		test.pass("User completed username");

		registerPage.completePass(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {
			message = registerPage.getRegisterMsg();
			alert = registerPage.getAlertTxt();			
			test.pass("Alert content saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");
			
			assertEquals(registerPage.getUsrFldContent(), usr);
			assertEquals(registerPage.getPassFldContent(), pass);
			assertEquals(message, alert);
			assertTrue(loginPage.isLoginBtnVisible());
		
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER TEST COMPLETED SUCCESSFULLY***\n");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER TEST COMPLETED UNSUCCESSFULLY***\n");

		}

	}

	@Test(dataProvider = "RegisterUsernameExistent", dataProviderClass = Data.class, priority = 2)
	public void registerUsrExistent(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username Existent Test");
		String error = null;
		String alert = null;
		
		test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER USERNAME EXISTENT TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsr(usr);
		test.pass("User completed username");

		registerPage.completePass(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {
			error = registerPage.getUsrAlreadyExistError();
			alert = registerPage.getAlertTxt();
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals(registerPage.getUsrFldContent(), usr);
			assertEquals(registerPage.getPassFldContent(), pass);
			assertEquals(error, alert);
			
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER USERNAME EXISTENT TEST COMPLETED SUCCESSFULLY***\n");
			
		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER USERNAME EXISTENT TEST COMPLETED UNSUCCESSFULLY***\n");
		}

	}
	
	@Test(dataProvider = "RegisterUsernameOrPasswordNull", dataProviderClass = Data.class, priority = 3)
	public void registerUsrOrPassNull(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username/Password Null Test");
		String error = null;
		String alert = null;

		test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsr(usr);
		test.pass("User completed username");

		registerPage.completePass(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {
			error = registerPage.getNullFldError();
			alert = registerPage.getAlertTxt();
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals(registerPage.getUsrFldContent(), usr);
			assertEquals(registerPage.getPassFldContent(), pass);
			assertEquals(error, alert);
			
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY***\n");
			
		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY***\n");
		}

	}
	
	@Test(priority = 4)
	public void registerNull() {
		ExtentTest test = report.createTest("Register Null Test");
		String error = null;
		String alert = null;
		
		test.log(Status.INFO, "REGISTER NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER NULL TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Not Completed");

		try {
			error = registerPage.getNullFldError();
			alert = registerPage.getAlertTxt();
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertNull(registerPage.getUsrFldContent());
			assertNull(registerPage.getPassFldContent());
			assertEquals(error, alert);
			
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER NULL TEST COMPLETED SUCCESSFULLY***\n");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER NULL TEST COMPLETED UNSUCCESSFULLY***\n");
		}

	}

	// Post-Config
	@AfterMethod
	public void finishTest() {
		report.flush();

		Driver.finish();
	}
}
