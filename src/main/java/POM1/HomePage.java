/**
 * 
 */
package POM1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class HomePage {

	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement Oragniaztionlink;

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement Contactlink;

	public WebElement getContactlink() {
		return Contactlink;
	}

	

	public WebElement getOragniaztionlink() {
		return Oragniaztionlink;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement image;
	
	public WebElement getImage() {
		return image;
	}

}
