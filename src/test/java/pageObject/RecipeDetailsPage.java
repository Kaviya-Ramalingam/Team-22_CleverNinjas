package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage extends BaseTest {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='rcpinglist']")
	public WebElement recipeIngrediants;

	public RecipeDetailsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public String getRecipeIngrediants() {
		String txt = recipeIngrediants.getText();
		System.out.println("Recipe Ingrediants: "+txt);
		return txt;
	}
}
