package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPackage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\naorem\\Automation_tutorial\\SelfPractice\\drivers\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setBinary("C:\\Users\\naorem\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ecs-qa.kloudship.com");
		driver.findElement(By.id("login-email")).sendKeys("kloudship.qa.automation@mailinator.com");
		driver.findElement(By.id("login-password")).sendKeys("Password1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> c = driver.findElements(By.xpath("//div[@class='row count-card-wrapper']//child::mat-card"));
		//navigating to packages page
		
		for(WebElement v:c)
		{
			if(v.getText().contains("Packages"))
			{
				
					v.click();
					break;
			}
			
			

		}
		//clicking add manually package
		WebElement add = driver.findElement(By.xpath("//button[@class='mat-focus-indicator button-disabled mat-icon-button mat-button-base ng-star-inserted']"));
		Actions action=new Actions(driver);
		action.moveToElement(add).click().perform();
		
		
		WebElement name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
		name.sendKeys("FirstName_LastName");
		
		WebElement length = driver.findElement(By.xpath("//input[@formcontrolname='length']"));
		length.clear();
		length.sendKeys("10");
		
		WebElement width = driver.findElement(By.xpath("//input[@formcontrolname='width']"));
		width.clear();
		width.sendKeys("2");
		
		WebElement height = driver.findElement(By.xpath("//input[@formcontrolname='height']"));
		height.clear();
		height.sendKeys("3");
		
		WebElement check = driver.findElement(By.xpath("//mat-icon[text()='check']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(check).click().perform();
		
		WebElement three_dot = driver.findElement(By.xpath(("//mat-icon[text()='more_vert']")));
		three_dot.click();
		
		WebElement logout_button = driver.findElement(By.xpath("//mat-icon[text()='power_settings_new']"));
		logout_button.click();
		
		
	}
	

}
