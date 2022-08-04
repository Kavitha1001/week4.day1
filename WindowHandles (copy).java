package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		//disable notification
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		//1.Launch the browser
		ChromeDriver driver=new ChromeDriver(options);

		
		//2.Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		//4. Enter the password as " Password$123 "
		driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("Password$123");
		
		//5.click on the login button
		driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click();
		
		//6.click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		//7.Switch to the next window using Windowhandles.
		String Window1=driver.getWindowHandle();
		Set <String> Window2=driver.getWindowHandles();
		List<String> windowlist=new ArrayList<String>(Window2);
		driver.switchTo().window(windowlist.get(1));
		
		//8.click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//9.Get the title
		String Title= driver.getTitle();
		System.out.println(Title);
		//10.Get back to the parent window
		driver.switchTo().window(Window1);
		//11.close the browser
		driver.close();

	}

}
