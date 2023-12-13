package pageObject;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage  extends BaseTest{
	

	WebDriver driver;

	
	public RecipeDetailsPage(WebDriver driver) {
	
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
}
	


