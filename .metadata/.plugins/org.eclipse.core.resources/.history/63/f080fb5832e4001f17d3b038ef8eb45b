package pages;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	/*** LOCATORS ***/
	@FindBy(id = "login2")
	private WebElement login_btn;
	@FindBy(id = "loginusername")
	private WebElement usr_fld;
	@FindBy(id = "loginpassword")
	private WebElement pass_fld;
	@FindBy(xpath = "//button[@onclick=\"logIn()\"]")
	private WebElement login_btn_2;
	@FindBy(id = "nameofuser")
	private WebElement welcome_txt;
	
	/*** ATTRIBUTES ***/
	private static final String value = "value";

	/*** VARIABLES ***/
	private boolean isVisible = false;
	private String alert_text = null;
	private String welcome_text = null;
	private String welcome_usr_txt = null;
	private String usr_content = null;
	private String pass_content = null;
	private static final String login_btn_id = "Login Button";
	private static final String usr_fld_id = "User Field";
	private static final String pass_fld_id = "Password Field";
	private static final String login_btn_2_id = "Login Button 2";
	private static final String welcome_txt_id = "'WELCOME' Text";
	private static final String alert_id = "Alert";
	
	/*** ERROR ***/
	private final String usr_does_not_exist_error = "User does not exist.";
	private final String wrong_pass_error = "Wrong password.";
	private final String null_fld_error = "Please fill out Username and Password.";

	/*** CONSTRUCTOR ***/
	public LoginPage() {
		super(driver);
	}

	/*** METHODS ***/

	// Login
	public void clickLoginBtn() {
		click(login_btn, login_btn_id);
	}

	public void completeUsr(String usr) {
		type(usr, usr_fld, usr_fld_id);
	}

	public void completePass(String pass) {
		type(pass, pass_fld, pass_fld_id);
	}

	public void clickLoginBtn2() {
		click(login_btn_2, login_btn_2_id);
	}

	// Alerts
	public void acceptAlert() {
		acceptAlert(alert_id);
	}

	public void cancelAlert() {
		cancelAlert(alert_id);
	}

	public String getAlertTxt() {
		alert_text = getAlertText(alert_id);
		
		return alert_text;
	}

	// Visible
	public boolean isLoginBtnVisible() {
		if (elementVisible(login_btn, login_btn_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isUsrFldVisible() {
		if (elementVisible(usr_fld, usr_fld_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isPassFldVisible() {
		if (elementVisible(pass_fld, pass_fld_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isLoginBtn2Visible() {
		if (elementVisible(login_btn_2, login_btn_2_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isWelcomeTxtVisible() {
		if (elementVisible(welcome_txt, welcome_txt_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}
	
	// Getter and Setter
	public WebElement getLogin_btn() {
		return login_btn;
	}

	public void setLogin_btn(WebElement login_btn) {
		this.login_btn = login_btn;
	}
	
	public WebElement getUsr_fld() {
		return usr_fld;
	}
	
	public String getUsrFldContent() {
		usr_content = getAttribute(usr_fld, value);
		System.out.println("Contenido usuario: " + usr_content);
		return usr_content;
	}
	
	public void setUsr_fld(WebElement usr_fld) {
		this.usr_fld = usr_fld;
	}
	
	public WebElement getPass_fld() {
		return pass_fld;
	}
	
	public void setPass_fld(WebElement pass_fld) {
		this.pass_fld = pass_fld;
	}
	
	public WebElement getLogin_btn_2() {
		return login_btn_2;
	}

	public void setLogin_btn_2(WebElement login_btn_2) {
		this.login_btn_2 = login_btn_2;
	}

	public WebElement getWelcome_txt() {
		return welcome_txt;
	}
	
	public String getWelcomeTxt() {
		welcome_text = getText(welcome_txt, welcome_txt_id);
		
		return welcome_text;
	}
	
	public String getUsrOfWelcomeTxt() {
		String text = getWelcomeTxt();
		
		welcome_usr_txt = text.substring(text.indexOf(" ") + 1);
		
		return welcome_usr_txt;
	}

	public void setWelcome_txt(WebElement welcome_txt) {
		this.welcome_txt = welcome_txt;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getAlert_text() {
		return alert_text;
	}

	public void setAlert_text(String alert_text) {
		this.alert_text = alert_text;
	}

	public static String getLoginBtnId() {
		return login_btn_id;
	}

	public static String getUsrFldId() {
		return usr_fld_id;
	}

	public static String getPassFldId() {
		return pass_fld_id;
	}
	
	public String getPassFldContent() {
		pass_content = getAttribute(pass_fld, value);
		System.out.println("Contenido Password: " + pass_content);
		return pass_content;
	}
	
	public String getUsrDoesNotExistError() {
		return usr_does_not_exist_error;
	}
	
	public String getWrongPassError() {
		return wrong_pass_error;
	}
	
	public String getNullFldError() {
		return null_fld_error;
	}

	public static String getLoginBtn2Id() {
		return login_btn_2_id;
	}

	public static String getWelcomeTxtId() {
		return welcome_txt_id;
	}

	public static String getAlertId() {
		return alert_id;
	}
}