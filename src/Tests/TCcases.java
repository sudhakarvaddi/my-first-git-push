package Tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework_sudha.CommonMethods_vsr;
import framework_sudha.Data_vsr;
import framework_sudha.Driver;
import framework_sudha.Events_vsr;

import framework_sudha.UtilityMethods_vsr;

public class TCcases extends CommonMethods_vsr {

	@Test
	public static void dateSelect() {
		Driver.get().switchTo().frame(1);
		Events_vsr.get().clickingElementsbyVisibleText(UtilityMethods_vsr.get().get_By_fromRep("month"), "january");
		Events_vsr.get().clickingElementsbyVisibleText(UtilityMethods_vsr.get().get_By_fromRep("year"), "2018");
		Events_vsr.get().clickingElementsbyVisibleText(UtilityMethods_vsr.get().get_By_fromRep("day"), "20");

	}

	@Test
	public static void vsrDate() {
		Driver.get().switchTo().frame(1);
		Driver.get().findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/a")).click();
		Events_vsr.get().clickingElementsbyVisibleText(By.name("slctMonth"), "march");
		Events_vsr.get().clickingElementsbyVisibleText(By.name("slctYear"), "2017");
		Events_vsr.get().clickingElementsbyVisibleText(By.className("calendarcell"), "21");

	}

	@Test
	public static void menuButtons() {

		Driver.get().switchTo().frame(1);
		List<WebElement> elem = Driver.get().findElements(By.xpath("//div[@id='navMenu']//ul/li"));
		for (WebElement elm : elem) {
			String str = elm.getText();
			System.out.println(str);
		}

		List<WebElement> elet = Driver.get().findElements(
				By.xpath("//a[@href='https://www.freecrm.com/system/index.cfm?action=calendar&sub=default']"));

	}

	@Test(priority = 1)
	public static void messages() {
		Driver.get().switchTo().frame(1);
		Driver.get().findElement(By.xpath("//a[@title='Messages']")).click();

		WebElement ele = Driver.get().findElement(By.xpath("//tbody/tr/td[2][@class='datacardtitle']/input"));

		ele.click();

		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("subject"),
				Data_vsr.get().envconfig.get("value"));

		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("message"),
				Data_vsr.get().envconfig.get("value1"));

		WebElement element = Driver.get().findElement(By.xpath("//*[@id=\"CFForm_1\"]/input[6]"));
		JavascriptExecutor js = ((JavascriptExecutor) Driver.get());
		js.executeScript("arguments[0].click();", element);
		Driver.get().findElement(By.xpath("//a[@title='Messages']")).click();

		// ******************deleting created messages****************************//
		Driver.get().findElement(By.xpath("//tr[10]/td[4]//a[2]")).click();

		Alert a = Driver.get().switchTo().alert();
		a.accept();
	}

	@Test(priority = 2)
	public static void Resouces() {
		Driver.get().switchTo().frame(1);
//		Driver.get().manage().timeouts().pageLoadTimeout(2000,TimeUnit.MILLISECONDS);
		Events_vsr.get().clickingElement(UtilityMethods_vsr.get().get_By_fromRep("Resource"));
		// System.out.println("end");

		Events_vsr.get().clickingElement(UtilityMethods_vsr.get().get_By_fromRep("newresource"));
		Events_vsr.get().clickingElement(UtilityMethods_vsr.get().get_By_fromRep("link"));
		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("titleText"),
				Data_vsr.get().envconfig.get("value2"));

		Events_vsr.get().inputfields(UtilityMethods_vsr.get().get_By_fromRep("url"), Data_vsr.get().envconfig.get("value3"));
	}
}
