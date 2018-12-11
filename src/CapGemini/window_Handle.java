package CapGemini;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_Handle {
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		// broken_Links();

		//multiple_Windows_Handles();

		reverse_String_BYArrayList();

	}

	public static void multiple_Windows_Handles() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:/Naukri.com");
		String maiwindowhandle = driver.getWindowHandle();
		Set<String> all_ids = driver.getWindowHandles();
		for (String al : all_ids) {
			driver.switchTo().window(al);
			String allTitles = driver.getTitle();
			if (allTitles.contains("Fullerton")) {

				driver.switchTo().window(maiwindowhandle);

			} // System.out.println(al);

		}

	}

	public static void broken_Links() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:/Naukri.com");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActive(url);
		}

		
	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			} else if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("link is NOT FOUND");
		}

	}

	public static void reverse_String_BYArrayList() {
		String input = "sudhakar";
		char[] hello = input.toCharArray();
		List<Character> t = new ArrayList<>();

		for (char c : hello) {
			t.add(c);

			Collections.reverse(t);
			ListIterator li = t.listIterator();
			while (li.hasNext()) {
				System.out.print(li.next());

				
			}
				
		}
		
		
		
		ArrayList<Integer> ar= new ArrayList<>();
		
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		ar.add(4);
		ar.add(5);
		System.out.println("listof numbers:"+ ar);
		
		Set<Integer> withoutduplicates= new LinkedHashSet<>(ar);
	
		
		Set<Integer> ar2= new HashSet<>();
		ar2.addAll(withoutduplicates);
		withoutduplicates.clear();
		System.out.println("Withoutduplicates:"+ar2);
		
		
		
	
	
	
	
	}

	
	
	
	
	
	
	
}