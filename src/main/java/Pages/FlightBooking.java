package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking {
	private WebDriver driver;
	
	@FindBy (xpath = "//*[@data-cy='closeModal']")
	private WebElement popUp;
	
	@FindBy (id="fromCity")
	private WebElement fromCity;
	
	@FindBy (xpath ="//*[@placeholder='From']")
	private WebElement fromCityTextBox;	
	
	@FindBy (xpath = "//*[@id=\"react-autowhatever-1-section-0-item-0\"]")
	private WebElement fromCitySelect;	
	
	@FindBy (id="toCity")
	private WebElement toCity;
	
	@FindBy (xpath ="//*[@placeholder='To']")
	private WebElement toCityTextBox;
	
	@FindBy (xpath = "//*[@id=\"react-autowhatever-1-section-0-item-0\"]")
	private WebElement toCitySelect;
	

	@FindBy (xpath = "(//*[@class='lbl_input appendBottom10'])[3]")
	private WebElement deprture;
	
	@FindBy (xpath = "(//*[contains(@class,'DayPicker-Day DayPicker-Day--selected')]//p)[1]")
	private WebElement currentDateSelect;
	
	
	
	@FindBy (xpath = "//*[@data-cy='submit']/child::a")
	private WebElement search;
	
	@FindBy (id = "//*[text()='GOT IT']")
	private WebElement gotIt;
	
	@FindBy (id = "//*[text()='VIEW PRICES']")
	private WebElement viewPrices;
	
	@FindBy (xpath = "//*[@id=\"25\"]/div/div[1]/div[3]/div/button[2]")
	private WebElement bookFlight;
	
	@FindBy (xpath = "//*[text()='Continue']")
	private WebElement continu;
	
	public FlightBooking(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void closeLoginPopup() {
		popUp.click();
	}
	
	public void SendFromCity(String city) {
		fromCity.click();
		fromCityTextBox.sendKeys(city);	
		fromCitySelect.click();
	}	
		
	
	public void SendToCity(String city){
		try {
			toCity.click();				
			toCityTextBox.sendKeys(city);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//			wait.until(ExpectedConditions.visibilityOf(fromCitySelect));
			Actions actions = new Actions(driver);		
			actions.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER).build().perform();
			
			toCitySelect.click();
		}
		catch(Exception e) {
			
		}
	}
	
	public void selectDate() {
		deprture.click();
		currentDateSelect.click();	
		
	}
	
	
	
	public void clickOnSearch() {
		search.click();
	}
	
	public void clickOnGotit() {
		gotIt.click();
	}
	
	public void clickOnViewprices() {
		viewPrices.click();
	}
	
	public void clickOnBookNow() {
		bookFlight.click();
	}
	
	public void clickOnContinue() {
		Set<String> elemement = driver.getWindowHandles();
		Iterator<String> it = elemement.iterator();
		while(it.hasNext()) {
			continu.click();
		}
	}
	
	
	

	

}
