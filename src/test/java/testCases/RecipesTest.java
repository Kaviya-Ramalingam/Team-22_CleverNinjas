package pageObject;
import java.util.List;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseTest;
public class RecipeDetailsPage extends BaseTest {
	WebDriver driver;
	public String ingredientsText;
	public String preparationTimeText;
	public String cookingTimeText;
	public String preparationMethodText;
	public String nutrientValuesText;
	public RecipeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='recipe_tags']/a")
	public List<WebElement> RecipeCategory;
	@FindBy(xpath = "//div[@id='rcpinglist']")
	public List<WebElement> Ingredients;
	@FindBy(xpath = "//time[@itemprop='prepTime'] | //div[@class= 'col-xs-12 col-md-12 col-sm-12 col-lg-12']/section[2]/p/text()[1]")
	public List<WebElement> PreparationTime;
	@FindBy(xpath = "//time[@itemprop='cookTime'] | //div[@class= 'col-xs-12 col-md-12 col-sm-12 col-lg-12']/section[2]/p/text()[1]")
	List<WebElement> CookingTime;
	@FindBy(xpath = "//div[@id='recipe_small_steps']")
	List<WebElement> PreparationMethod;
	@FindBy(xpath = "//div[@id='recipe_nutrients']")
	List<WebElement> NutrientValues;
	public String getRecipeCategory() {
		// Recipe Category(Breakfast/Lunch/Snack/Dinner)
		if (Objects.nonNull(RecipeCategory) && !RecipeCategory.isEmpty()) {
			String recipeCategory = RecipeCategory.get(0).getText().toLowerCase();
			if (recipeCategory.contains("breakfast")) {
				System.out.println("Recipe Category: Breakfast");
				return "Breakfast"; // This return statement to print this string on Excel
			} else if (recipeCategory.contains("lunch")) {
				System.out.println("Recipe Category: Lunch");
				return "Lunch";
			} else if (recipeCategory.contains("snack")) {
				System.out.println("Recipe Category: Snack");
				return "Snack";
			} else if (recipeCategory.contains("dinner")) {
				System.out.println("Recipe Category: Dinner");
				return "Dinner";
			} else {
				System.out.println("Recipe Category: Recipe category list is not mentioned in this recipe.");
				return "Recipe category list is not mentioned in this recipe.";
			}
		}
		return null;
	}
	public String getFoodCategory() {
		// Food Category(Veg/non-veg/vegan/Jain)
		if (Objects.nonNull(RecipeCategory) && !RecipeCategory.isEmpty()) {
			String recipeCategory = RecipeCategory.get(0).getText().toLowerCase();
			// using RecipeCategory's xpath for food category because both xpaths are same
			if (recipeCategory.contains("veg")) {
				System.out.println("Food Category: Veg");
				return "Veg";
			} else if (recipeCategory.contains("non-veg")) {
				System.out.println("Food Category: Non Veg");
				return "Non Veg";
			} else if (recipeCategory.contains("vegan")) {
				System.out.println("Food Category: Vegan");
				return "Vegan";
			} else if (recipeCategory.contains("jain")) {
				System.out.println("Food Category: Jain");
				return "Jain";
			} else {
				System.out.println("Food Category: Food category list is not mentioned in this recipe.");
				return "Food category list is not mentioned in this recipe.";
			}
		}
		return null;
	}
	public String getIngredients() {
		if (Objects.nonNull(Ingredients) && !Ingredients.isEmpty()) {
			String ingredientsText = Ingredients.get(0).getText();
			System.out.println("Ingredients: " + ingredientsText);
			return ingredientsText;
		}
		return "";
	}
	public String getPreparationTime() {
		if (Objects.nonNull(PreparationTime) && !PreparationTime.isEmpty()) {
			String preparationTimeText = PreparationTime.get(0).getText();
			System.out.println("Preparation Time : " + preparationTimeText);
			return preparationTimeText;
		}
		return "";
	}
	public String getCookingTime() {
		if (Objects.nonNull(CookingTime) && !CookingTime.isEmpty()) {
			String cookingTimeText = CookingTime.get(0).getText();
			System.out.println("Cooking Time:  " + cookingTimeText);
			return cookingTimeText;
		}
		return "";
	}
	public String getPreparationMethod() {
		if (Objects.nonNull(PreparationMethod) && !PreparationMethod.isEmpty()) {
			String preparationMethodText = PreparationMethod.get(0).getText();
			System.out.println("Preparation Method: " + preparationMethodText);
			return preparationMethodText;
		}
		return "";
	}
	public String getNutrientValues() {
		if (Objects.nonNull(NutrientValues) && !NutrientValues.isEmpty()) {
			String nutrientValuesText = NutrientValues.get(0).getText();
			System.out.println("NutrientValue: " + nutrientValuesText);
			if (nutrientValuesText.isEmpty()) {
				System.out.println("Nutrient Value is empty.");
				return "Nutrient Value is empty.";
			}
			return nutrientValuesText;
		}
		return "";
	}
	public String getRecipeURL() {
		String recURL = driver.getCurrentUrl();
		System.out.println("RecipeURL:  " + recURL);
		return recURL;
	}
}
5:23
package testCases;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import pageObject.RecipeDetailsPage;
import pageObject.Recipe_LandingPage;
import utility.ExcelWriter;
public class RecipesTest extends BaseTest {
	Recipe_LandingPage rlp;
	RecipeDetailsPage rdp;
	ExcelWriter writer = new ExcelWriter();
	@BeforeClass
	public void setup() throws IOException {
		initializedriver();
		rlp = new Recipe_LandingPage(driver, prop);
		rdp = new RecipeDetailsPage(driver, prop);
	}
	@Test(priority = 1)
	public void getUrl() throws IOException {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	@Test(priority = 2)
	public void Pagination() {
		rlp.clickRecipeAtoZ();
		int alphaPagination = rlp.AtoZPaginationSize();
		System.out.println("AtoZpage size:" + alphaPagination);
		for (int i = 0; i < alphaPagination; i++) {
			String str = rlp.AtoZPagination.get(i).getText();
			String strText = "\"" + str + "\"";
			System.out.println(strText);
			WebElement alphaPagination1 = driver.findElement(
					By.xpath("//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]//a[text()=" + strText + "]"));
			alphaPagination1.click();
			List<WebElement> paginationLinks = rlp.NumbersPagination;// Find all pagination links once
			if (!paginationLinks.isEmpty()) {
				int numberOfPages = Integer.parseInt(paginationLinks.get(paginationLinks.size() - 1).getText());
				System.out.println("Number of pages in alphabet " + str + " is: " + numberOfPages);
				for (int j = 1; j <= numberOfPages; j++) {
					WebElement numPagination = driver
							.findElement(By.xpath("//div[@id='maincontent']/div[1]/div[2]/a[text()=" + j + "]"));
					numPagination.click();
					int RecipesInPage = rlp.RecipeNameSize();
					System.out.println(
							"Total recipes in alphabet " + str + " number " + j + " page is: " + RecipesInPage);
					for (int k = 0; k < RecipesInPage; k++) {						
						System.out.println("Recipe Name: " + rlp.RecipeName.get(k).getText());
						rlp.getRecipeID(k);
						rlp.RecipeName.get(k).click();
						rdp.preparationMethod();
						rdp.getNutrientValues();
						rlp.getUrl();	
          }
				}
			} else {
				System.out.println("List is empty. No elements found.");
			}
			driver.navigate().back();
		}
	}
}














