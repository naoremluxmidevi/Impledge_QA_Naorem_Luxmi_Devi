package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DeletePackage {

	public static void main(String[] args) {
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
		//driver.findElement(By.xpath("//mat-icon[text()='delete']")).click();
		WebElement delete = driver.findElement(By.xpath("//mat-icon[text()='delete']"));
		Actions action=new Actions(driver);
		action.moveToElement(delete).click().perform();
		
		
		WebElement delete_package = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-raised')]"));
		Actions action1=new Actions(driver);
		action1.moveToElement(delete_package).click().perform();
		
		WebElement three_dot = driver.findElement(By.xpath(("//mat-icon[text()='more_vert']")));
		three_dot.click();
		
		WebElement logout_button = driver.findElement(By.xpath("//mat-icon[text()='power_settings_new']"));
		logout_button.click();

	}

}
