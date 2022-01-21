package Beta_Web;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Page {
	
	ChromeDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	public void openBrowser() {
		report = new ExtentHtmlReporter("./reports/signupreport.html");
		report.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(report);
		//test = extent.createTest("Login page", "test cases");
		//test.assignAuthor("Satham");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://shopadmin.orderznow.com/");
		driver.findElementByXPath("//button[text()='New user? Sign up']").click();
		}
	
	@BeforeTest
	public int screenShot() throws IOException {
		int rannum = (int)(Math.random()*99999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./reports/snaps/img"+rannum+".png");
		FileUtils.copyFile(source, target);
		return rannum;
	}
	
	@Test(priority = 1 , enabled = false)
	public void allFieldsAreEmpty() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter All Fields are empty", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("");
		test.log(Status.INFO, "Username field is empty");
		POM_Page.resname.sendKeys("");
		test.log(Status.INFO, "Restaurant field is empty");
		POM_Page.email.sendKeys("");
		test.log(Status.INFO, "Email field is empty");
		POM_Page.number.sendKeys("");
		test.log(Status.INFO, "Mobile number field is empty");
		POM_Page.domain.sendKeys("");
		test.log(Status.INFO, "Domain field is empty");
		POM_Page.spassword.sendKeys("");
		test.log(Status.INFO, "Password field is empty");
		POM_Page.rpassword.sendKeys("");
		test.log(Status.INFO, "Repeat password field is empty");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
		WebElement un = driver.findElementByXPath("//span[text()='Required!']");
		if (un.isDisplayed()) {
			System.out.println("Username field is empty msg is displayed");
			test.log(Status.PASS, "Username field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Username field is empty msg is not displayed");
			test.log(Status.FAIL, "Username field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Username field is empty msg is not displayed");	
		}
		WebElement rn = driver.findElementByXPath("(//span[text()='Required!'])[2]");
		if (rn.isDisplayed()) {
			System.out.println("Restaurant name field is empty msg is displayed");
			test.log(Status.PASS, "Restaurant name field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Restaurant name field is empty msg is not displayed");
			test.log(Status.FAIL, "Restaurant name field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Restaurant name field is empty msg is not displayed");	
		}
		
		WebElement en = driver.findElementByXPath("(//span[text()='Required!'])[3]");
		if (en.isDisplayed()) {
			System.out.println("Email field is empty msg is displayed");
			test.log(Status.PASS, "Email field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Email field is empty msg is not displayed");
			test.log(Status.FAIL, "Email field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Email field is empty msg is not displayed");	
		}
		WebElement mn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[6]/div[2]/div[1]/span[1]");
		if (mn.isDisplayed()) {
			System.out.println("Mobile number field is empty msg is displayed");
			test.log(Status.PASS, "Mobile number field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is empty msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is empty msg is not displayed");	
		}
		WebElement dn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/span[1]");
		if (dn.isDisplayed()) {
			System.out.println("Mobile number field is empty msg is displayed");
			test.log(Status.PASS, "Mobile number field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is empty msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is empty msg is not displayed");	
		}
		WebElement pn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[8]/span[1]");
		if (pn.isDisplayed()) {
			System.out.println("Password field is empty msg is displayed");
			test.log(Status.PASS, "Password field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Password field is empty msg is not displayed");
			test.log(Status.FAIL, "Password field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Password field is empty msg is not displayed");	
		}
		
		WebElement rpn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[9]/span[1]");
		if (rpn.isDisplayed()) {
			System.out.println("Repeat Password field is empty msg is displayed");
			test.log(Status.PASS, "Repeat Password field is empty msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Repeat Password field is empty msg is not displayed");
			test.log(Status.FAIL, "Repeat Password field is empty msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Repeat Password field is empty msg is not displayed");	
		}
	}
	
	
	@Test(priority = 2 , enabled = true)
	public void enterShortValues() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter short values to all fields", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("s"+Keys.TAB);
		test.log(Status.INFO, "Username field is enter with short value");
		POM_Page.resname.sendKeys("s"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is enter with short value");
		POM_Page.email.sendKeys("s"+Keys.TAB);
		test.log(Status.INFO, "Email field is enter with short value");
		POM_Page.number.sendKeys("878"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is enter with short value");
		POM_Page.domain.sendKeys("s"+Keys.TAB);
		test.log(Status.INFO, "Domain field is enter with short value");
		POM_Page.spassword.sendKeys("s"+Keys.TAB);
		test.log(Status.INFO, "Password field is enter with short value");
		POM_Page.rpassword.sendKeys("a"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is enter with short value");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
		//WebElement un = driver.findElementByXPath("//span[text()='Required!']");
		if (driver.getPageSource().contains("Short")) {
			System.out.println("Username field is short msg is displayed");
			test.log(Status.PASS, "Username field is short msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Username field is short msg is not displayed");
			test.log(Status.FAIL, "Username field is short msg is not displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Username field is short msg is not displayed");	
		}
		//WebElement rn = driver.findElementByXPath("(//span[text()='Required!'])[2]");
		if (driver.getPageSource().contains("Short")) {
			System.out.println("Restaurant name field is short msg is displayed");
			test.log(Status.PASS, "Restaurant name field is short msg is displayed" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Restaurant name field is short msg is not displayed");
			test.log(Status.FAIL, "Restaurant name field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Restaurant name field is short msg is not displayed");	
		}
		
		//WebElement en = driver.findElementByXPath("(//span[text()='Required!'])[3]");
		if (driver.getPageSource().contains("Short")) {
			System.out.println("Email field is short msg is displayed");
			test.log(Status.PASS, "Email field is short msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Email field is short msg is not displayed");
			test.log(Status.FAIL, "Email field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Email field is short msg is not displayed");	
		}
		//WebElement mn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[6]/div[2]/div[1]/span[1]");
		if (driver.getPageSource().contains("Short")) {
			System.out.println("Mobile number field is short msg is displayed");
			test.log(Status.PASS, "Mobile number field is short msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is short msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is short msg is not displayed");	
		}
		//WebElement dn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/span[1]");
		if (driver.getPageSource().contains("Short")) {
			System.out.println("Mobile number field is short msg is displayed");
			test.log(Status.PASS, "Mobile number field is short msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is short msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is short msg is not displayed");	
		}
		WebElement pn = driver.findElementByXPath("//span[text()='minimum 7 characters']");
		if (pn.isDisplayed()) {
			System.out.println("Password field is short msg is displayed");
			test.log(Status.PASS, "Password field is short msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Password field is short msg is not displayed");
			test.log(Status.FAIL, "Password field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Password field is short msg is not displayed");	
		}
		
		WebElement rpn = driver.findElementByXPath("//span[text()='Passwords doesnot match']");
		if (rpn.isDisplayed()) {
			System.out.println("Repeat Password field is short msg is displayed");
			test.log(Status.PASS, "Repeat Password field is short msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Repeat Password field is short msg is not displayed");
			test.log(Status.FAIL, "Repeat Password field is short msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Repeat Password field is short msg is not displayed");	
		}
	}
	
	
	@Test(priority = 3 , enabled = true)
	public void enterLengthValues() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter Length values to all fields", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+Keys.TAB);
		test.log(Status.INFO, "Username field is enter with Length value");
		POM_Page.resname.sendKeys("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is enter with Length value");
		POM_Page.email.sendKeys("beef@test.com"+Keys.TAB);
		test.log(Status.INFO, "Email field is enter with Length value");
		POM_Page.number.sendKeys("878222222222222222222222222"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is enter with Length value");
		POM_Page.domain.sendKeys("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+Keys.TAB);
		test.log(Status.INFO, "Domain field is enter with Length value");
		POM_Page.spassword.sendKeys("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+Keys.TAB);
		test.log(Status.INFO, "Password field is enter with Length value");
		POM_Page.rpassword.sendKeys("asssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is enter with Length value");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
		//WebElement un = driver.findElementByXPath("//span[text()='Required!']");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Username field is Length msg is displayed");
			test.log(Status.PASS, "Username field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Username field is Length msg is not displayed");
			test.log(Status.FAIL, "Username field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Username field is Length msg is not displayed");	
		}
		//WebElement rn = driver.findElementByXPath("(//span[text()='Required!'])[2]");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Restaurant name field is Length msg is displayed");
			test.log(Status.PASS, "Restaurant name field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Restaurant name field is Length msg is not displayed");
			test.log(Status.FAIL, "Restaurant name field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Restaurant name field is Length msg is not displayed");	
		}
		
		//WebElement en = driver.findElementByXPath("(//span[text()='Required!'])[3]");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Email field is Length msg is displayed");
			test.log(Status.PASS, "Email field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Email field is Length msg is not displayed");
			test.log(Status.FAIL, "Email field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Email field is Length msg is not displayed");	
		}
		//WebElement mn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[6]/div[2]/div[1]/span[1]");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Mobile number field is Length msg is displayed");
			test.log(Status.PASS, "Mobile number field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is Length msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is Length msg is not displayed");	
		}
		//WebElement dn = driver.findElementByXPath("//div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/span[1]");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Mobile number field is Length msg is displayed");
			test.log(Status.PASS, "Mobile number field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field is Length msg is not displayed");
			test.log(Status.FAIL, "Mobile number field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field is Length msg is not displayed");	
		}
		//WebElement pn = driver.findElementByXPath("//span[text()='minimum 7 characters']");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Password field is Length msg is displayed");
			test.log(Status.PASS, "Password field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Password field is Length msg is not displayed");
			test.log(Status.FAIL, "Password field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Password field is Length msg is not displayed");	
		}
		
		//ebElement rpn = driver.findElementByXPath("//span[text()='Passwords doesnot match']");
		if (driver.getPageSource().contains("Length")) {
			System.out.println("Repeat Password field is Length msg is displayed");
			test.log(Status.PASS, "Repeat Password field is Length msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Repeat Password field is Length msg is not displayed");
			test.log(Status.FAIL, "Repeat Password field is Length msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Repeat Password field is Length msg is not displayed");	
		}
	}
	
	@Test(priority = 4 , enabled = true)
	public void domainFieldWithSpecialChar() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter domain name with special character", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("shop@test.com"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered");
		POM_Page.number.sendKeys("12345678"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop@!!@"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered with special character");

		WebElement domain = driver.findElementByXPath("//span[text()='cannot have special characters']");
		if (domain.isDisplayed()) {
			System.out.println("Domain cannot accept special character msg is displayed");
			test.log(Status.PASS, "Domain cannot accept special character msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Domain cannot accept special character msg is not displayed");
			test.log(Status.FAIL, "Domain cannot accept special character msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Domain cannot accept special character msg is not displayed");	
		}
		
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
		
	}
	
	
	@Test(priority = 5 , enabled = true)
	public void numberFieldEnterWithCharacter() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a number field with character", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("shop@test.com"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered");
		POM_Page.number.sendKeys("sasasasa"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered with character");
		//WebElement number = driver.findElementByXPath("//span[text()='cannot have special characters']");
		if (driver.getPageSource().contains("Cannot accpet special character")) {
			System.out.println("Mobile number field cannot accept character msg is displayed");
			test.log(Status.PASS, "Mobile number field cannot accept character msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Mobile number field cannot accept character msg is not displayed");
			test.log(Status.FAIL, "Mobile number field cannot accept character msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Mobile number field cannot accept character msg is not displayed");	
		}
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
	}
	
	@Test(priority = 6 , enabled = true)
	public void enterInvalidEmail() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a Email field with invalid syntax", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("shop@t.c"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with invalid syntax");
		//WebElement email = driver.findElementByXPath("//span[text()='cannot have special characters']");
		if (driver.getPageSource().contains("invalid email")) {
			System.out.println("Invalid Email field msg is displayed");
			test.log(Status.PASS, "Invalid Email field msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Invalid Email field msg is not displayed");
			test.log(Status.FAIL, "Invalid Email field msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Invalid Email field msg is not displayed");	
		}
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
	}
	
	@Test(priority = 7 , enabled = true)
	public void enterInvalidEmail2() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a Email field with invalid syntax", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with invalid syntax");
		WebElement email = driver.findElementByXPath("//span[text()='Invalid format']");
		if (email.isDisplayed()) {
			System.out.println("Invalid Email field msg is displayed");
			test.log(Status.PASS, "Invalid Email field msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Invalid Email field msg is not displayed");
			test.log(Status.FAIL, "Invalid Email field msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Invalid Email field msg is not displayed");	
		}
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 8 , enabled = true)
	public void enterAlreadyRegisteredEmail() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a Email field with already registered mail", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("supershop@test.co"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with already registered mail");
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
		WebElement email = driver.findElementByXPath("//div[text()='email already exists']");
		if (email.isDisplayed()) {
			System.out.println("Already registered Email msg is displayed");
			test.log(Status.PASS, "Already registered Email msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Already registered Email msg is not displayed");
			test.log(Status.FAIL, "Already registered Email msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Already registered Email msg is not displayed");	
		}
	}
	
	
	@Test(priority = 9 , enabled = true)
	public void emailFieldWithSpecialCharacters() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a Email field with Special characters", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("supershop!!#@test.co"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with Special characters");
		//WebElement email = driver.findElementByXPath("//div[text()='email already exists']");
		if (driver.getPageSource().contains("Cannot accpet special character")) {
			System.out.println("Cannot accpet special character msg is displayed");
			test.log(Status.PASS, "Cannot accpet special character msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Cannot accpet special character msg is not displayed");
			test.log(Status.FAIL, "Cannot accpet special character is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Cannot accpet special character msg is not displayed");	
		}
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password field is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
	}
	
	@Test(priority = 10 , enabled = true)
	public void wrongRepeatPassword() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a repeat password is different", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("supershop@test.co"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with Special characters");
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("12345"+Keys.TAB);
		test.log(Status.INFO, "Entered a Repeat password is different");
		WebElement rpas = driver.findElementByXPath("//span[text()='Passwords doesnot match']");
		if (rpas.isDisplayed()) {
			System.out.println("Repeat password is wrong msg is displayed");
			test.log(Status.PASS, "Repeat password is wrong msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Repeat password is wrong msg is displayed");
			test.log(Status.FAIL, "Repeat password is wrong msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Repeat password is wrong msg is displayed");	
		}
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(3000);
	}
	
	@Test(priority = 11 , enabled = true)
	public void alreadyEnteredDomainName() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter a domain name field with already registered domain", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("supersh@test.co"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered");
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("ss"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered with already registered domain name");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		Thread.sleep(2000);
		WebElement domain = driver.findElementByXPath("//span[text()='Domain name already exists']");
		if (domain.isDisplayed()) {
			System.out.println("Domain name is already registered msg is displayed");
			test.log(Status.PASS, "Domain name is already registered msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Domain name is already registered msg is not displayed");
			test.log(Status.FAIL, "Domain name is already registered msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Domain name is already registered msg is not displayed");	
		}
	}
	
	@Test(priority = 12 , enabled = true)
	public void validValues() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		test = extent.createTest("Enter all fields are valid", "test cases");
		test.assignAuthor("Satham Hussain");
		test.log(Status.INFO, "Browser is opened");
		PageFactory.initElements(driver, POM_Page.class);
		POM_Page.susername.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Username field is entered");
		POM_Page.resname.sendKeys("shop"+Keys.TAB);
		test.log(Status.INFO, "Restaurant field is entered");
		POM_Page.email.sendKeys("supersho@test.com"+Keys.TAB);
		test.log(Status.INFO, "Email field is entered with Special characters");
		POM_Page.number.sendKeys("123456789"+Keys.TAB);
		test.log(Status.INFO, "Mobile number field is entered");
		POM_Page.domain.sendKeys("supershoo"+Keys.TAB);
		test.log(Status.INFO, "Domain field is entered");
		POM_Page.spassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Password field is entered");
		POM_Page.rpassword.sendKeys("1234567"+Keys.TAB);
		test.log(Status.INFO, "Repeat password is entered");
		POM_Page.submit.click();
		test.log(Status.INFO, "Submit button is clicked");
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//p[text()='Thank You! Your account has been created successfully']")));
		WebElement valid = driver.findElementByXPath("//p[text()='Thank You! Your account has been created successfully']");
		if (valid.isDisplayed()) {
			System.out.println("Succesfully Registered msg is displayed");
			test.log(Status.PASS, "Succesfully Registered msg is displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Succesfully Registered msg is not displayed");
			test.log(Status.FAIL, "Succesfully Registered msg is not displayed", MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Succesfully Registered msg is not displayed");	
		}
	}
	
	@AfterSuite
	public void closeBrwser() {
		extent.flush();
		driver.close();
		
	}
}
