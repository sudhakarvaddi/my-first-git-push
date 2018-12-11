package framework_sudha;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Vsr extends UtilityMethods_vsr {

	static WebDriver driver = null;
	static String FullName = "sudha";
	static String mail = "Rediffmail";

	@Test
	public static void main() {

		driver.findElement(UtilityMethods_vsr.get().get_By_fromRep("userName")).sendKeys("ram");
	}

	@BeforeTest
	public static void LaunchBrowser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENETER BROWSER : ");
		String sr = sc.nextLine();
		switch (sr.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			break;
		}

	}

	/*
	 * public static void sudha() {
	 * 
	 * System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe" );
	 * 
	 * driver= new ChromeDriver(); driver.get(
	 * "https://register.rediff.com/register/register.php?FormName=user_details");
	 * 
	 * driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys(
	 * FullName);
	 * driver.findElement(By.xpath(("//input[starts-with(@name,'login')]"))).
	 * sendKeys(mail); //driver.findElement(By.xpath(
	 * "//td[@valign='top']/following-sibling::td[2]/input")).sendKeys(mail);
	 * WebElement element=driver.findElement(By.
	 * xpath("//td[text()='Date of Birth']/following-sibling::td[2]/select[2]"));
	 * List<WebElement> sudha=element.findElements(By.tagName("option")); String
	 * gen="f"; for(WebElement elem:sudha) { String day=elem.getText();
	 * if(day.equalsIgnoreCase("feb")) {
	 * 
	 * elem.click(); break; }
	 * driver.findElement(By.xpath("//td[@colspan='3']//input[@value="+"'"+gen+"'"+
	 * "]")).click(); }
	 * 
	 * // driver.findElement(By.xpath(
	 * "//td[@colspan='3']//following-sibling::option[@value=29]")).click();
	 * /*WebElement element=driver.findElement(By.
	 * xpath("//td[text()='Date of Birth']/following-sibling::td[2]/select"));
	 * Select elm= new Select(element); elm.selectByVisibleText("23");
	 * 
	 * clickOnEnter(By.
	 * xpath("//td[@colspan='3']/input[@value='Create my account >>']"));
	 * acceptTheAletr();
	 * clickOnF1(By.xpath("//td[@colspan='3']//input[@value="+"'"+gen+"'"+"]"));
	 * 
	 * }
	 */
	public static void clickOnEnter(By by) {
		WebElement element = driver.findElement(by);
		element.sendKeys(Keys.ENTER);

	}

	public static void clickOnF1(By by) {
		WebElement element = driver.findElement(by);
		element.sendKeys(Keys.F1);

	}

	public static void acceptTheAletr() {
		Alert A = driver.switchTo().alert();
		if (A != null) {
			A.accept();
		} else {
			System.out.println("no alert");
		}

	}

}
