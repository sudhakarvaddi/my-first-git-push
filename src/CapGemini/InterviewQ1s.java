package CapGemini;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewQ1s {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		//q1();
		q2();
	}

	public static void q1() {

		driver.get("https://material.angularjs.org/latest/demo/radioButton");
		driver.manage().window().maximize();
		WebElement radiobutton = driver.findElement(By.xpath("//*['md-radio-button' and @id='radio_21']"));
		if (radiobutton.isEnabled()) {

			if (radiobutton.isDisplayed()) {
				if (radiobutton.isSelected()) {
					System.out.println("radiobutton is  already selected");
				} else {
					radiobutton.click();

				}
			} else {
				System.out.println("radio button is  not  in the  in the displayed UI ");

			}
		} else {
			System.out.println("radio button is not displayed");
		}
	}

	public static void q2() {
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		 
		WebElement hyperlink=driver.findElement(By.xpath("//input[@type='submit']"));
		 String str=hyperlink.getTagName();
			System.out.println(str);

	}

}
