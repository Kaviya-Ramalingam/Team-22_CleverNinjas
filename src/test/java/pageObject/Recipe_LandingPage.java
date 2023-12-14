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
	List<WebElement> AtoZPagination;
	
	@FindBy(xpath = "//div[@id='maincontent']/div[1]/div[2]/a")
	List<WebElement> NumbersPagination;

	@FindBy(xpath = "//div/div[@class='rcc_recipecard'][1]//div[2]/span")
	List<WebElement> RecipeID;

	@FindBy(xpath = "//div/div[@class='rcc_recipecard'][1]/div[3]/span/a")
	List<WebElement> RecipeName;

	public void clickRecipeAtoZ() {
		RecipeAtoZ.click();
	}

	public List<WebElement> AtoZPagination() {
		return AtoZPagination;
	}

	public List<WebElement> NumbersPagination() {
		return NumbersPagination;
	}
	
	public List<WebElement> RecipeID() {
		return RecipeID;
	}

	public List<WebElement> RecipeName() {
		return RecipeName;
	}
		
	public int AtoZPaginationSize() {
		int sizeOfAtoZPagination = AtoZPagination.size();
		return sizeOfAtoZPagination;
	}
	
}