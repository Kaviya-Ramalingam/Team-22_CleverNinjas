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

	@FindBy(css = "a[title='Recipea A to Z']")
	WebElement recipeAtoZ;

	@FindBy(xpath = "//table/tbody/tr/td/table[@class='mnualphaitem ctl00_cntleftpanel_mnuAlphabets_4']/tbody/tr/td/a[1]")
	List<WebElement> AtoZ_pagination;

	@FindBy(xpath = "//div[@id='maincontent']/div/div[@id='cardholder']/div[3]/a")
	List<WebElement> numbers_pagination;

	int paginationsize;

	public void clickRecipeAtoZ() {

		recipeAtoZ.click();
	}

}