package framework_sudha;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Events_vsr {

	private static ThreadLocal<Events_vsr> E = new ThreadLocal<>();

	public static void set(Events_vsr data) {
		E.set(data);
	}

	public static Events_vsr get() {

		return E.get();
	}

	public void inputfields(By by, String Value) {
		WebElement element = Driver.get().findElement(by);
		element.clear();
		element.sendKeys(Value);
	}

	public void clickingElement(By by) {
		try {
			WebElement element = Driver.get().findElement(by);
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println("element is not found");
		} catch (NullPointerException e) {
			System.out.println("null pointer exception ");
		}

	}

	public void clickingElementsbyVisibleText(By by, String valueToselect) {
		List<WebElement> element = Driver.get().findElements(by);
		for (WebElement elem : element) {
			String value = elem.getText();
			if (value.equalsIgnoreCase(valueToselect)) {
				elem.click();
				break;
			}

		}

	}

	public static void mouseover(By by) {
		Actions a = new Actions(Driver.get());
		WebElement element = Driver.get().findElement(by);
		a.moveToElement(element);
	}

	public static void doubleClick(By by) {
		Actions a = new Actions(Driver.get());
		WebElement element = Driver.get().findElement(by);
		a.doubleClick(element);

	}

	public static void rightClick(By by) {
		Actions a = new Actions(Driver.get());
		WebElement element = Driver.get().findElement(by);
		a.contextClick(element);

	}

	public static void clickOnEnter(By by) {
		WebElement element = Driver.get().findElement(by);
		element.sendKeys(Keys.ENTER);
	}

	public static void acceptTheAlert(By by) {
		Alert A = (Alert) Driver.get();

		A.accept();

	}

	public static void cancleTheAlert(By by) {
		Alert A = (Alert) Driver.get();
		A.dismiss();
	}

	public WebElement waitForElement(By by, int maxTime) {
		WebDriverWait wait = new WebDriverWait(Driver.get(), maxTime);
		wait.pollingEvery(Duration.ofMillis(300));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public static void waitForPageload(int maxTime) {
		try {
			Driver.get().wait(maxTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
