package com.fji.browser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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

import com.fji.core.Constants;
import com.fji.core.WaveUtils;
import com.fji.read.Read;
import com.fji.write.WriteRecords;

public class Browser {
	
	/*Map<String,String> defaultMap = null;
	public Browser() {
		
		try {
			defaultMap = new Read().readApplication();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	Map<String,String> defaultMap = null;	
	public WebDriver openURL(){
		
		//Map<String,String> defaultMap = null;
		try {
			defaultMap = new Read().readApplication();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("chrome.switches", Arrays.asList("–disable-extensions"));
		//System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", Browser.class.getResource(Constants.WINDOW_CHROME_DRIVER).getFile());
		capability.setCapability("chrome.binary", Constants.WINDOW_CHROME_EXE); 
		ChromeOptions options = new ChromeOptions();
		//profile path--options.addArguments("user-data-dir=C:/Users/user_name/AppData/Local/Google/Chrome/User Data/Default"); 
		WebDriver driver = new ChromeDriver(capability);
		
	    // String URL = "https://"+ "singhkuld" + ":" + "Kedar@0706" + "@" + "us.sso.covisint.com/jsp/preLogin.jsp?host=https://fim.covisint.com&CT_ORIG_URL=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F&ct_orig_uri=%2Fap%2Fford%3Fip%3DWslIP%3D103.6.88.27%26TARGET%3Dhttps%3A%2F%2Fproj.extsp.ford.com%2F_layouts%2FFord%2Fcustomlogin.aspx%3FReturnUrl%3D%252fsites%252fsurveys%252f_layouts%252fAuthenticate.aspx%253fSource%253d%25252Fsites%25252Fsurveys%25252Fdefault%25252Easpx%25252F";
		//String URL = "";
	    driver.get(Constants.URL);
	    driver.findElement(By.id("user")).sendKeys(defaultMap.get("loginId").trim());
		driver.findElement(By.id("password")).sendKeys(defaultMap.get("password").trim());
	  
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
		int index = 2;
		String record = null;
		boolean firstR = true;
		try {
			while(true) {		
			
				if ((driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText() != null)) {
					if (!map.containsKey(WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText()))) {
						
						if(firstR) {
							record = WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText().toString())
								+" "+WaveUtils.getValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[4]/nobr")).getText(),"");
							firstR = false;
						}
						map.put(WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText()) 
							, (WaveUtils.getValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[4]/nobr")).getText() 
									, ""/*driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+i+"]/td[5]/span/a")).getText()*/)));
					} else {
					
						String existsValue = map.get(WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText()));
						map.put(WaveUtils.getIntValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[3]/div[1]/a")).getText()) 
								, (WaveUtils.getValue(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+count+"]/td[4]/nobr")).getText() 
										,existsValue+" || ")));
					}						
					 
					if(count != 31)
						new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr["+(count+1)+"]/td[4]/nobr")));
				} else
					break;
				if (count == 31 && index == 2) {
					
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
			driver.quit();
		}
		catch( org.openqa.selenium.TimeoutException tEx) {
			driver.quit();
		}
		//Select dropdown = new Select(driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[1]/tbody/tr/td/table/tbody/tr[1]/th[4]/div[1]/a")));
		//System.out.println(map.size());
		/*for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "--" +entry.getValue());
		}*/
		//driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[2]/a")).click();
		
		new WriteRecords().replace(record, defaultMap);
		//here we are writing 1st records in file
		/*FileWriter fw;
		try {
			fw = new FileWriter(Constants.APP_PATH);
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader br = new BufferedReader(new FileReader(Constants.APP_PATH));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				if (line.contains("Last Access Record"))
					line.repl//.replace("Last Access Record="+record);
			}
			//WriteRecords.writeToFile(bw,, value, "=");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return map;
	}	
}
