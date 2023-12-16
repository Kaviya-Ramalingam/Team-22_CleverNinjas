package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage  extends BaseTest{
	

	WebDriver driver;

	public String categoryOfFood;
	public String ingredientsName;
	public String methodName;
	public String nutrientValue;
	public String preparingTime;
	public String cookTime;
	
	public RecipeDetailsPage(WebDriver driver) {
	
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@id='recipe_nutrients']")
	List<WebElement> nutrientValues;
	
	
	
	
	public String getNutrientValues() {
		if (!nutrientValues.isEmpty()) {
			System.out.println("NutrientValue:  " + nutrientValues.get(0).getText());
			nutrientValue = nutrientValues.get(0).getText();
		
		}else {
			System.out.println("NutrientValue not found:");
			
		}
		return nutrientValue;
		
	}
}
	
	
	

	


