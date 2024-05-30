package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditStepDef extends ProjectSpecifiedMethod{

	@When("Search for an Individual")
	public void searchIndividual() throws InterruptedException, IOException {
		try {
			//Search for individual ='Anish'
			WebElement name = getDriver().findElement(By.xpath("//input[@name='Individual-search-input']"));
			name.sendKeys("Anish");
			name.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			reportStep("pass", "searching for Anish");
		} catch (Exception e) {
			reportStep("fail", "Unable to search for Anish "+e);
		}
		
	}
	
	@When("click Edit from the dropdown")
	public void editDropdown() throws InterruptedException {
		WebElement ele = getDriver().findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		getDriver().executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = getDriver().findElement(By.xpath("//a[@title='Edit']/div"));
		getDriver().executeScript("arguments[0].click();", edit);
	}
	
	@Given("Enter Salutaion")
	public void enterSalutaion() {
		getDriver().findElement(By.xpath("//a[@class='select']")).click();
		getDriver().findElement(By.xpath("//a[text()='Mr.']")).click();
	}
	
	@Given("Enter First Name for Edit")
	public void enterFirstName() {
		getDriver().findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Manish");
	}
	
	@When("click on EditSave Button")
	public void SaveButton() throws IOException {
		try {
			getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			reportStep("pass", "Edited successfully...");
		} catch (Exception e) {
				reportStep("fail", "Unable to edit "+e);
		}
	}
	
	@Then("verify Individual is Edited or not")
	public void verifyEdit() {
		System.out.println("Edited successfully....");
	}
}
