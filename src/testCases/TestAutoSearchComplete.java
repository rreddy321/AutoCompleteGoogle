package testCases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.TestHome;
import Pages.HomeSearchAutoPage;

public class TestAutoSearchComplete extends TestHome {
	
	HomeSearchAutoPage homeSearchAutoPage ;
	
	public TestAutoSearchComplete() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homeSearchAutoPage = new HomeSearchAutoPage() ;
	}
	
	@Test(priority=1)
	public void verifyGoogleAutoComplete() {
		
		int actualLength = 0;
		int expectedLength = 0;
		homeSearchAutoPage.googleSearchAuto.clear();
		homeSearchAutoPage.googleSearchAuto.sendKeys(searchString);
						
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> HomeSearchAutoList =  homeSearchAutoPage.getGoogleSearchAutoList();
		expectedLength = HomeSearchAutoList.size();		
		
		for(int i = 0 ;i < HomeSearchAutoList.size();i++)
		{				
			if(HomeSearchAutoList.get(i).getText().contains(searchString))
			{
				actualLength += 1;
			}
		}

        Assert.assertEquals(actualLength, expectedLength); 
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}


