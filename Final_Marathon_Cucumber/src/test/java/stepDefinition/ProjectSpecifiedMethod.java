package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecifiedMethod extends AbstractTestNGCucumberTests{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testcaseName, testcaseDescription, authorName, categoryName;
	
	
	private static final ThreadLocal<RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		rd.set(new ChromeDriver(option));
	}
	
	public RemoteWebDriver getDriver() {
		return rd.get();
	}
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		//reporter.setAppendExisting(true);
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void setReport() {
		test = extent.createTest(testcaseName, testcaseDescription);
		test.assignAuthor(authorName);
		test.assignCategory(categoryName);
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	public int takeSnap() throws IOException {
		System.out.println("taking snaps...");
		int random = (int) ((Math.random())*999999);
		System.out.println("random no===="+random);
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+random+".png");
		FileUtils.copyFile(src, desc);
		return random;
	}
	
	
	public void reportStep(String status, String desc) throws IOException {
		System.out.println("status================"+status);
		if(status.equalsIgnoreCase("pass")) {
			test.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")) {
			test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
	}
	
	@BeforeMethod
	public void preCondition() {
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	@BeforeTest
	public void setData() {
		testcaseName = "Create Individual testcase in Cucumber";
		testcaseDescription = "Create Individual testcase with positive functionality in Cucumber";
		authorName = "Nisha";
		categoryName = "Regression";
	}
}
