package com.fji.browser;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import com.fji.core.WaveUtils;

public class Browser {

	public WebDriver openURL(){
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("chrome.switches", Arrays.asList("–disable-extensions"));
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		capability.setCapability("chrome.binary", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"); 
		ChromeOptions options = new ChromeOptions();
		//profile path--options.addArguments("user-data-dir=C:/Users/user_name/AppData/Local/Google/Chrome/User Data/Default"); 
		WebDriver driver = new ChromeDriver(capability);
		
	    // String URL = "https://"+ "singhkuld" + ":" + "Kedar@0706" + "@" + "us.sso.covisint.com/jsp/preLogin.jsp?host=https://fim.covisint.com&CT_ORIG_URL=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F&ct_orig_uri=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F";
		String URL = "https://fim.covisint.com/ap/ford?ip=WslIP%3D103.6.88.27&TARGET=https%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25253FRootFolder%25253D%2525252Fsites%2525252Fsurveys%2525252FWorkshop%25252520Surveys%2525252FLevel%25255F0%25255FSurveys%2525252FAssessment%25252520Completed%252526FolderCTID%25253D0x0120000BEAE5696855E24C9A12791FA6692802%252526View%25253D%25257B87F6CB5C%25252DC981%25252D41E4%25252D979D%25252D3DED8C354885%25257D";
	    driver.get(URL);
	    driver.findElement(By.id("user")).sendKeys("singhkuld");
		driver.findElement(By.id("password")).sendKeys("Kedar@0706");
	  
	    driver.findElement(By.name("login")).submit();
	 //   driver.manage().window().maximize();
	//    driver.manage().window().
	    return driver;
	}
	
	@Autowired
	//WaveUtils utils;
	public Map<Integer, String> readURL(WebDriver driver) {
		
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]"))).click().perform();
		
		//WebElement divClick = driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]"));//("//div[@class='form_row']/div");
		//divClick.click();
		//driver.findElement(By.name("msomenuid2")).click();
		/*WebElement dropdown = driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]/a"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Descending");*/
		
		//driver.manage().window().maximize();
		//String s = driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]/a")).getText();
		//new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("selectize-dropdown-content")));
		//for (int i=2; i<32; i++) {
		int count = 2;
		int index = 2;try {
		while(true) {		
			
			if ((driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText() != null)) {
				map.put(WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText()) 
					, (WaveUtils.getValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[4]/nobr")).getText() 
					, ""/*driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+i+"]/td[5]/span/a")).getText()*/)));
				if(count != 31)
					new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+(count+1)+"]/td[4]/nobr")));
				System.out.println(count);
			} else {
				System.out.println("loop break");
				break;
			}
			if (count == 31 && index == 2) {
				System.out.println("index"+count);
				index = 3; // in next index got change to 3
				count = 1; //in next page count will again start with 2
				driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[2]/a")).click();
			} else if (count == 31 && index == 3) {
				count = 1; //in next page count will again start with 2
				driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[3]/a")).click();
			}			
			
			count++;
		}
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			
		}
		catch( org.openqa.selenium.TimeoutException tEx) {
			
		}
		//Select dropdown = new Select(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]/a")));
		//System.out.println(map.size());
		/*for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "--" +entry.getValue());
		}*/
		//driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[2]/a")).click();
		return map;
	}	
}