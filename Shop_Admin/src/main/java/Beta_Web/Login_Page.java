package Beta_Web;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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

public class Login_Page {
	
	ChromeDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	public void openBrowser() {
		report = new ExtentHtmlReporter("./reports/loginreport.html");
		report.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(report);
		//test = extent.createTest("Login page", "test cases");
		//test.assignAuthor("Satham");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://shopadmin.orderznow.com/");
	}
	
	@BeforeTest
	public int screenShot() throws IOException {
		int rannum = (int)(Math.random()*99999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./reports/snaps/img"+rannum+".png");
		FileUtils.copyFile(source, target);
		return rannum;
	}
	
	@Test(priority = 1 , enabled = true)
	public void enterWrongPassword() throws Exception {
		test = extent.createTest("Enter a valid username and wrong Password");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("supershop@test.co");
		test.log(Status.INFO, "Username is entered");
		POM_Page.password.sendKeys("123");
		test.log(Status.INFO, "Password is entered");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("wrong password")) {
			System.out.println("Wrong password msg is appears");
			test.log(Status.PASS, "Wrong password msg is appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Wrong password msg is not appears");
			test.log(Status.FAIL, "Wrong password msg is not appears" , MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Wrong password msg is not appears");
		}
	}
	
	
	@Test(priority = 2 , enabled = true)
	public void enterWrongUsername() throws Exception {
		test = extent.createTest("Enter a valid Password and wrong User emailID");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("super@test.co");
		test.log(Status.INFO, "Username is entered");
		POM_Page.password.sendKeys("1234567");
		test.log(Status.INFO, "Password is entered");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("User doesn't exist")) {
			System.out.println("Wrong User msg is appears");
			test.log(Status.PASS, "Wrong User msg is appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Wrong User msg is not appears");
			test.log(Status.FAIL, "Wrong User msg is not appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Wrong User msg is not appears");
		}
	}
	
	
	@Test(priority = 3 , enabled = true)
	public void enterBothareWrong() throws Exception {
		test = extent.createTest("Enter both are Wrong credentials");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("super@test.co");
		test.log(Status.INFO, "Username is entered");
		POM_Page.password.sendKeys("123");
		test.log(Status.INFO, "Password is entered");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("User doesn't exist")) {
			System.out.println("Wrong User msg is appears");
			test.log(Status.PASS, "Wrong User msg is appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Wrong User msg is not appears");
			test.log(Status.FAIL, "Wrong User msg is not appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Wrong User msg is not appears");
		}
	}
	
	
	@Test(priority = 4 , enabled = true)
	public void bothAreEmptyField() throws Exception {
		test = extent.createTest("Both fields are empty");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("");
		test.log(Status.INFO, "Email field is empty");
		POM_Page.password.sendKeys("");
		test.log(Status.INFO, "Password field is empty");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Email is Required!")) {
			System.out.println("Email is Required msg is appears");
			test.log(Status.PASS, "Email is Required msg is appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Email is Required msg is not appears");
			test.log(Status.FAIL, "Email is Required msg is not appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Email is Required msg is not appears");
		}
	}
	
	@Test(priority = 5 , enabled = true)
	public void invalidEmailType() throws Exception {
		test = extent.createTest("Enter a invaid email type");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("satham@t.c");
		test.log(Status.INFO, "Email field is enter with invalid type");
		POM_Page.password.sendKeys("1234567");
		test.log(Status.INFO, "Password field is entered");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Email is Wrong")) {
			System.out.println("Email is Wrong msg is appears");
			test.log(Status.PASS, "Email is Wrong msg is appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Email is Wrong msg is not appears");
			test.log(Status.FAIL, "Email is Wrong msg is not appears" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Email is Wrong msg is not appears");
		}
	}
	
	@Test(priority = 6 , enabled = true)
	public void submitButton() throws Exception {
		test = extent.createTest("Click a submit button");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
		WebElement click = POM_Page.click;
		if (click.isEnabled()) {
			click.click();
			System.out.println("Button is clicked");
			test.log(Status.PASS, "Submit Button is working fine" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
		}else {
			System.out.println("Button is not clicked");
			test.log(Status.FAIL, "Submit Button is not working fine" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Submit Button is not working fine");
		}

	}
	
	
	@Test(priority = 7 , enabled = true)
	public void correctCredentials() throws Exception {
		test = extent.createTest("Enter a Valid user credential");
		test.assignAuthor("Satham Hussain");
		PageFactory.initElements(driver, POM_Page.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();  
	    test.log(Status.INFO, "Browser is opened successfully");
		POM_Page.username.sendKeys("supershop@test.co");
		test.log(Status.INFO, "Email field is enter");
		POM_Page.password.sendKeys("1234567");
		test.log(Status.INFO, "Password field is entered");
		POM_Page.click.click();
		test.log(Status.INFO, "Submit Button is clicked");
		Thread.sleep(5000);
		if (driver.getPageSource().contains("(Last 24 Hours)")) {
			System.out.println("You have successfully signed in");
			test.log(Status.PASS, "You have successfully signed in" ,  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			
		}else {
			System.out.println("Not successfully signed in");
			test.log(Status.FAIL, "Not successfully signed in",  MediaEntityBuilder.createScreenCaptureFromPath(".././reports/snaps/img"+screenShot()+".png").build());
			throw new Exception("Not successfully signed in");
		}
	}
	
	
	
	@AfterSuite
	public void closeBrowser() {
		extent.flush();
		driver.close();

	}
	

}
