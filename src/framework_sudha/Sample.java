package framework_sudha;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class Sample {
	static WebDriver driver2;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver2=new ChromeDriver();
		m1();
		m2();
		}
	public static void m1() {
		
		driver2.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		//driver2.findElement(By.xpath("//table[@class='dataTable']"));
		
		List columns=driver2.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		
		System.out.println("No of Colums are:"+columns.size());
		 
        List rows=driver2.findElements(By.xpath("//*[@id='leftcontainer']//table[@class='dataTable']//tbody//tr"));
		
		System.out.println("No of rows are : " + rows.size());	
		}
	
	public static void m2() {
		driver2.get("https://www.zkoss.org/zkdemo/listbox/load_on_demand;jsessionid=13A2B437594C7F835E6A8DD2C1306078");
		
	
		
	}
	
	
	
	
	

}