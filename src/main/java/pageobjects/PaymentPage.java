package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
	
	private By cardButton=By.xpath("//*[@id=\"new-card-toggle\"]/div/p");
	private By newCardButton=By.xpath("//tr[@id=\"radio-n\"]/td/label/a/span");
	private By cardNumber=By.id("cardnumberunique");
	private By month=By.cssSelector("[data-qa=\"mes-input\"]");
	private By year=By.xpath("//span[@class='underline']/preceding-sibling::input[@name='expyear']");
	private By cvv=By.xpath("//input[@placeholder=\"CVV\"]");
	private By email=By.xpath("//input[contains(@class,'email')]");
	private By payButton=By.cssSelector("[id=\"paylimit\"]");
	private By modal=By.xpath("//div[@id=\"login\"]/div/div[@class=\"modal-dialog\"]");
	private By modalEmail=By.id("usrname");
	private By modalPassword=By.id("psw");
	private By accessButton=By.xpath("//button[@id=\"loginBtn\"]");
	private By captcha=By.xpath("//iframe[@title=\"reCAPTCHA\"]");
	public By alert=By.cssSelector("[class=\"wzrk-alert wiz-show-animate\"]");
	private By message=By.xpath("//div[@class=\"visual-message\"]");
	public By modalContinue=By.xpath("//div[@id=\\\"recentPhoneRecharge\\\"]/div/div[@class='modal-content']");
	
	
	public WebDriver driver;

	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getCardBtn()
	{
		return driver.findElement(cardButton);
	}
	
	public WebElement getNewCardButton()
	{
		return driver.findElement(newCardButton);
	}
	
	public void setCardNumber(String str)
	{
		driver.findElement(cardNumber).sendKeys(str);
	}
	
	public WebElement getMonth()
	{
		return driver.findElement(month);
	}
	
	public void setMonth(String str)
	{
		driver.findElement(month).sendKeys(str);
	}
	
	public void setYear(String str)
	{
		driver.findElement(year).sendKeys(str);
	}
	
	public void setCvv(String str)
	{
		driver.findElement(cvv).sendKeys(str);
	}
	
	public void setEmail(String str)
	{
		driver.findElement(email).sendKeys(str);
	}
	
	public WebElement getPayBtn()
	{
		return driver.findElement(payButton);
	}
	
	public WebElement getModal()
	{
		return driver.findElement(modal);
	}
	
	public void setModalEmail(String str)
	{
		 getModal().findElement(modalEmail).sendKeys(str);
	}
	
	public void setModalPassword(String str)
	{
		 getModal().findElement(modalPassword).sendKeys(str);
	}
	
	public WebElement getAccessBtn()
	{
		return driver.findElement(accessButton);
	}
	
	public WebElement getCaptcha()
	{
		return driver.findElement(captcha);
	}
	
	public WebElement getAlert()
	{
		return driver.findElement(alert);
	}
	
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
	
	public WebElement getModalContinue()
	{
		return driver.findElement(modalContinue);
	}
}
