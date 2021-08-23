package PartOne;

import org.testng.annotations.Test;
import partOne.elements.PartOne_Elements_Pool;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class PartOne_QuestionOne {
	
	WebDriver driver;
	int count = 0;
	List<String> wileyList = new ArrayList<String>();
	PartOne_Elements_Pool elementsPool;
	
	@Test
	public void testMethod() throws Exception {
		
		Actions action = new Actions(driver);
		PartOne_Elements_Pool elements_Pool = new PartOne_Elements_Pool(driver);
		WebElement target = elements_Pool.whoWeServe;
		action.moveToElement(target).perform();
		Thread.sleep(1000);
		List<WebElement> list = elements_Pool.actualMenuList;
		
		//Creating a list of expected items
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Students");
		expectedResult.add("Instructors");
		expectedResult.add("Book Authors");
		expectedResult.add("Professionals");
		expectedResult.add("Researchers");
		expectedResult.add("Institutions");
		expectedResult.add("Librarians");
		expectedResult.add("Corporations");
		expectedResult.add("Societies");
		expectedResult.add("Journal Editors");
		expectedResult.add("Government");

		for (WebElement list2 : list) {
			String getName = list2.getText();
			wileyList.add(list2.getText());
			System.out.print(getName + ", ");
		}

		//Getting difference from actual to expected
		count = list.size();
		System.out.println("\n" + "Total actual item count is-: " + count);
		count = expectedResult.size();
		System.out.println("Total expected item count is-: " + count);
		wileyList.removeAll(expectedResult);
		System.out.println("Missing item(s) from the menu is-: " + wileyList);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wiley.com/en-us");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
