package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		rdp = new RecipeDetailsPage(driver);

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
			String str = rlp.AtoZPagination().get(i).getText();
			String strText = "\"" + str + "\"";
			System.out.println(strText);
			WebElement alphaPagination1 = driver.findElement(By.xpath(
					"//table[@id='ctl00_cntleftpanel_mnuAlphabets']//td[1]//a[text()=" + strText + "]"));

			alphaPagination1.click(); 
			
			List<WebElement> paginationLinks = rlp.NumbersPagination();// Find all pagination links once
																							
			if (!paginationLinks.isEmpty()) {
				int numberOfPages = Integer.parseInt(paginationLinks.get(paginationLinks.size() - 1).getText());
				System.out.println("Number of pages in " + str +" is: " + numberOfPages);
				for (int j = 1; j <= numberOfPages; j++) {
					WebElement numPagination = driver
							.findElement(By.xpath("//div[@id='maincontent']/div[1]/div[2]/a[text()=" + j + "]"));
					numPagination.click();
				}
				} else {
					System.out.println("List is empty. No elements found.");
				}
				driver.navigate().back();
		}
	}
}
