package test_register;

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
import utils.Messages;
import utils.MessagesLogin;
import utils.MessagesRegister;

public class Register {
	/*** VARIABLES ***/
	// Driver
	private WebDriver driver = null;

	// Pages
	private BasePage basePage = null;
	private RegisterPage registerPage = null;
	private LoginPage loginPage = null;

	// URL
	private static final String URL = "https://www.demoblaze.com/index.html";
	
	// Messages Register
	private final String REGISTER_TEST_START = MessagesRegister.REGISTER_TEST_START.getMessage();
	private final String REGISTER = MessagesRegister.REGISTER.getMessage(); 
	private final String REGISTER_COMPLETED = MessagesRegister.REGISTER_COMPLETED.getMessage();
	private final String VALIDATE_REGISTER = MessagesRegister.VALIDATE_REGISTER.getMessage();
	private final String REGISTER_OK = MessagesRegister.REGISTER_OK.getMessage();
	private final String REGISTER_TEST_OK = MessagesRegister.REGISTER_TEST_OK.getMessage();
	private final String REGISTER_TEST_ERROR = MessagesRegister.REGISTER_TEST_ERROR.getMessage();
	private final String REGISTER_TEST_FINISH = MessagesRegister.REGISTER_TEST_FINISH.getMessage();
	
	// Messages Login
	private final String LOGIN_BTN_SAVED = MessagesLogin.LOGIN_BTN_SAVED.getMessage();
	private final String LOGIN_BTN_VISIBLE = MessagesLogin.LOGIN_BTN_VISIBLE.getMessage();
	private final String LOGIN_BTN_NOT_VISIBLE = MessagesLogin.LOGIN_BTN_NOT_VISIBLE.getMessage();
	
	// Messages
	private final String USR_COMPLETED = Messages.USR_COMPLETED.getMessage();
	private final String PASS_COMPLETED = Messages.PASS_COMPLETED.getMessage();
	private final String ALERT_TXT_SAVED = Messages.ALERT_TXT_SAVED.getMessage();
	private final String USR_MATCH = Messages.USR_MATCH.getMessage();
	private final String PASS_MATCH = Messages.PASS_MATCH.getMessage();
	private final String ALERT_TXT_MATCH = Messages.ALERT_TXT_MATCH.getMessage();
	private final String ALERT_ACCEPTED = Messages.ALERT_ACCEPTED.getMessage();
	private final String USR_MISMATCH = Messages.USR_MISMATCH.getMessage();
	private final String PASS_MISMATCH = Messages.PASS_MISMATCH.getMessage();
	private final String ALERT_TXT_MISMATCH = Messages.ALERT_TXT_MISMATCH.getMessage();
	private final String USR_EXIST = Messages.USR_EXIST.getMessage();
	private final String USR_PASS_NULL = Messages.USR_PASS_NULL.getMessage();
		
	// Messages Assertion
	private final String HANDLE_ASSERTION_ERROR = Messages.HANDLE_ASSERTION_ERROR.getMessage();
		
	// Data
	private String usrActual = null;
	private String passActual = null;
	private Boolean isLoginBtnActualVisible = null;
	private String alertTxtActual = null;

	// Reports
	private ExtentReports report = null;

	/*** METHODS ***/
	// Test Pre-Config
	@BeforeMethod
	public void configurateTest() {
		driver = Driver.configurate();

		report = Report.configurate();

		basePage = new BasePage(driver);
		basePage.navigateTo(URL);

		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		
	}
	
	// Testing Methods
	private void startTest(ExtentTest test, String usr) {
		test.log(Status.INFO, REGISTER_TEST_START + "\nUsuario: " + usr);
		System.out.println(REGISTER_TEST_START + "\nUsuario: " + usr + "\n");
			
	}
		
	private void finishTest(ExtentTest test, String usr) {
		test.log(Status.INFO, REGISTER_TEST_FINISH + "\nUsuario: " + usr);
		System.out.println(REGISTER_TEST_FINISH + "\nUsuario: " + usr + "\n");
			
	}
	
	private void register(ExtentTest test, String usr, String pass) {
		test.log(Status.INFO, REGISTER);
		
		registerPage.clickRegisterBtn();
		
		registerPage.completeUsr(usr);
		usrActual = registerPage.getUsrFldContent();
		test.log(Status.INFO, USR_COMPLETED);
		
		registerPage.completePass(pass);
		passActual = registerPage.getPassFldContent();
		test.log(Status.INFO, PASS_COMPLETED);
		
		registerPage.clickRegisterBtn2();
		
		alertTxtActual = registerPage.getAlertTxt();
		test.log(Status.INFO, ALERT_TXT_SAVED);

		registerPage.acceptAlert();
		test.log(Status.INFO, ALERT_ACCEPTED);
		
		isLoginBtnActualVisible = loginPage.isLoginBtnVisible();
		test.log(Status.INFO, LOGIN_BTN_SAVED);
		
		test.log(Status.INFO, REGISTER_COMPLETED);
		
	}
		
	private void validateRegister(ExtentTest test, String usr, String pass, String msg) {
		test.log(Status.INFO, VALIDATE_REGISTER);
		
		assertEquals(usrActual, usr, USR_MISMATCH);
		test.pass(USR_MATCH);
		
		assertEquals(passActual, pass, PASS_MISMATCH);
		test.pass(PASS_MATCH);
		
		assertEquals(alertTxtActual, msg, ALERT_TXT_MISMATCH);
		test.pass(ALERT_TXT_MATCH);
		
		assertTrue(isLoginBtnActualVisible, LOGIN_BTN_NOT_VISIBLE);
		test.pass(LOGIN_BTN_VISIBLE);
				
		test.pass(REGISTER_TEST_OK);
		System.out.println(REGISTER_TEST_OK + "\nUsuario: " + usr + "\n");
		
	}
	
	private void handleAssertionError(ExtentTest test, String usr, AssertionError e) {
		test.log(Status.INFO, HANDLE_ASSERTION_ERROR);
		
		test.addScreenCaptureFromPath("screenshot.png");
		
		test.fail(REGISTER_TEST_ERROR + "." + "\nUsuario: " + usr + " \nERROR: " + e.getMessage());
		System.out.println(REGISTER_TEST_ERROR + "\nUsuario: " + usr + " \nERROR: " + e.getMessage() + "\n");
		
	}

	// Tests
	@Test(dataProvider = "Register", dataProviderClass = Data.class, priority = 1)
	public void registerOK(String usr, String pass) {
		ExtentTest test = report.createTest("Register Test");
		
		startTest(test, usr);
		
		register(test, usr, pass);

		try {
			validateRegister(test, usr, pass, REGISTER_OK);

		} catch (AssertionError e) {
			handleAssertionError(test, usr, e);
			
		} finally {
			finishTest(test, usr);
			
		}

	}

	@Test(dataProvider = "RegisterUsernameExistent", dataProviderClass = Data.class, priority = 2)
	public void registerUsrExistent(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username Existent Test");
		
		startTest(test, usr);
		
		register(test, usr, pass);

		try {
			validateRegister(test, usr, pass, USR_EXIST);

		} catch (AssertionError e) {
			handleAssertionError(test, usr, e);
			
		} finally {
			finishTest(test, usr);
			
		}

	}
	
	@Test(dataProvider = "RegisterUsernameOrPasswordNull", dataProviderClass = Data.class, priority = 3)
	public void registerUsrOrPassNull(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username Or Password Null Test");
		
		startTest(test, usr);
		
		register(test, usr, pass);

		try {
			validateRegister(test, usr, pass, USR_PASS_NULL);

		} catch (AssertionError e) {
			handleAssertionError(test, usr, e);
			
		} finally {
			finishTest(test, usr);
			
		}

	}
	
	@Test(dataProvider = "RegisterUsernameAndPasswordNull", dataProviderClass = Data.class, priority = 4)
	public void registerUsrAndPassNull(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username And Password Null Test");
		startTest(test, usr);
		
		register(test, usr, pass);

		try {
			validateRegister(test, usr, pass, USR_PASS_NULL);

		} catch (AssertionError e) {
			handleAssertionError(test, usr, e);
			
		} finally {
			finishTest(test, usr);
			
		}
	}

	// Test Post-Config
	@AfterMethod
	public void finishTest() {
		report.flush();

		Driver.finish();
		
	}
}
