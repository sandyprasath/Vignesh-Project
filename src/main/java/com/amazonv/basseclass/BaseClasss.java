package com.amazonv.basseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClasss {
	public static WebDriver driver;

	// selectbrowser
	public static WebDriver getBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\latha\\eclipse-workspace\\Amazon_Automation_V\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("microsoftedge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\saran\\eclipse-workspace\\Selenium_Project\\Driver\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else {
				System.out.println("invalid browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		return driver;

	}

	// get url
	public static void geturl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// click webelement
	public static void click(WebElement webelement) {

		webelement.click();
	}

	// send keys
	public static void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// clear and senkeys
	public static void clearAndSendkeys(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get text
	public static void getText(WebElement element) {
		try {
			element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get attribute
	public static void getAttribute(WebElement element, String type) {
		try {
			element.getAttribute(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tab close and quit
	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// webdriver navigate methods
	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}

	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// actions
	public static void actions(String actionsName, WebElement webelement) {
		try {
			Actions ac = new Actions(driver);
			if (actionsName.equalsIgnoreCase("click")) {
				ac.click(webelement);
			} else if (actionsName.equalsIgnoreCase("rightclick")) {
				ac.contextClick(webelement).build().perform();
			} else if (actionsName.equalsIgnoreCase("doubleclick")) {
				ac.doubleClick(webelement).build().perform();
			} else if (actionsName.equalsIgnoreCase("movetoelement")) {
				ac.moveToElement(webelement).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// alert
	public static void alert(String name) {
		try {
			if (name.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().accept();
			} else if (name.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// frame string passing
	public static void frame(String string) {
		try {
			driver.switchTo().frame(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// frame webelement passing
	public static void frame(WebElement webelement) {
		try {
			driver.switchTo().frame(webelement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// frame index passing
	public static void frame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// frame default
	public static void frameToDefault() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// title
	public static void getTile() {
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// retreive url
	public static void currentUrl() {
		try {
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// take screenshot
	public static void takesScreenshot(String screenshotName) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File scr = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\saran\\eclipse-workspace\\Selenium_Project\\Screenshot" + "//"
					+ screenshotName + ".png");
			FileUtils.copyFile(scr, des);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	// keyboards robot
	public static void robot(String type) throws AWTException {
		try {
			Robot r = new Robot();
			if (type.equalsIgnoreCase("down")) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			} else if (type.equalsIgnoreCase("up")) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			} else if (type.equalsIgnoreCase("enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			} else if (type.equalsIgnoreCase("right")) {
				r.keyPress(KeyEvent.VK_RIGHT);
				r.keyRelease(KeyEvent.VK_RIGHT);

			} else if (type.equalsIgnoreCase("left")) {
				r.keyPress(KeyEvent.VK_LEFT);
				r.keyRelease(KeyEvent.VK_LEFT);
			} else if (type.equalsIgnoreCase("spacebar")) {
				r.keyPress(KeyEvent.VK_SPACE);
				r.keyRelease(KeyEvent.VK_SPACE);
			} else {
				System.out.println("invalidkeys");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// open new tab
	public static void newTabJump() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// jump to previous tab
	public static void tabJumpPreviuos() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// jump to next tab
	public static void tabNext() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// implicit wait
	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	// select
	public static void selectMethod(WebElement element, String type, String value) {
		try {
			Select s = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (type.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(value);
			} else {
				System.out.println("invalid content");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

}
