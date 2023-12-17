package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class RecipeDetailsPage extends BaseTest {

	WebDriver driver;

//	Recipe ID
//	Recipe Name
//	Recipe Category(Breakfast/lunch/snack/dinner)
//	Food Category(Veg/non-veg/vegan/Jain)
//	Ingredients
//	Preparation Time
//	Cooking Time
//	Preparation method
//	Nutrient values
//	Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)
//	Recipe URL

	@FindBy(xpath = "//div[@id='rcpinglist']")
	public WebElement recipeIngrediants;

	@FindBy(xpath = "//div[@id='recipe_tags']/a")
	public List<WebElement> recipeCategory;
	@FindBy(xpath = "//div[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[1]")
	public WebElement preparationTime;
	@FindBy(xpath = "//div[@id='ctl00_cntrightpanel_pnlRecipeScale']/section/p[2]/time[2]")
	public WebElement cookingTime;
	@FindBy(xpath = "//div[@id='recipe_small_steps']/span/ol")
	public WebElement preparationMethod;
	@FindBy(xpath = "//table[@id='rcpnutrients']/tbody/tr")
	public List<WebElement> nutrientValuesTable;
	@FindBy(xpath = "//div[@id='ctl00_cntrightpanel_pnlRecipeScale']//p[2]/text()")
	public List<WebElement> RepeatedRecpiePreparationTime;
	@FindBy(xpath = "//div[@id='recipe_tags']")
	public WebElement tagValue ;
	
	
	public void getNutrientValues() {
		int size=nutrientValuesTable.size();
		for(int n=1;n<=size;n++) {
			String nv1=driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody/tr["+n+"]/td[1]")).getText();
			
			String nv2=driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody/tr["+n+"]/td[2]")).getText();
	  
			String nv=nv1+" :"+nv2;
			System.out.println(nv);
		}
		
		
		}
		
		

	
	public String getRecipeURL() {
		String url=driver.getCurrentUrl();
		System.out.println("Recipe URL: "+url);
		return driver.getCurrentUrl();
	}

	public String getCookingTime() {
		String ct = cookingTime.getText();
		System.out.println("CookingTime : "+ct);
		return ct;
	}

	public String getPreparationTime() {
		String pt = preparationTime.getText();
		System.out.println("Preparation Time : "+pt);
		return pt;
	}

	public String getPreparationMethod() {
		String pm = preparationMethod.getText();
		System.out.println("PreparationMethod : "+pm);
		return pm;
	}

	public RecipeDetailsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void getRecipeCategory() {
		String ct=tagValue.getText();
		System.out.println(ct);
			if (ct.contentEquals("Breakfast")) {
				System.out.println("The recipe category is breakfast");
				if (ct.contentEquals("lunch")) {
					System.out.println("The recipe category is lunch");
					if (ct.contentEquals("snack")) {
						System.out.println("The recipe category is snack");
						if (ct.contentEquals("dinner")) {
							System.out.println("The recipe category is dinner");
						}
					}
				}
			} else {
			}
		}
	

	public void getFoodCategory() {
		String ct=tagValue.getText();
		//System.out.println(ct);
			
			if (ct.contentEquals("Veg")) {
				System.out.println("The recipe category is Veg");
				if (ct.contentEquals("non-veg")) {
					System.out.println("The recipe category is lunch");
					if (ct.contentEquals("vegan")) {
						System.out.println("The recipe category is snack");
						if (ct.contentEquals("Jain")) {
							System.out.println("The recipe category is Jain");

						}
					}
				}
			} else {
			}
		}
	

	public String getRecipeIngrediants() {
		String txt = recipeIngrediants.getText();
		System.out.println("Recipe Ingrediants: " + txt);
		return txt;
	}

}
