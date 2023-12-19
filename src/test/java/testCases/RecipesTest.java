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
	EliminateRecipes Eliminate = new EliminateRecipes();
	ToAddRecipes Added = new ToAddRecipes();
    AllergiesRecipes Allergies = new AllergiesRecipes();

	@BeforeClass
	public void setup() throws IOException {

		initializedriver();
		rlp = new Recipe_LandingPage(driver, prop);
		rdp = new RecipeDetailsPage(driver);

	}

	@Test(priority = 1)
	public void getUrl() throws IOException {

		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test(priority = 2)
	public void Pagination() throws IOException, InterruptedException {
		List<Object[]> scrapedRecipes = new ArrayList<>();
		rlp.ClickRecipeAtoZ();
		int alphaPagination = rlp.AtoZPaginationSize();
		System.out.println("AtoZpage size:" + alphaPagination);

		for (int i = 3; i < alphaPagination; i++) {
			String str = rlp.AtoZPagination.get(i).getText();
			String strText = "\"" + str + "\"";
			System.out.println(strText);
			WebElement alphaPagination1 = driver.findElement(
					By.xpath("//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]//a[text()=" + strText + "]"));

			alphaPagination1.click();
			Thread.sleep(500);
			String currentAlphaPageUrl = driver.getCurrentUrl();

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

						String recipeID = rlp.getRecipeID(k);
						String recipeName = rlp.getRecipeName(k);
						String currentPaginationPageUrl = driver.getCurrentUrl();
						try {
							rlp.RecipeName.get(k).click();

							String recipeCategory = rdp.getRecipeCategory();
							String foodCategory = rdp.getFoodCategory();
							String ingredients = rdp.getIngredients();
							String preparationTime = rdp.getPreparationTime();
							String cookingTime = rdp.getCookingTime();
							String preparationMethod = rdp.getPreparationMethod();
							String nutrientValues = rdp.getNutrientValues();
							String recipeURL = rdp.getRecipeURL();

							Object[] recipeData = { recipeID, recipeName, ingredients, preparationMethod,
									nutrientValues, preparationTime, cookingTime, recipeURL, foodCategory,
									recipeCategory };

							scrapedRecipes.add(recipeData);
							writer.writeToExcel(scrapedRecipes);

							driver.get(currentPaginationPageUrl);
							System.out.println("-------------------------------------------------");

						} catch (UnhandledAlertException a) {
							try {
								Alert alert = driver.switchTo().alert();
								String alertText = alert.getText();
								System.out.println("Alert data: " + alertText);
								alert.accept();
							} catch (NoAlertPresentException na) {
								na.printStackTrace();
							}
						}

					}
				}
			} else {
				System.out.println("List is empty. No elements found.");
			}
			// driver.navigate().back();
			driver.get(currentAlphaPageUrl);
			System.out.println("-------------------------------------------------");
		}
	}

	@Test(priority = 3)

	public void eliminatingRecipes() throws Exception {

		Eliminate.segregateData();
		Added.AddedRecipesData();
		Allergies.Allergies();

		LoggerLoad.info("elimination completed");
	}

}

