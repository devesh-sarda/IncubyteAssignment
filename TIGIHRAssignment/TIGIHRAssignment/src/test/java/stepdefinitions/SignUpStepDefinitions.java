package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpBasePage;
import utilities.SampleTestData;
import utilities.SetUpBrowser;

/**
 * Step Definition class or Test class for Sign Up
 * @author devesh.sarda
 */
public class SignUpStepDefinitions extends SetUpBrowser 
{
    WebDriver driver;
    SignUpBasePage signUpObjects;

    @Given("user opens the Magento homepage")
    public void openMagentoHomepage() 
    {
    	driver = setUpChrome();
        Assert.assertTrue("The Magento page has incorrect title", driver.getTitle().equalsIgnoreCase("Home Page"));
        signUpObjects = new SignUpBasePage(driver);
    }

    @When("user clicks on create an account button")
    public void clickCreateAnAccountFromHeader() 
    {
    	signUpObjects.createAnAccount.click();
    }
    
    @Then("verify that user lands on {string} page")
    public void verifyCreateNewCustomerAccountPageLanding(String title)
    {
        Assert.assertTrue("The create new account page has incorrect title.", driver.getTitle().equalsIgnoreCase(title));
    }
    
    @When("user fills the account details with invalid details")
    public void fillingTheAccountDetailsWithInvalidDetails() 
    {
    	signUpObjects.createAnAccountButton.click();
    }
    
    @Then("verify the required field message displays")
    public void verifyTheRequiredFieldMessageDisplays()
    {
        Assert.assertTrue("Required field message is not displayed.", signUpObjects.requiredFieldMessage.get(4).isDisplayed());
    	closeBrowser();
    }
    
    @Then("user fills the account details with valid details")
    public void fillingTheAccountDetailsWithValidDetails() 
    {
    	signUpObjects.fillAccountDetails();
    	Assert.assertTrue("The account details filled are incorrect.", signUpObjects.accountCreatedMessage.isDisplayed());
    }
    
    @Then("verify that user account has been created")
    public void verifyTheAccountIsCreated()
    {
    	Assert.assertTrue("The user is not logged in.", signUpObjects.loggedinUser.isDisplayed());
    	Assert.assertTrue("The user is not logged in.", signUpObjects.loggedinUser.getText().contains(SampleTestData.getFirstName() + " " + SampleTestData.getLastName()));
    }
    
    @Then("verify the success message")
    public void verifyAccountSuccessMessage()
    {
    	Assert.assertTrue("The account is not created.", signUpObjects.accountCreatedMessage.isDisplayed());
    	closeBrowser();
    }
}