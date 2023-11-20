/**
 * 
 */
package POM1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class ContactPage {

	
	@FindBy(name="firstname")
	private WebElement firstnametf;
	
	
	@FindBy(name="lastname")
	private WebElement lastnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement Assignedtobtn;
	
	
	@FindBy(name="assigned_group_id")
	private WebElement Assignedropdown;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement getContactplusbtn;
	
	
	
	@FindBy(id="search_txt")
	private WebElement ContactSearchtf;
	
	@FindBy(name="search")
    private WebElement  Searchbtn;
	
	
	@FindBy(xpath="//a[text()='TCS']")
	private  WebElement contacttext;
	
	
	public WebElement getContactSearchtf() {
		return ContactSearchtf;
	}

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	public WebElement getContacttext() {
		return contacttext;
	}

	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="(//td[@valign='bottom'])[2]")
	private WebElement imagebtn;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signbtn;
	
	
	
	
	public WebElement getGetContactplusbtn() {
		return getContactplusbtn;
	}

	public WebElement getFirstnametf() {
		return firstnametf;
	}

	public WebElement getLastnametf() {
		return lastnametf;
	}

	public WebElement getAssignedtobtn() {
		return Assignedtobtn;
	}

	public WebElement getAssignedropdown() {
		return Assignedropdown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getImagebtn() {
		return imagebtn;
	}

	public WebElement getSignbtn() {
		return signbtn;
	}

	
	

	
	}

