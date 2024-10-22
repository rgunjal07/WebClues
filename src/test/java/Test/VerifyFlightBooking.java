package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.FlightBooking;

public class VerifyFlightBooking {
	
	WebDriver driver;
	FlightBooking flightBooking;
	
	@BeforeClass
	public void launchBrowser() {
//		driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
	}
	
	@BeforeMethod
	public void createPomObject(){
		flightBooking = new FlightBooking(driver);
	}
	
	@Test
	public void verifyFligthBookings(){
		flightBooking.closeLoginPopup();
		flightBooking.SendFromCity("Mumbai");
		flightBooking.SendToCity("Delhi");
		flightBooking.selectDate();
		flightBooking.clickOnSearch();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		flightBooking = null;
		driver=null;
	}

	@AfterTest
	public void garbageCollector() {

		System.gc();
	}

}
