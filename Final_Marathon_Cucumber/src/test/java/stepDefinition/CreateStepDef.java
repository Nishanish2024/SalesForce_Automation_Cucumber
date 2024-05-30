package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateStepDef extends ProjectSpecifiedMethod {

	@When("click on AppLaunch")
	public void appLauncher() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@When("click on the View All icon")
	public void clickViewAll() {
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
	}

	@Given("Enter search as individuals")
	public void enterSearch() {
		// searching for individuals
		WebElement searchIndiv = getDriver().findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input"));
		searchIndiv.sendKeys("individuals");
	}

	@When("click on the individuals link")
	public void clickIndividuals() throws InterruptedException {
		// All Items
		Actions action = new Actions(getDriver());
		WebElement allItems = getDriver().findElement(By.xpath("(//span[@class='slds-accordion__summary-content'])[2]"));
		action.moveToElement(allItems).perform();
		// click Individuals
		getDriver().findElement(By.xpath("//mark[text()='Individuals']/parent::p")).click();
		Thread.sleep(3000);
	}

	@When("click on New Button")
	public void clickNewButton() {
		//click new
		getDriver().findElement(By.xpath("//div[@title='New']")).click();
	}

	@Given("Enter First Name as (.*)$")
	public void firstName(String firstName) throws IOException {
		try {
			getDriver().findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys(firstName);
			reportStep("pass", "First Name enterd successfully");
		} catch (Exception e) {
			reportStep("fail", "First Name not enterd "+e);
		}
	}
	
	@Given("Enter Last Name as (.*)$")
	public void lastName(String lastName) throws IOException {
		try {
			getDriver().findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(lastName);
			reportStep("pass", "Last Name enterd successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to enter last name "+e);
		}
	}

	@When("click on Save Button")
	public void clickSave() throws IOException {
		try {
			getDriver().findElement(By.xpath("//button[@title='Save']")).click();
			System.out.println("New Individual is Created Successfully... ");
			reportStep("pass", "New Individual is created successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to save New Individual "+e);
		}
	}
	
	@Then("verify Individual is created or not")
	public void verifyCreate() {
		System.out.println("Verifying...");
	}
}
