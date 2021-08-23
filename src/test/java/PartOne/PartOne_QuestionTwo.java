package PartOne;

import org.testng.annotations.Test;
import partOne.elements.PartOne_Elements_Pool;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PartOne_QuestionTwo {
	
	WebDriver driver;
	String key = "Java";
	PartOne_Elements_Pool elements_Pool;
	
	@Test
	public void testMethod() throws Exception {
		
		PartOne_Elements_Pool elements_Pool = new PartOne_Elements_Pool(driver);
		elements_Pool.searchBox.sendKeys(key);
		Thread.sleep(2000);

		List <WebElement> suggestion = elements_Pool.searchBoxSuggesstions;
		System.out.println("Search string " + key + " gives-: " + "\n");
		for (WebElement suggest : suggestion) {
			System.out.println(suggest.getText());
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