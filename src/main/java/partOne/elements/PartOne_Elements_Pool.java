package partOne.elements;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartOne_Elements_Pool {

	WebDriver driver;
	
	//QuestionOne elements
	@FindBy(xpath = ("//a[contains(text(),'WHO WE SERVE')]")) public WebElement whoWeServe;
	@FindBy(xpath = ("//div[@id='Level1NavNode1']/child::ul[@class='dropdown-items ps-container ps-theme-default']/child::li[contains(@class,'dropdown-item ')]")) 
	public List<WebElement> actualMenuList;
	
	//QuestionTwo elements
	@FindBy(xpath = ("//*[@id=\"js-site-search-input\"]")) public WebElement searchBox; //Used in QuestionThree as well.
	@FindBy(xpath = ("//aside[@id='ui-id-2']//section[contains(@class,'searchresults-section ')]")) public List<WebElement> searchBoxSuggesstions; 
	
	//QuestionThree elements
	@FindBy(xpath = ("//button[@type='submit']")) public WebElement searchButton;
	@FindBy(xpath = ("//*[@id=\"country-location-form\"]/div[3]/button[2]")) public WebElement regionPopupButton;
	@FindBy(css = ("div[class='products-list'] section[class='product-item'] div[class='product-content']")) public List<WebElement> searchBookContain;
	@FindBy(css = (" h3[class='product-title']")) public WebElement bookTitle; //Have not implemented
	@FindBy(css = (" span[class='wileyProductDateGroup wileyProductDateGroupPipe'")) public WebElement issueMode; //Have not implemented
	
	//QuestionFour elements
	@FindBy(xpath = ("//a[contains(text(),'SUBJECTS')]")) public WebElement subjectsMenu;
	@FindBy(xpath = ("//*[@id=\"Level1NavNode2\"]/ul/li[9]/a")) public WebElement educationMenu;
	@FindBy(xpath = ("//*[@id=\"Level1NavNode2\"]/ul/li[9]/div/ul[1]/ul[1]/li[@class='dropdown-item ']")) public List<WebElement> educationSubMenu;
	
	public PartOne_Elements_Pool (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
