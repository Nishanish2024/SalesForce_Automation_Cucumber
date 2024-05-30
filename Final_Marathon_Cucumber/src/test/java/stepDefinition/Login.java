package stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login extends ProjectSpecifiedMethod {
	
	@Given("Load the URL")
	public void LoadUrl() {
		getDriver().get("https://login.salesforce.com/");
	}
	
	@Given("Enter the username")
	public void enterUserName() throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys("ranjini.r@testleaf.com");
			reportStep("pass", "Username entered as ranjini.r@testleaf.com");
		} catch (Exception e) {
			reportStep("fail", "Unable to enter the username "+e);
		}
		
	}
	
	@Given("Enter the password")
	public void enterPassword() throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys("Testleaf$4321");
			reportStep("pass", "Username entered as Testleaf$4321");
		} catch (Exception e) {
			reportStep("fail", "Unable to enter the password "+e);
		}
		
	}
	
	@When("click on the Login button")
	public void clickLoginButton() throws IOException {
		try {
			getDriver().findElement(By.id("Login")).click();
			reportStep("pass", "Logged in successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to Login... "+e);
		}
		
	}
}
