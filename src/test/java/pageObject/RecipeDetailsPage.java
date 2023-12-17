package pageObject;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage extends BaseTest {

	WebDriver driver;
	Properties prop;

	public RecipeDetailsPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;

		PageFactory.initElements(driver, this);
	}
	// div[@id=‘rcpnuts’]--table with upper data
	// table[@id=‘rcpnutrients’]--only for table

	@FindBy(xpath = "")
	public List<WebElement> FoodCategory;
	@FindBy(xpath = "")
	public List<WebElement> ingredients;
	@FindBy(xpath = "")
	public List<WebElement> preparationMethod;
	@FindBy(xpath = "//div[@id=‘recipe_nutrients’]")
	public List<WebElement> nutrientValues;

	// table[@id='rcpnutrients']/tbody
//			@FindBy(xpath= “//div[@id=‘recipe_nutrients’]/div[1]//table/tbody”)
//			public List<WebElement> nutrientValues;

//			@FindBy(xpath= “//span[@itemprop=‘nutrition’]“)
//			List<WebElement> nutrientValues;

	

	/*
	 * public String getFoodCategory() { // not having xpath for this variable if
	 * (!foodCategory.isEmpty()) { String categoryOfFood =
	 * foodCategory.get(0).getText(); System.out.println("Category of food: "); }
	 * return categoryOfFood ;
	 * 
	 * }
	 */

	/*
	 * public String getIngredients() { if (!ingredients.isEmpty()) { String
	 * ingredientsName = ingredients.get(0).getText();
	 * System.out.println("ingredients name " + ingredients.get(0).getText());
	 * 
	 * }
	 * 
	 * }
	 */
	public String preparationMethod() {
		if (!preparationMethod.isEmpty()) {
			System.out.println("ingredientmethod " + preparationMethod.get(0).getText());
			methodName = preparationMethod.get(0).getText();
		}
		return methodName;
	}

	public String getNutrientValues() {
		if (!nutrientValues.isEmpty()) {
			System.out.println("NutrientValue:  " + nutrientValues.get(0).getText());
			// System.out.println(“NutrientValue:”
			// +nutrientValues.get(0).getAttribute("tbody"));
			nutrientValue = nutrientValues.get(0).getText();
//				}else {
//					System.out.println(“NutrientValue not found:“);

		}
		return nutrientValue;

	}

	public String getPreparationTime() {
		if (!preparationTime.isEmpty()) {
			String preparingTime = preparationTime.get(0).getText();
			System.out.println("preparationTime " + preparationTime.get(0).getText());

		}
		return preparingTime;
	}

	public String cookingTime() {
		if (!cookingTime.isEmpty()) {
			Strig cookTime = cookingTime.get(0).getText();
			System.out.println("cookingTime " + cookingTime.get(0).getText());
			
		}
		return cookTime;
	}
}

/*
 * @FindBy(css = "a[title='Recipea A to Z']") WebElement recipeAtoZ;
 * //@FindBy(xpath =
 * "//table[@class='mnualphaitem ctl00_cntleftpanel_mnuAlphabets_4']/tbody/tr/td/a"
 * ) //@FindBy(xpath =
 * "//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]/a") //public
 * List<WebElement> AtoZ_pagination;
 * 
 * @FindBy(
 * xpath="//a[contains(@class,'ctl00_cntleftpanel_mnuAlphabets_1 mnualphaitem ctl00_cntleftpanel_mnuAlphabets_3')]"
 * ) public List<WebElement> AtoZ_pagination;
 * 
 * @FindBy(xpath = "//div[@id='maincontent']/div[1]/div[2]/a") public
 * List<WebElement> numbers_pagination;
 * 
 * //@FindBy(xpath="//div[3]/span[1]/a")
 * 
 * @FindBy(xpath="//span[@class='rcc_recipename']/a") public List<WebElement>
 * recipeName;
 * 
 * //@FindBy(xpath = "//div/div[@class='rcc_recipecard'][1]//div[2]/span")
 * 
 * @FindBy(
 * xpath="//div[@class='rcc_recipecard']/div[2]/span | //div[@class='rcc_recipecard']/s/div[2]/span"
 * ) public List<WebElement> RecipeID;
 * 
 * @FindBy(xpath="//div[@class='rcc_recipecard']") public List<WebElement>
 * recipeCard;
 * 
 * @FindBy(xpath = "//div[@id='recipe_small_steps']") List<WebElement>
 * preparationMethod;
 * 
 * @FindBy(xpath = "//div[@id='recipe_nutrients']") List<WebElement>
 * nutrientValues;
 * 
  * 
 * }
 */
