package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Pages.TestHome;

public class HomeSearchAutoPage extends TestHome {
	
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
}
