package Beta_Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_Page {
	/*
	 * @FindBy(how = HOW.NAME , using = "email") 
	 * public static WebElement username;
	 */

	@FindBy(name = "email")
	public static WebElement username;
	
	@FindBy(name = "password")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement click;
	
	@FindBy(name = "username")
	public static WebElement susername;
	
	@FindBy(name = "storeName")
	public static WebElement resname;
	
	@FindBy(name = "email")
	public static WebElement email;
	
	@FindBy(name = "mobileNumber")
	public static WebElement number;
	
	@FindBy(name = "domain")
	public static WebElement domain;
	
	@FindBy(name = "password")
	public static WebElement spassword;
	
	@FindBy(name = "repeatPassword")
	public static WebElement rpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submit;
	

}
