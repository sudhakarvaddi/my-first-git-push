
package framework_sudha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CommonMethods_vsr extends Configuration_vsr {
	private static ThreadLocal<CommonMethods_vsr> E=new ThreadLocal<>();
	public static void set(CommonMethods_vsr data) {
		E.set(data);
	}
	public static CommonMethods_vsr get() {
		

		return E.get();
	}
	@Parameters("browser")
	@BeforeTest
	public  void launchBrowserAndApplication(@Optional String browser) {
		
	
		UtilityMethods_vsr.set(new UtilityMethods_vsr());
		Events_vsr.set(new Events_vsr());
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		Driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
			Driver.set(new FirefoxDriver());
			break;
		default:
			break;
		}
		Driver.get().get(Data_vsr.envconfig.get("url"));
	}
	
	@BeforeMethod
	public static void logIn() {
		
	
		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("userName"), Data_vsr.envconfig.get("username"));
		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("userPassword"), Data_vsr.envconfig.get("userpassword"));
		WebElement element=Events_vsr.get().waitForElement(UtilityMethods_vsr.get().get_By_fromRep("userLogin"), 20);
		element.sendKeys(Keys.ENTER);
	
}
	@AfterMethod
	public static void logout() {
		Events_vsr.get().clickingElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']"));
		Driver.get().close();

	}
	}
