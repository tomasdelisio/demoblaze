package pages;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	/*** LOCATORS ***/
	@FindBy(id = "signin2")
	private WebElement register_btn;
	@FindBy(id = "sign-username")
	private WebElement usr_fld;
	@FindBy(id = "sign-password")
	private WebElement pass_fld;
	@FindBy(xpath = "//button[@onclick=\"register()\"]")
	private WebElement register_btn_2;
	
	/*** ATTRIBUTES ***/
	private static final String value = "value";

	/*** VARIABLES ***/
	private boolean isVisible = false;
	private String alert_txt = null;
	private String user_content = null;
	private String pass_content = null;
	private static final String register_btn_id = "Register Button";
	private static final String usr_fld_id = "User Field";
	private static final String pass_fld_id = "Password Field";
	private static final String register_btn_2_id = "Register Button 2";
	private static final String alert_id = "Alert";
	
	/*** ERROR/MESSAGE ***/
	private final String usr_already_exist_error = "This user already exist.";
	private final String wrong_pass_error = "Wrong password.";
	private final String null_fld_error = "Please fill out Username and Password.";
	private final String register_msg = "Sign up successful.";

	/*** CONSTRUCTOR ***/
	public RegisterPage() {
		super(driver);
	}

	/*** METHODS ***/

	// Register
	public void clickRegisterBtn() {
		click(register_btn, register_btn_id);
	}

	public void completeUsr(String usr) {
		type(usr, usr_fld, usr_fld_id);
	}

	public void completePass(String pass) {
		type(pass, pass_fld, pass_fld_id);
	}

	public void clickRegisterBtn2() {
		click(register_btn_2, register_btn_2_id);
	}

	// Alerts
	public void acceptAlert() {
		acceptAlert(alert_id);
	}

	public void cancelAlert() {
		cancelAlert(alert_id);
	}

	public String getAlertTxt() {
		alert_txt = getAlertText(alert_id);
		
		return alert_txt;
	}

	// Visible
	public boolean isRegisterBtnVisible() {
		if (elementVisible(register_btn, register_btn_id) != null) {
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

	public boolean isRegisterBtn2Visible() {
		if (elementVisible(register_btn_2, register_btn_2_id) != null) {
			isVisible = true;
		}

		return isVisible;
	}
	
	// Getter and Setter

	public WebElement getRegister_btn() {
		return register_btn;
	}

	public void setRegister_btn(WebElement register_btn) {
		this.register_btn = register_btn;
	}

	public WebElement getUsr_fld() {
		return usr_fld;
	}
	
	public String getUsrFldContent() {
		user_content = getAttribute(usr_fld, value);
				
		return user_content;
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

	public WebElement getRegister_btn_2() {
		return register_btn_2;
	}

	public void setRegister_btn_2(WebElement register_btn_2) {
		this.register_btn_2 = register_btn_2;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getAlert_txt() {
		return alert_txt;
	}

	public void setAlert_txt(String alert_txt) {
		this.alert_txt = alert_txt;
	}

	public static String getRegisterBtnId() {
		return register_btn_id;
	}

	public static String getUsrFldId() {
		return usr_fld_id;
	}
	
	public String getUsrAlreadyExistError() {
		return usr_already_exist_error;
	}

	public static String getPassFldId() {
		return pass_fld_id;
	}
	
	public String getPassFldContent() {
		pass_content = getAttribute(pass_fld, value);
				
		return pass_content;
	}
	
	public String getWrongPassError() {
		return wrong_pass_error;
	}
	
	public String getNullFldError() {
		return null_fld_error;
	}

	public static String getRegisterBtn2Id() {
		return register_btn_2_id;
	}

	public static String getAlertId() {
		return alert_id;
	}
	
	public String getRegisterMsg() {
		return register_msg;
	}

}