package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestHome {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String searchString;
		
	public TestHome(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/data/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		searchString = prop.getProperty("searchKeyword");
	}
	
	
	public static void initialization(){
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/data/drivers/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("FireFox")){
			System.setProperty("webdriver.gecko.driver", "src/data/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}

