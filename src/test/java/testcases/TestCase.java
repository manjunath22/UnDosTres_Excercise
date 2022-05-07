package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.PaymentPage;
import pageobjects.RechargePage;
import resources.Base;
import utilities.ExcelUtils;

public class TestCase extends Base {
	
	public WebDriver driver;
	WebDriverWait wait;
	RechargePage recharge;
	PaymentPage pay;
	ExcelUtils excel;
	String excelPath=System.getProperty("user.dir")+"\\TestData\\Data.xlsx";
	String sheetName="Testdata";
	
    String phoneNo;
    String cardNo;
    String month;
    String year;
    String Cvv;
    String email;
    String modalEmail;
    String modalPassword;
    
	JavascriptExecutor executor;
	String expectedRechargeMessage="¡Recarga Exitosa!";
	String paymentPageTitle="undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass";
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_001() throws Exception
	{
		 executor = (JavascriptExecutor) driver;
		 recharge=new RechargePage(driver);
		 pay=new PaymentPage(driver);
		 excel=new ExcelUtils();
		 phoneNo=excel.getCellData(excelPath,sheetName,1,0);
		
		 recharge.getOperator().click();
		recharge.getOperatorValue().click();
		
		recharge.setMobileTextBox(phoneNo);
		
	    recharge.getAmountTextBox().click();
		
		recharge.getAmountValue().click();
		
		recharge.getPayBtn().click();
		
		
		String currentPageTitle=driver.getTitle();
		Assert.assertEquals(paymentPageTitle,currentPageTitle);
		
		pay.getCardBtn().click();
		
		pay.getNewCardButton().click();
		
		cardNo=excel.getCellData(excelPath,sheetName,1,1);
		pay.setCardNumber(cardNo);
		
		
		executor.executeScript("arguments[0].click();",pay.getMonth());	
		
		month=excel.getCellData(excelPath,sheetName,1,2);
		pay.setMonth(month);	
		
		year=excel.getCellData(excelPath,sheetName,1,3);
		pay.setYear(year);
		
		Cvv=excel.getCellData(excelPath,sheetName,1,4);
		pay.setCvv(Cvv);
		
		email=excel.getCellData(excelPath,sheetName,1,5);
		pay.setEmail(email);
		pay.getPayBtn().click();
		
		modalEmail=excel.getCellData(excelPath,sheetName,1,6);
		pay.setModalEmail(modalEmail);
		
		modalPassword=excel.getCellData(excelPath,sheetName,1,7);
		pay.setModalPassword(modalPassword);
		
		executor.executeScript("arguments[0].scrollIntoView(true)", pay.getAccessBtn());
		
		pay.getCaptcha().click();
		
		pay.getAccessBtn().click();
		
		
		try
		{
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.presenceOfElementLocated(pay.modalContinue));
			pay.getModalContinue().click();
		}
		catch(Exception e)
		{
		
		}
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(pay.alert));
		
	 	pay.getAlert().click();
	
	
		WebElement status=pay.getMessage();
		String actualRechargeMessage=status.getText();
		Assert.assertEquals(expectedRechargeMessage,actualRechargeMessage);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
