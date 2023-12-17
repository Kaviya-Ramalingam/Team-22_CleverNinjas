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
	public WebElement RecipeAtoZ;
	@FindBy(xpath = "//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]/a")
	public List<WebElement> AtoZPagination;
	@FindBy(xpath = "//div[@id='maincontent']/div[1]/div[2]/a")
	public List<WebElement> NumbersPagination;
	@FindBy(xpath = "//div[@class='rcc_recipecard']")
	public List<WebElement> RecipeID;
	@FindBy(xpath = "//span[@class='rcc_recipename']/a")
	public List<WebElement> RecipeName;
	@FindBy(xpath = "//div[@class='rcc_recipecard']")
	public List<WebElement> Recipecard;
	@FindBy(xpath = "//time[@itemprop='prepTime']")
	public List<WebElement> preparationTime;
	@FindBy(xpath = "//time[@itemprop='cookTime']")
	public List<WebElement> cookingTime;
	
	int paginationsize;

	public void clickRecipeAtoZ() {
		RecipeAtoZ.click();
	}

	public List<WebElement> AtoZPagination() {
		return AtoZPagination;
	}

	public List<WebElement> NumbersPagination() {
		return NumbersPagination;
	}

	public String getRecipeID(int k) {
		String recipeId = RecipeID.get(k).getAttribute("id");
		String[] RecipeID = recipeId.split("p");
		System.out.println("RecipeID: " + RecipeID[1]);
		return recipeId;
	}

	public int AtoZPaginationSize() {
		int sizeOfAtoZPagination = AtoZPagination.size();
		return sizeOfAtoZPagination;
	}

	public String getUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Recipe Url :" + url);
		return url;
	}

	public int RecipecardSize() {
		return Recipecard.size();
	}

	public int RecipeNameSize() {
		return RecipeName.size();
	}

	public int RecipeIDSize() {
		return RecipeID.size();
	}

}
