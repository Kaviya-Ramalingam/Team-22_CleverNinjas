package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import pageObject.RecipeDetailsPage;
import pageObject.Recipe_LandingPage;
import utility.ExcelWriter;

public class RecipesTest extends BaseTest {

	Recipe_LandingPage rp;
	RecipeDetailsPage rd;
	ExcelWriter writer = new ExcelWriter();


	@BeforeClass

	public void setup() throws IOException {
		initializedriver();
		rp = new Recipe_LandingPage(driver, prop);
		rd = new RecipeDetailsPage(driver);
	}

	@Test(priority =1)
	public void getUrl() throws IOException {

		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test(priority=2)
	public void Pagination() {
          rp.clickRecipeAtoZ();
	}
}
