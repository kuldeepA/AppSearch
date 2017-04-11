package com.fji.browser;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ReadBrowser {

	public void readBrowser(){
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://proj.extsp.ford.com/sites/surveys/default.aspx");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("chrome.switches", Arrays.asList("–disable-extensions"));
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		capability.setCapability("chrome.binary", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"); 
		ChromeOptions options = new ChromeOptions();
		//profile path--options.addArguments("user-data-dir=C:/Users/user_name/AppData/Local/Google/Chrome/User Data/Default"); 
		WebDriver driver = new ChromeDriver(capability);
		//WebDriver driver = new ChromeDriver();//getDriver();
		
		
		
	   // String URL = "https://"+ "singhkuld" + ":" + "Kedar@0706" + "@" + "us.sso.covisint.com/jsp/preLogin.jsp?host=https://fim.covisint.com&CT_ORIG_URL=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F&ct_orig_uri=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F";
		String URL = "https://fim.covisint.com/ap/ford?ip=WslIP%3D103.6.88.27&TARGET=https%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25253FRootFolder%25253D%2525252Fsites%2525252Fsurveys%2525252FWorkshop%25252520Surveys%2525252FLevel%25255F0%25255FSurveys%2525252FAssessment%25252520Completed%252526FolderCTID%25253D0x0120000BEAE5696855E24C9A12791FA6692802%252526View%25253D%25257B87F6CB5C%25252DC981%25252D41E4%25252D979D%25252D3DED8C354885%25257D";
	    driver.get(URL);
	    driver.findElement(By.id("user")).sendKeys("singhkuld");
		driver.findElement(By.id("password")).sendKeys("Kedar@0706");
		
	   // driver.manage().window().maximize();
	    driver.findElement(By.name("login]")).click();
	 
	//    driver.manage().window().
	}
	public static void main(String[] args) {
		
		new ReadBrowser().readBrowser();
	}
}
