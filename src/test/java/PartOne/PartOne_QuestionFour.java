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

public class PartOne_QuestionFour {

	PartOne_Elements_Pool elements_Pool;
	int count = 0, expCount = 0;
	String subMenuString;
	WebDriver driver;

	@Test
	public void testMethod() {
		PartOne_Elements_Pool elements_Pool = new PartOne_Elements_Pool(driver);
		List<String> wileyList = new ArrayList<String>();
		Actions action = new Actions(driver);

		//Creating an expected list
		try {
			List<String> expectedResult = new ArrayList<String>();
			expectedResult.add("Information & Library Science");
			expectedResult.add("Education & Public Policy");
			expectedResult.add("K-12 General");
			expectedResult.add("Higher Education General");
			expectedResult.add("Vocational Technology");
			expectedResult.add("Conflict Resolution & Mediation (School settings)");
			expectedResult.add("Curriculum Tools- General");
			expectedResult.add("Special Educational Needs");
			expectedResult.add("Theory of Education");
			expectedResult.add("Education Special Topics");
			expectedResult.add("Educational Research & Statistics");
			expectedResult.add("Literacy & Reading");
			expectedResult.add("Classroom Management");

			WebElement mainMenu = elements_Pool.subjectsMenu;
			action.moveToElement(mainMenu).perform();
			Thread.sleep(1000);
			WebElement subMenu = elements_Pool.educationMenu;
			subMenuString = subMenu.getText();
			action.moveToElement(subMenu).perform();
			Thread.sleep(2000);
			if (subMenuString.equals("Education")) {
				System.out.println("Education header is displayed!" + "\n");
			}
			List<WebElement> educationList = elements_Pool.educationSubMenu;

			for (WebElement list : educationList) {
				System.out.println(list.getText());
				wileyList.add(list.getText());
			}
			count = educationList.size();
			System.out.println("\n" + "Total actual item count is-: " + count);
			expCount = expectedResult.size();
			System.out.println("Total expected item count is-: " + expCount);
			System.out.println("Difference count is-: " + (expCount - count));
			expectedResult.removeAll(wileyList);
			System.out.println("Items not present from the expected list are -: " + expectedResult);
		} catch (Exception e) {
			System.err.println(e);
		}
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
