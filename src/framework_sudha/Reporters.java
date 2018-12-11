package framework_sudha;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporters {
	public void initiateReport(ITestContext ctx) throws IOException{
		
		 UtilityMethods_vsr.get().makePath(System.getProperty("user.dir")+Data_vsr.get().executionConfigData.get("screenshotPath"));
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String extentreportPath = System.getProperty("user.dir")+"\\"+Data_vsr.get().executionConfigData.get("extentReportPath") +"\\" + ctx.getSuite().getName() + " - " + timeStamp +".html";
		 Data_vsr.get().htmlReporter = new ExtentHtmlReporter(extentreportPath);
		 Data_vsr.get().extentReport = new ExtentReports();
		 Data_vsr.get().extentReport.attachReporter( Data_vsr.get().htmlReporter);
		 try {
			 Data_vsr.get().extentReport.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
			 Data_vsr.get().extentReport.setSystemInfo("IP Address", InetAddress.getLocalHost().getHostAddress());
			 Data_vsr.get().extentReport.setSystemInfo("User Name", System.getProperty("user.name"));	
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		}
		 Data_vsr.get().htmlReporter.config().setDocumentTitle("Execution results for Suit : " + ctx.getSuite().getName() + " - " + timeStamp );
		 Data_vsr.get().htmlReporter.config().setReportName("Report for Test : " + ctx.getSuite().getName());
		 Data_vsr.get().htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 Data_vsr.get().htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
}


