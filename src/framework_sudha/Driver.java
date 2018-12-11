package framework_sudha;

import org.openqa.selenium.WebDriver;

public class Driver {
	private static ThreadLocal<WebDriver> D=new ThreadLocal<>();
	public static void set(WebDriver data) {
		D.set(data);
	}
	public static  WebDriver get() {
		
		return D.get();
	}
}
