package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {
	public static void main(String[] args) {




		WebDriverManager.chromedriver().setup();

		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		String window1=driver.getWindowHandle();
		Set <String> Window2=driver.getWindowHandles();
		List<String> windowlist=new ArrayList<String>(Window2);
		driver.switchTo().window(windowlist.get(1));
		driver.findElement(By.xpath("//h5[text()='Button']//following::img")).click();
		// Switch the control to Primary window 
		driver.switchTo().window(window1);


		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		System.out.println("How many window opened : " + Window2.size());		

		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowsOpen = driver.getWindowHandles();
		List<String> lstWindowsOpen = new ArrayList<String>(windowsOpen);
		String openFirst = lstWindowsOpen.get(1);
		String openSecond = lstWindowsOpen.get(2);

		driver.switchTo().window(openFirst).close();
		driver.switchTo().window(openSecond).close();		
		driver.switchTo().window(window1);

		//Wait for 2 new Windows to open

		WebElement findElement2 = driver.findElement(By.id("color"));
		findElement2.click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> fstWindow = new ArrayList<String>(windowHandles2);
		String FstNewWindow = fstWindow.get(1);
		String SecNewWindow = fstWindow.get(2);
		System.out.println("First New Window : " + FstNewWindow);
		System.out.println("Second New Window : " + SecNewWindow);
		driver.switchTo().window(FstNewWindow).close();
		driver.switchTo().window(SecNewWindow).close();

	}
}
