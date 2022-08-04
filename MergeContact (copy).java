package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::a")).click();
		Thread.sleep(2000);

		//Manage Windows -Navigate to second window
		String parentwindow =driver.getWindowHandle();
		System.out.println(parentwindow);
		Set<String> windows=driver.getWindowHandles();
		List<String> windowslist=new ArrayList<String>(windows);
		driver.switchTo().window(windowslist.get(1));

		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[contains(text(),'Contact ID')]//following::a[@class='linktext'])[1]")).click();

		//Navigating to parent window 
		driver.switchTo().window(parentwindow);

		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath(" //span[text()='To Contact']//following::a[1]")).click();
		Thread.sleep(3000);
		//Navigating to the newly opened second window
		Set<String> windowsSec=driver.getWindowHandles();
		List<String> windowslistSec=new ArrayList<String>(windowsSec);
		System.out.println(windowslistSec.get(0));
		System.out.println(windowslistSec.get(1));
		driver.switchTo().window(windowslistSec.get(1));

		// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a[1]")).click();

		//Navigate back to parent window
		driver.switchTo().window(parentwindow);

		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.linkText("Merge")).click();

		//12. Accept the Alert
		Alert testalert =driver.switchTo().alert();
		testalert.accept();

		//13. Verify the title of the page
		String titlename=driver.getTitle();
		System.out.println("The title of the page is" +titlename);



	}

}
