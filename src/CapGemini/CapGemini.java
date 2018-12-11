package CapGemini;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CapGemini {
	
	public static WebDriver driver;
	public static void main(String[] args) {
//		Q1();
//		Q2();
//		Q4();
		Q5();
	}
	public static void Q1() {
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("file:///C:/Users/rayap/Desktop/chaithu.html");
			driver.manage().window().maximize();
			
			WebElement genderRadio= driver.findElement(By.xpath("//input[@name='gender']"));
			if(genderRadio.isEnabled()) {
			if(genderRadio.isDisplayed()) {   //True if elemenet is displayed on UI
				if(genderRadio.isSelected()) {
					System.out.println("Radio button is already selected");
				}else {
					genderRadio.click();
				}
			}else {System.out.println("Elemenet is not displayed in the UI");}
			}else {System.out.println("Element is not present in the page");}
	}
	public static void Q2() {
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		WebElement gmail= driver.findElement(By.xpath("//a[@class='gb_P' and text()='Gmail']"));
		String URL =gmail.getAttribute("href");
		System.out.println(URL);

	}
	public static void Q3() {
		//input[@value='Login']  to identify the Login button uniquely
		
	}
	public static void Q4() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://freecrm.com/index.html");
		WebElement uname=driver.findElement(By.name("username"));
		uname.clear();
		uname.sendKeys("rayapatichaithu");
		WebElement pwd=driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("Chaithu@408");
		WebElement logBtn =driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", logBtn);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//ul[@class='mlddm']//a[@title='Companies']")).click();
		WebElement selectelem= driver.findElement(By.xpath("//select[@name='cs_category']"));
		Select s= new Select(selectelem);
		List<WebElement>opts=s.getOptions();
		for(WebElement e: opts) {
			System.out.println(e.getText());
		}
	}
	public static void Q5() {
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		List<WebElement> row =driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		System.out.println("No: rows are: "+row.size());
	}

	public static void Q6() {
		WebDriverWait Ewait=new WebDriverWait(driver, 5000);
		Ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("LoginButton"))));
	}
	
	public static void Q7() {
		WebElement ele= driver.findElement(By.id("label1"));
		Actions a = new Actions(driver);
		a.doubleClick(ele);
		
	}
	public static void Q8() {
		driver.switchTo().frame("top");
		driver.findElement(By.name("first_name")).sendKeys("INDIA");
		driver.switchTo().frame("main");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	public static void Q9() {
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest= new File("I_Practise//ExecutionResults//ScreenShots//Question10.png");
		try {
			FileUtils.moveFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Q10() {
		Alert a = driver.switchTo().alert();
		a.sendKeys("Hello World"); // To enter the Text
		a.dismiss(); // To cancel the alert
	}
	
	public static void Q11() {
		driver.manage().deleteCookieNamed("RiskFort");
	}
	public static void Q12() {
		WebElement elem= driver.findElement(By.id("button1"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", elem);
	}
	

	
	
	

}

