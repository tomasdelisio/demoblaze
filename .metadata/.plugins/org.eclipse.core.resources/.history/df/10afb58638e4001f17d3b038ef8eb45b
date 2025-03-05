package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	/*** DRIVER ***/
	public static WebDriver driver;

	/*** CONSTRUCTOR ***/
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** METHODS ***/
	public void navigateTo(String URL) {
		driver.get(URL);
	}

	public void click(WebElement element, String id) {
		if (elementToBeClickable(element, id) != null) {
			element.click();
		}
	}

	public void type(String text, WebElement element, String id) {
		if (elementVisible(element, id) != null) {
			element.sendKeys(text);
		}
	}

	public String getText(WebElement element, String id) {
		String text = null;
		
		if (elementVisible(element, id) != null) {
			text = element.getText();
		}
		
		return text;
	}
	
	public String getAttribute(WebElement element, String attribute) {
		String element_attribute = null;
		
		element_attribute = element.getAttribute(attribute);
		
		return element_attribute;
	}

	public void switchToFrame(WebElement element, String id) {
		if (elementVisible(element, id) != null) {
			driver.switchTo().frame(element);
		}
	}

	public void acceptAlert(String id) {
		Alert alert = null;
		
		if (alertIsPresent(id) != null) {
			alert = switchToAlert(id);

			alert.accept();
		}
	}

	public void cancelAlert(String id) {
		Alert alert = null;
		
		if (alertIsPresent(id) != null) {
			alert = switchToAlert(id);
			
			alert.dismiss();
		}
	}

	public String getAlertText(String id) {
		Alert alert = null;
		String text = null;
		
		if (alertIsPresent(id) != null) {
			alert = switchToAlert(id);
			
			text = alert.getText();
		}
		return text;
	}
	
	public Alert switchToAlert(String id) {
		Alert alert = null;
		
		if (alertIsPresent(id) != null) {
			alert = driver.switchTo().alert();
		}
		
		return alert;
	}

	public void clear(WebElement element, String id) {
		if (elementVisible(element, id) != null) {
			element.clear();
		}
	}

	public static ExpectedCondition<WebElement> elementToBeClickable(WebElement element, String id) {
	    try {
	        new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
	                .until(ExpectedConditions.elementToBeClickable(element));
	        
	        return ExpectedConditions.elementToBeClickable(element);
	    } catch (org.openqa.selenium.TimeoutException e) {
	    	
	        System.err.println("Error: El tiempo de espera para el elemento '" + id + "' ha expirado.");
	        return null;
	    } catch (org.openqa.selenium.NoSuchElementException e) {

	    	System.err.println("Error: El elemento '" + id + "' no fue encontrado.");
	        return null;
	    } catch (Exception e) {

	    	System.err.println("Error inesperado: El elemento '" + id + "' " + e.getMessage());
	        return null;
	    }
	}

	public static ExpectedCondition<Boolean> elementVisible(WebElement element, String id) {
		try {

			new WebDriverWait(driver, java.time.Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));

			return ExpectedConditions.invisibilityOf(element);
		} catch (org.openqa.selenium.TimeoutException e) {
	    	
	        System.err.println("Error: El tiempo de espera para el elemento '" + id + "' ha expirado.");
	        return null;
	    } catch (org.openqa.selenium.NoSuchElementException e) {

	    	System.err.println("Error: El elemento '" + id + "' no fue encontrado.");
	        return null;
	    } catch (Exception e) {

	    	System.err.println("Error inesperado: El elemento '" + id + "' " + e.getMessage());
	        return null;
	    }
	}

	public static ExpectedCondition<Boolean> elementToBeSelected(WebElement element, String id) {
		try {
			new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
					.until(ExpectedConditions.elementToBeSelected(element));

			return ExpectedConditions.elementToBeSelected(element);
		} catch (org.openqa.selenium.TimeoutException e) {
	    	
	        System.err.println("Error: El tiempo de espera para el elemento '" + id + "' ha expirado.");
	        return null;
	    } catch (org.openqa.selenium.NoSuchElementException e) {

	    	System.err.println("Error: El elemento '" + id + "' no fue encontrado.");
	        return null;
	    } catch (Exception e) {

	    	System.err.println("Error inesperado: El elemento '" + id + "' " + e.getMessage());
	        return null;
	    }
	}

	public static ExpectedCondition<Alert> alertIsPresent(String id) {
		try {
			new WebDriverWait(driver, java.time.Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

			return ExpectedConditions.alertIsPresent();
		} catch (org.openqa.selenium.TimeoutException e) {
	    	
	        System.err.println("Error: El tiempo de espera para el elemento '" + id + "' ha expirado.");
	        return null;
	    } catch (org.openqa.selenium.NoSuchElementException e) {

	    	System.err.println("Error: El elemento '" + id + "' no fue encontrado.");
	        return null;
	    } catch (Exception e) {

	    	System.err.println("Error inesperado: El elemento '" + id + "' " + e.getMessage());
	        return null;
	    }
	}

	public WebElement getElement(WebElement element, String id) {
		if (elementVisible(element, id) != null) {
			return element;
		} else {
			return null;
		}
	}
}