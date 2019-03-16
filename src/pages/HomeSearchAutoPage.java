package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.Page;

public class HomeSearchAutoPage extends Page {
	
	@FindBy(xpath="//input[@title='Search']")
	public WebElement googleSearchAuto;
			
	 @FindBys(@FindBy(xpath="//ul[@role='listbox']//li"))
     private List<WebElement> googleSearchAutoList;

     public List<WebElement> getGoogleSearchAutoList() {
         return googleSearchAutoList;
     }
     
	// Initializing the Page Objects:
	public HomeSearchAutoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String googleTitle() {
		return driver.getTitle();
	}
	
	public boolean googleSearchBoxisPresent() {
		try {
	        driver.findElement(By.xpath("//input[@title='Search']"));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	public static void tearDown() {
	driver.quit();
	}
	
}
