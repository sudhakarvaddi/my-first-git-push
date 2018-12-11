



package framework_sudha;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UtilityMethods_vsr {
	private static ThreadLocal<UtilityMethods_vsr> U=new ThreadLocal<>();
	public static void set(UtilityMethods_vsr data) {
		U.set(data);
	}
	public static UtilityMethods_vsr get() {
		
		return U.get();
	}
	public  void makePath(String path){
		File f = new File(path);		
		if (!f.exists()){
			f.mkdirs();
		}
	}
	

	
	
	
	
	public  Document loadRepository(String repPath) {
		File f= new File(repPath);
		if(f.exists()) {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder db=dbf.newDocumentBuilder();
				Data_vsr.objectrepository=db.parse(f);
			} catch (ParserConfigurationException | SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		return Data_vsr.objectrepository;
	}
private static String[] getObjInfo(String objName) {

	String[] propCol=new String[2];
		NodeList propVal=Data_vsr.objectrepository.getElementsByTagName(objName);
		int val=propVal.getLength();
		if(val==0) {
			System.out.println("ERROR :  objects are not found by "+ objName);
			System.exit(0);
		}else if(val>1) {
				System.out.println("ERROR :  more then one objects are not found by "+ objName);
				System.exit(0);
			}else {
				 Element elm= (Element) propVal.item(0);
			if(elm.hasAttribute("locator")) {
				propCol[0]=elm.getAttribute("locator");
			}
			if(elm.hasAttribute("value")) {
				propCol[1]=elm.getAttribute("value");
			}
			}
		
		return propCol;
		}
	public   By get_By_fromRep(String objName) {
		By by=null;
		String [] value=getObjInfo(objName);
		switch (value[0].toLowerCase()) {
		case "id":
			by=By.id(value[1]);
			break;
		case "name":
			by=By.name(value[1]);
			break;
		case "xpath":
			by=By.xpath(value[1]);
			break;
		case "classname":
			by=By.className(value[1]);
			break;
		case "linktext":
			by=By.linkText(value[1]);
			break;
		case "partiallinktext":
			by=By.partialLinkText(value[1]);

			break;
		case "css":
			by=By.cssSelector(value[1]);
			break;
		default:
			break;
		}
		return by;

	}
//***************************************************************************************************************
	public  HashMap<String, String> readToMap(String filePath) {
		HashMap<String, String> allvalues= new HashMap<>();
		
		try {
			if(checkFile(filePath)) {
			FileInputStream fis= new FileInputStream(filePath);
			Properties props=new Properties();
			props.load(fis);
			Set<Object> allkeys=props.keySet();
			for(Object key:allkeys) {
			
				allvalues.put(key.toString(), props.getProperty(key.toString()));
			}	
		}else {
			System.out.println("the file does'nt exist ");
			System.exit(0);
			
		}
			}catch (IOException e) {
	
		}
		
		return allvalues;
	}
	
//******************************************************************************************************************
	private  boolean checkFile(String filePath) {
		boolean file=false;
		File f=new File(filePath);
		if(f.exists()) {
			file=true;
		}
		return file;	
	}
	
}
