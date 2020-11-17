package fonctionscommunes;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes;
//
//import io.appium.java_client.functions.ExpectedCondition;
import java.util.Set;

import coeur.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import webelementsinventory.AEMPageObjects;




/**
 * This is a class having all the selenium methods defined in a personal way.
 * @author Jai Vyas
 * @version 1.1
 * @creation date:-
 * @modified on:-
*/



public class CommonFunction {
	protected static WebDriver driver;
	
	public static void cfinvokeBrowser() throws InterruptedException {
		System.out.println("inside invoke browser");
		if(Properties.getProperties("Browser").equalsIgnoreCase("chrome"))
		{
		WebDriver driver = new ChromeDriver();		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(2000);	
		}
		else if(Properties.getProperties("Browser").equalsIgnoreCase("mozillafirefox")) {
			driver=  new FirefoxDriver();
			System.setProperty("webdriver.firefox.marionette",Properties.getProperties("mozillafirefoxDriverPath"));
			driver.manage().window().maximize();
			Thread.sleep(2000);	
		}
		else if(Properties.getProperties("Browser").equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", Properties.getProperties("IEDriverPath"));
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability (InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			WebDriver driver = new InternetExplorerDriver(capabilities);

			driver.manage().window().maximize();
			Thread.sleep(2000);	
			
		}
		else if(Properties.getProperties("Browser").equalsIgnoreCase("safari")) {
			
			
		}
	}
	
	public static WebElement getWebElement(String enumxpath) {
		WebElement ele = driver.findElement(By.xpath(enumxpath));
		return ele;
	}

	public static List<WebElement> getWebElements(String enumxpath) {
		List<WebElement> ele = driver.findElements(By.xpath(enumxpath));

		return ele;
	}

	public static String takeScreenshot(String filename) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = null;
		try {
			FileUtils.copyFile(src, new File("TestResults/Screenshots/" + filename + ".jpeg"));
			return path = "Screenshots/" + filename + ".jpeg";
		} catch (Exception e) {
			System.out.println("error taking screenshot");
			return null;
		}
	}

	public static void scrolltoElementAndHighLight(WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style', 'background: MediumSeaGreen; border: 3px solid black;');", ele);
		}

	public static void highlightClickEnterDeletetakeScreenshot(String sendkeys, String command, WebElement ele,
			String filename) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		js.executeScript("arguments[0].setAttribute('style', 'background: MediumSeaGreen; border: 3px solid black;');", ele);
		if (command.equals("Enter")) {
			ele.sendKeys(sendkeys);
			takeScreenshot(filename);
		}
		if (command.equals("Click")) {
			ele.click();
			takeScreenshot(filename);

		}

		if(command.equals("Delete")) {

			ele.clear();
			takeScreenshot(filename);

		}
	}

	public void navigateToURl(String URL) {
		driver.get(URL);
	}

	public static void pageNavigationRefresh(String Navigation) {
		if (Navigation.equals("Back"))
			driver.navigate().back();
		else if (Navigation.equals("forward"))
			driver.navigate().forward();
		else if (Navigation.contains("www"))
			driver.navigate().to(Navigation);
		else if(Navigation.equalsIgnoreCase("Refresh"))
		driver.navigate().refresh();
	}

	public static void pageScrolling(String direction) {
		if (direction.equals("UP")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(500,0)");

		} else if (direction.equals("DOWN")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		}

		else if (direction.equals("LEFT")) {
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		} else if (direction.equals("RIGHT")) {
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		}
//		else if (direction.equals("scrolltoelement")) {
//
//			WebElement ele = driver.findElement(By.xpath(object.getxpath()));
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("arguments[0].scrollIntoView(true);",ele);
//		}


	}

	public static ArrayList<String> browserFuntions(String function, Point p, Dimension d) throws InterruptedException {
		ArrayList<String> windowHandles = null;
		if (function.equals("Close"))
			driver.close();
		if (function.equals("Maximize"))
			driver.manage().window().maximize();
		if (function.equals("fullscreen"))
			driver.manage().window().fullscreen();
		if (function.equals("setposition"))
			driver.manage().window().setPosition(p);
		if (function.equals("setsize"))
			driver.manage().window().setSize(d);
		if (function.equals("wait"))
			driver.manage().wait(5000);
		if (function.equals("Handles")) {
			windowHandles = new ArrayList<String> (driver.getWindowHandles());
		}
		return windowHandles;

	}

	public static List<WebElement> highlightSelectFromDropdown(String by, WebElement ele, String option) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].setAttribute('style', 'background: MediumSeaGreen; border: 3px solid black;');", ele);
		Select sle = new Select(ele);
		List<WebElement> options = sle.getOptions();
		if (by.equals("byvisibletext")) {
			sle.selectByVisibleText(option);
		}
		if (by.equals("byvalue")) {
			sle.selectByValue(option);
		}
		if (by.equals("byindex")) {
			sle.selectByValue(option);
		}

		return options;
	}

	public static void setWait(String waittype, ExpectedCondition<WebElement> expectedCondition, long timeout)
			throws InterruptedException {

		if (waittype.equals("explicitwait")) {
			WebElement wait = (new WebDriverWait(driver, timeout)).until(expectedCondition);
		} else
			driver.wait(2000);
	}
	public static void setWaitElements(String waittype, ExpectedCondition<List<WebElement>> expectedCondition, int timeout) throws InterruptedException{

		if (waittype.equals("explicitwait")) {
			List<WebElement> wait = (new WebDriverWait(driver, timeout)).until(expectedCondition);
		} else
			driver.wait(2000);
	}
		public static void deleteCookies() {
			driver.manage().deleteAllCookies();
		}
	


	public void datePicker(List<WebElement> dateoptions, String datetoselect) {

		for (WebElement date : dateoptions) {
			if (date.getText().equals(datetoselect))
				date.click();
			break;
		}

	}

	public void selecttextbypartialtext() {

	}

	public void keys(String keysfunction) {

	}

	public void switchingToFrames(String name) {
		driver.switchTo().frame(name);
	}

	public static void actionsFromActionsclass(WebElement source, String Functionality, WebElement target, int xOffset, int yOffset) {
		Actions act = new Actions(driver);
		act.moveToElement(source).perform();
		if (Functionality.equals("draganddrop"))
			act.dragAndDrop(source, target).build().perform();
		if (Functionality.equals("clickandhold"))
			act.clickAndHold(target);
		if (Functionality.equals("slider"))
			act.dragAndDropBy(source, xOffset, yOffset);
		if(Functionality.equals("click"))
			act.moveToElement(target).click().build().perform();
	}

	public void switchtoAlert(String response) {
		Alert alert = driver.switchTo().alert();
		if (response.equals("accept"))
			alert.accept();
		else if (response.equals("dismiss"))
			alert.dismiss();
	}

	public static Boolean checkIfElementsisPresent(String xpath) throws InterruptedException {
		
		ArrayList<WebElement> allelements = new ArrayList<WebElement>();
		allelements.addAll(CommonFunction.getWebElements(xpath));
		Boolean presence=true;
		
		for(int i = 0;i<allelements.size();i++) {
			WebElement ele =allelements.get(i);
			if(ele.isDisplayed())
			{
				scrolltoElementAndHighLight(ele);
				presence = true;
			}
			else {
				presence = false;
			}
			
		}
		Thread.sleep(2000);
		return presence;
		
		

		}
	}
