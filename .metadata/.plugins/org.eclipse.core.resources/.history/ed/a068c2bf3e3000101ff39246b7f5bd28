package pages;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	/*** VARIABLES ***/
	// Locators
	@FindBy(id = "signin2")
	private WebElement register_btn;
	@FindBy(id = "sign-username")
	private WebElement usr_fld;
	@FindBy(id = "sign-password")
	private WebElement pass_fld;
	@FindBy(xpath = "//button[@onclick=\"register()\"]")
	private WebElement register_btn_2;
	
	// Attributes
	private static final String value = "value";

	// Variables
	private boolean isVisible = false;
	private String alert_txt = null;
	private String user_content = null;
	private String pass_content = null;
	private static final String register_btn_id = "Register Button";
	private static final String usr_fld_id = "User Field";
	private static final String pass_fld_id = "Password Field";
	private static final String register_btn_2_id = "Register Button 2";
	private static final String alert_id = "Alert";

	// Constructor
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
	public WebElement getRegisterBtn() {
		return register_btn;
		
	}

	public void setRegisterBtn(WebElement register_btn) {
		this.register_btn = register_btn;
		
	}

	public WebElement getUsrFld() {
		return usr_fld;
		
	}
	
	public String getUsrFldContent() {
		user_content = getAttribute(usr_fld, usr_fld_id, value);
				
		return user_content;
		
	}

	public void setUsrFld(WebElement usr_fld) {
		this.usr_fld = usr_fld;
		
	}

	public WebElement getPassFld() {
		return pass_fld;
		
	}

	public void setPassFld(WebElement pass_fld) {
		this.pass_fld = pass_fld;
		
	}

	public WebElement getRegisterBtn2() {
		return register_btn_2;
		
	}

	public void setRegisterBtn2(WebElement register_btn_2) {
		this.register_btn_2 = register_btn_2;
		
	}

	public boolean isVisible() {
		return isVisible;
		
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		
	}

	public String getAlertTxt() {
		alert_txt = getAlertText(alert_id);
		
		return alert_txt;
		
	}

	public void setAlertTxt(String alert_txt) {
		this.alert_txt = alert_txt;
		
	}

	public static String getRegisterBtnId() {
		return register_btn_id;
		
	}

	public static String getUsrFldId() {
		return usr_fld_id;
		
	}

	public static String getPassFldId() {
		return pass_fld_id;
		
	}
	
	public String getPassFldContent() {
		pass_content = getAttribute(pass_fld, pass_fld_id, value);
				
		return pass_content;
		
	}
	
	public static String getRegisterBtn2Id() {
		return register_btn_2_id;
		
	}

	public static String getAlertId() {
		return alert_id;
		
	}
}