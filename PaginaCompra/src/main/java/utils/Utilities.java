package utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static WebDriver driver;

	public static void openUrl(String strUrl){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(strUrl);

	}

	public static boolean isElementPresent(By by){
		try{
			driver.findElement((By) by);
			return true;
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			return false;
		}
	}

	public static WebElement el(By by) {
		return driver.findElement((By) by);
	}

	public static String base64Screenshot(){
		return "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}


	public static List<WebElement> els(By by) {
		return driver.findElements((By) by);
	}

	public static void wt(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitForElement(By by, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(by),
				ExpectedConditions.elementToBeSelected(by),
				ExpectedConditions.presenceOfNestedElementLocatedBy(by, null)));
	}

	public static void waitIfElementVisible(By by , long timeOutInSeconds) throws InterruptedException {
		long i = 1;
		long iTime = 1;

		while (els(by).size() >= 1) {

			if(el(by).isDisplayed()){
				wt(i * 1000);
				iTime++;

				if (iTime > timeOutInSeconds) {
					throw new InterruptedException("Time Exception");
				}
			}
		}
	}

	public static void closeExplorer() {
		driver.close();
	}

	public static void closeProcess() {
		driver.quit();
	}

	public static void type(By by, String str) {
		el(by).sendKeys(str);
	}

	public static void click(By by) {
		el(by).click();
	}

	public static void clearElement(By by) {
		el(by).clear();
	}

	public static String getText(By by) {
		return el(by).getText();
	}

	public static void select(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByVisibleText(str);
	}

	public static void selectByValue(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByValue(str);
	}

	public static String getDateYYYYMMDDHHMMSS() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}