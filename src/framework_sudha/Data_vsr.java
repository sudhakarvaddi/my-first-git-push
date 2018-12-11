package framework_sudha;

import java.util.HashMap;

import org.w3c.dom.Document;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Data_vsr {
	private static ThreadLocal<Data_vsr> D=new ThreadLocal<>();
	
	public static void set(Data_vsr data) {
		D.set(data);
	}
	public static Data_vsr get() {
		
		return D.get();
	}

		public static  Document objectrepository;
		public static   HashMap<String, String> envconfig;
		public ExtentHtmlReporter htmlReporter;
		public HashMap<String , String> executionConfigData;
	
		public ExtentReports extentReport;
		
	

}
