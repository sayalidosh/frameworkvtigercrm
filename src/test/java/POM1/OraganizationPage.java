/**
 * 
 */
package POM1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class OraganizationPage {
	
	@FindBy(name="accountname")
	private WebElement oragnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement Assignedtobtn;
	
	
	@FindBy(name="assigned_group_id")
	private WebElement Assignedropdown;
	
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="(//td[@valign='bottom'])[2]")
	private WebElement imagebtn;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signbtn;
	
	

	public WebElement getSignbtn() {
		return signbtn;
	}



	public WebElement getImagebtn() {
		return imagebtn;
	}



	public WebElement getAssignedropdown() {
		return Assignedropdown;
	}



	public WebElement getSavebtn() {
		return savebtn;
	}



	public WebElement getAssignedtobtn() {
		return Assignedtobtn;
	}



	public WebElement getOragnametf() {
		return oragnametf;
	}


}
