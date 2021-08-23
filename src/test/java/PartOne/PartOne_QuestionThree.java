package PartOne;

import org.testng.annotations.Test;
import partOne.elements.PartOne_Elements_Pool;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PartOne_QuestionThree {
	
	PartOne_Elements_Pool elements_Pool;
	int notContainKeyword = 0;
	WebDriver driver;

	@Test
	public void testMethod() throws Exception {
		
		PartOne_Elements_Pool elements_Pool = new PartOne_Elements_Pool(driver);
		elements_Pool.searchBox.sendKeys("Java");
		Thread.sleep(1000);
		elements_Pool.searchButton.click();
		Thread.sleep(1000);
		
		//Choosing the region from the popup 
		elements_Pool.regionPopupButton.click();

		// Checking only java titles are displayed
		List<WebElement> javaList = elements_Pool.searchBookContain;		

		for (WebElement list2 : javaList) {

			String title = list2.findElement(By.cssSelector(" h3[class='product-title']")).getText();
			String ebookOrprint = list2
					.findElement(By.cssSelector(" span[class='wileyProductDateGroup wileyProductDateGroupPipe'"))
					.getText();

			if (title.toLowerCase().toString().contains("java")) {
				if (ebookOrprint.toLowerCase().toString().contains("e-book")
						|| ebookOrprint.toString().toLowerCase().contains("print")
						|| ebookOrprint.toString().toLowerCase().contains("o-book")) {
					System.out.println("Has " + ebookOrprint + " -" + title);
				} else {
					System.out.println("Has " + ebookOrprint + " - " + title);
				}
			} else {
				if (ebookOrprint.toLowerCase().toString().contains("e-book")
						|| ebookOrprint.toString().toLowerCase().contains("print")
						|| ebookOrprint.toString().toLowerCase().contains("o-book")) {
					System.out.println("\n" + "Has " + ebookOrprint + "  version, no keyword contains -: " + title);
					notContainKeyword++;
				} else {
					System.out.println("\n" + "Has " + ebookOrprint + "  version, no keyword contains -: " + title);
					notContainKeyword++;
				}
			}
		}
		System.out.println(notContainKeyword + " book(s) does not contain the keyword.");
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