package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RechargePage {
	
	public WebDriver driver;
	private By operatorTextBox=By.cssSelector("[data-qa=\"celular-operator\"]");
	private By operatorValue=By.cssSelector("[data-id=\"1\"]");
	private By mobileTextBox=By.cssSelector("[data-qa=\"celular-mobile\"]");
	private By amountTextBox=By.cssSelector("[data-qa=\"celular-amount\"]");
	private By amountValue=By.xpath("//li[@data-id=\"598\"]");
	private By payButton=By.cssSelector("[data-qa=\"celular-pay\"]");
	
	public RechargePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getOperator()
	{
		return driver.findElement(operatorTextBox);
	}

	public WebElement getOperatorValue()
	{
		return driver.findElement(operatorValue);
	}

	public WebElement getMobileTextBox()
	{
		return driver.findElement(mobileTextBox);
	}

	public void setMobileTextBox(String str)
	{
		driver.findElement(mobileTextBox).sendKeys(str);
	}
	
	public WebElement getAmountTextBox()
	{
		return driver.findElement(amountTextBox);
	}
	
	public WebElement getAmountValue()
	{
		return driver.findElement(amountValue);
	}
	
	public WebElement getPayBtn()
	{
		return driver.findElement(payButton);
	}

}
