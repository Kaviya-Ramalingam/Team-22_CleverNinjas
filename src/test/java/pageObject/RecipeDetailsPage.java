package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage  extends BaseTest{
	

	WebDriver driver;

	
	public RecipeDetailsPage(WebDriver driver) {
	
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
}
	


