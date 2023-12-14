package pageObject;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class Recipe_LandingPage extends BaseTest {

	WebDriver driver;
	Properties prop;

	public Recipe_LandingPage(WebDriver driver, Properties prop) {

		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Recipea A to Z']")
	WebElement RecipeAtoZ;

	@FindBy(xpath = "//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]/a")
	List<WebElement> AtoZ_pagination;
	
	@FindBy(xpath = "//div[@id='maincontent']/div[1]/div[2]/a")
	List<WebElement> numbers_pagination;

	@FindBy(xpath = "//div/div[@class='rcc_recipecard'][1]//div[2]/span")
	List<WebElement> RecipeID;

	@FindBy(xpath = "//div/div[@class='rcc_recipecard'][1]/div[3]/span/a")
	List<WebElement> RecipeName;

	public void clickRecipeAtoZ() {
		RecipeAtoZ.click();
	}

	public List<WebElement> AtoZ_pagination() {
		return AtoZ_pagination;
	}

	public List<WebElement> numbers_pagination() {
		return numbers_pagination;
	}
	
	public List<WebElement> RecipeID() {
		return RecipeID;
	}

	public List<WebElement> RecipeName() {
		return RecipeName;
	}
		
	public int AtoZPaginationSize() {
		int sizeOfAtoZ_pagination = AtoZ_pagination.size();
		return sizeOfAtoZ_pagination;
	}
	
}