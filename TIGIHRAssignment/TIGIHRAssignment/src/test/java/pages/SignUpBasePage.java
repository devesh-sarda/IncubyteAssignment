package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SampleTestData;

/**
 * Base class for Sign Up comprising of page objects and methods
 * @author devesh.sarda
 */
public class SignUpBasePage
{
	public WebDriver driver;

	/**
	 * Constructor to instantiate the driver and page objects
	 * @param driver
	 */
	public SignUpBasePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//header//*[contains(text(),'Create an Account')]")
	public WebElement createAnAccount;

	@FindBy(css = "#firstname")
	public WebElement firstname;

	@FindBy(css = "#lastname")
	public WebElement lastname;

	@FindBy(css = "#email_address")
	public WebElement email;

	@FindBy(css = "#password")
	public WebElement password;

	@FindBy(css = "#password-confirmation")
	public WebElement confirmPassword;
	
	@FindBy(xpath = "//*[contains(@id,'-error')]")
	public List<WebElement> requiredFieldMessage;

	@FindBy(xpath = "//button//*[text()='Create an Account']")
	public WebElement createAnAccountButton;
	
	@FindBy(xpath = "//header//*[@*='logged-in']")
	public WebElement loggedinUser;
	
	@FindBy(xpath = "//*[text()='Thank you for registering with Main Website Store.']")
	public WebElement accountCreatedMessage;
	
	public void fillAccountDetails() 
	{
		firstname.sendKeys(SampleTestData.firstName);
		lastname.sendKeys(SampleTestData.lastName);
		email.sendKeys(SampleTestData.email);
		password.sendKeys(SampleTestData.password);
		confirmPassword.sendKeys(SampleTestData.password);
    	createAnAccountButton.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}