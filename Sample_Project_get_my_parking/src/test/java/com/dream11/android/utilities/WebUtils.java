package com.dream11.android.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.dream11.android.launcher.TestHarness;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.dream11.android.config.config;
import io.appium.java_client.android.AndroidDriver;

public  class WebUtils {

	public WebDriver driver;
	public WebDriverWait ajaxWait;
	private int TIME_OUT;
	public  Logger testLogger;
	public Wait<WebDriver> wait;


	public WebUtils(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		ajaxWait = new WebDriverWait(driver, TIME_OUT);
		testLogger = LogManager.getLogger(Logger.class.getName());
	}


	public static int getRandomNumber() {

		Random rnd = new Random();
		int id = rnd.nextInt(5000);
		return id;

	}

	public  static String  generateRandomPhoneNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return "522" + String.format("%06d", number);
	}

	/**
	 * This method will wait for Webelement to appear
	 *
	 * @param element
	 * @param timeout
	 */
	// Wait for element present for WebElement
	public void waitForWebElementPresent(WebElement element, long timeout) {


		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForWebElementPresent(WebElement element,WebDriver driver, long timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));

	}
	// Wait for visibilityOf of element
	public void waitForWebElementVisibility(WebElement element, long timeout) {

		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
//		WebDriverWait ajaxWait = new WebDriverWait(driver, timeout);
//		ajaxWait.until(ExpectedConditions.visibilityOf(element));

	}


	public void waitForByElementPresent(By element, long timeout) {
		WebDriverWait ajaxWait = new WebDriverWait(driver, timeout);
		ajaxWait.until(ExpectedConditions.presenceOfElementLocated(element));
	}


	/**
	 * This method is used to execute a Java script
	 *
	 * @param we
	 */
	public void javaScriptExecute(WebElement we) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", we);
	}

	public void jsExeScrollTo(WebElement element) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void Click(WebElement element) {
		element.click();
	}

	public String verify_element_Present(WebElement element) {
		boolean res = element.isDisplayed();
		//	log.info("User found  element is Displayed in screen is available : " + res);
		return null;
	}

	public void fluentWait(WebDriver driver, long withTimeoutDuration) {

		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(withTimeoutDuration))
				.pollingEvery(Duration.ofMillis(1000));
	}

	public boolean isAlertPresent(WebElement element, long withTimeoutDuration) {
		fluentWait(driver, withTimeoutDuration);
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			//log.info("Alert not present");
			return false;
		} else
			//log.info("Alert not present");
			return true;
	}

	public void visibilityOf(WebElement element, long withTimeoutDuration) {

		new WebDriverWait(driver,withTimeoutDuration).until(ExpectedConditions.visibilityOf(element));
	}

	public boolean textToBePresentInElementAttributeValue(WebElement element, String attributeValue) {

		return new WebDriverWait(driver,15).until(ExpectedConditions.textToBePresentInElementValue(element, attributeValue));

	}

	public boolean titleContains(String title) {

		return new WebDriverWait(driver,15).until(ExpectedConditions.titleContains(title));

	}

	public void waitForElementToBeClickable(MobileElement element, long withTimeoutDuration) {
		new WebDriverWait(driver,withTimeoutDuration).until(ExpectedConditions.elementToBeClickable(element));

	}


	public void waitForElement(MobileElement element, long withTimeoutDuration) {

		new WebDriverWait(driver,withTimeoutDuration).until(ExpectedConditions.elementToBeClickable(element));

	}

	public boolean isElementDisplayed(MobileElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean isElementDisplayed(MobileElement element,
									  long withTimeoutDuration) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	// Wait


	public void acceptAlerts() {
		try {
			Thread.sleep(2);
			driver.switchTo().alert().accept();
			//log.info("Alerts Presented and tap Accept");
		} catch (Exception ex) {
			//log.info("Alerts not Presented");
		}
	}

	public void dismissAlerts() {
		try {
			Thread.sleep(2);
			driver.switchTo().alert().dismiss();
			//log.info("Alerts Presented and tap Dismiss");
		} catch (Exception ex) {
			//log.info("Alerts not Presented");
		}
	}

	public void captureAlerts() {
		try {
			Thread.sleep(2);
			driver.switchTo().alert().getText();

		} catch (Exception ex) {
			//log.info("Alerts not Presented");
		}
	}

	/**
	 * This method will wait for a web element present
	 */

	// Wait for element present for lists WebElement
	public void waitForListOfWebElementsPresent(List<WebElement> elements, long timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfAllElements(elements));

	}


	public void waitForElementToBeClickable(WebElement element, long withTimeoutDuration) {
		new WebDriverWait(driver,withTimeoutDuration).until(ExpectedConditions.elementToBeClickable(element));

	}


	public void waitForElementToBeClickable(WebElement element,WebDriver driver, long withTimeoutDuration) {
		new WebDriverWait(driver,withTimeoutDuration).until(ExpectedConditions.elementToBeClickable(element));

	}


	public boolean isElementDisplayed(WebElement element, long withTimeoutDuration) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void scrollDown(Object x, Object y) {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(x, y);");

	}

	public void dragAndDrop(WebElement element, int x, int y) {
		Actions price = new Actions(driver);
		price.dragAndDropBy(element, x, y).release().perform();

	}
	void waitForLoadJavaScript(WebDriver driver,int time) {
		new WebDriverWait(driver, time).until((ExpectedCondition<Boolean>) wd ->
				((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	public void waitForPageToLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void waitForPageToLoadJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").toString().equals("complete");
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static By byLocator(final String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("Link=")) {
			result = By.linkText(locator.replace("Link=", ""));
		} else if (locator.startsWith("xpath=")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("(//")) {
			result = By.xpath(locator);
		} else {
			result = By.id(locator);
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(final String locator) {
		Boolean result = false;
		try {
			driver.findElement(byLocator(locator));
			result = true;
		} catch (final Exception ex) {
		}
		return result;
	}

	public void scrollUp() {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(0, -250);");

	}

	public void scrollElement(WebElement Element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", Element);

	}

	public void scrolldown() {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(0, 250);");


	}

	public void scrollDown(int value) {

		JavascriptExecutor scroller = (JavascriptExecutor) driver;
		scroller.executeScript("scroll(0, 700);");


	}

	public void scrollPageEnd() {
		JavascriptExecutor scroller = (JavascriptExecutor) driver;
		scroller.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrolldownElement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);

	}

	// Wait
	public void waitForElementPresent(int Seconds) {
		int miliseconds;
		try {
			miliseconds = Seconds * 1000;
			Thread.sleep(miliseconds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String mouseHoverGetText(WebElement element) {
		Actions action = new Actions(driver);
		return action.moveToElement(element).toString();
	}
	public void mouseHoverClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void mouseHoverClick(List<WebElement> element) {
				Actions action = new Actions(driver);
				action.moveToElement(element.get(0)).click().build().perform();
	}

	public void mouseHoverClick(List<WebElement> element, int elementNumber) {
		for (int productCount=1; productCount< element.size(); productCount++) {
			if (elementNumber == productCount) {
				Actions action = new Actions(driver);
				action.moveToElement(element.get(productCount - 1)).click().build().perform();
			}
		}
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void mouseHover(List<WebElement> element, int elementNumber) {
		for (int productCount=1; productCount< element.size(); productCount++){
			if(elementNumber == productCount){
				Actions action = new Actions(driver);
				action.moveToElement(element.get(productCount-1)).build().perform();
			}
		}
	}

	public void mouseHover2(WebElement element, WebElement element1) {
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1).build().perform();
	}


	public void mouseHover_3(WebElement element, WebElement element1,WebElement element2) {
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1).moveToElement(element2).build().perform();
	}



	public void mouseHoverClick(WebElement element, WebElement element1) {
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element1)
						.click().
				build().perform();
	}
	public void mouseHover3(WebElement element1, WebElement element2,WebElement element3) {
		Actions action = new Actions(driver);
		action.moveToElement(element1)
				.moveToElement(element2)
				.moveToElement(element3)
				.click()
				.build().perform();
	}

	public void mouseHover3_GetText(WebElement element1, WebElement element2,WebElement element3) {
		Actions action = new Actions(driver);
		 action.moveToElement(element1)
				.moveToElement(element2)
				.moveToElement(element3)

				.build().perform();


	}

	public void slider(WebElement slider,int xOffset,int yOffset){
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, xOffset, xOffset).perform();
	}

	public void elementMouseClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	public void moveToElementAndSendKeys(WebElement element,String send){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.sendKeys(send);
		actions.build().perform();
	}

	public void moveToElementAndClickAndSendKeys(WebElement element,String send){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(send);
		actions.build().perform();
	}

	public void hideAndroidKeyBoard() {
		AndroidDriver<?> androidDriver = (AndroidDriver<?>) driver;
		androidDriver.hideKeyboard();
	}

	public void scroll(Object x, Object y) {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		String scr = "scroll(" + x + "," + y + ")";
		Scroller.executeScript(scr);

	}

	public void new_Chrome_Tab() throws Exception {

		/*
		 * WebElement body = driver.findElement(By.cssSelector("body")); String
		 * newTabAction = Keys.chord(Keys.COMMAND, "t"); body.sendKeys(newTabAction);
		 *
		 * String chooseTab = Keys.chord(Keys.COMMAND, "2"); body.sendKeys(chooseTab);
		 */

		// WebDriver driver = new ChromeDriver();

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		Thread.sleep(2);
		TestHarness accessTestMethod = new TestHarness();

	}

	public void waitForElement(WebElement element, long withTimeoutDuration) throws InterruptedException {
		while (withTimeoutDuration > 0) {
			try {
				if (element.isDisplayed())
					break;
				else
					continue;
			} catch (Exception e) {
				Thread.sleep(1000);
				withTimeoutDuration--;
			}
		}

	}

	public void waitThread(long wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void navigateBack() {
		driver.navigate().back();
		waitForElementPresent(4);
		waitForPageToLoad(25);
	}

	public String extractIntegersInString(String str) {
		// Replacing every non-digit number
		// with a space(" ")
		str = str.replaceAll("[^\\d]", " ");

		// Remove extra spaces from the beginning
		// and the ending of the string
		str = str.trim();

		// Replace all the consecutive white
		// spaces with a single space
		return str = str.replaceAll(" +", " ");


	}


	public void scrollToParticularElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}

	public void scrollToElementBasedOnLocation(WebElement element) {
		//get position
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();

		//scroll to x y
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public void waitForLoadJavaScripts(WebDriver driver,int time) {
		new WebDriverWait(driver, time).until((ExpectedCondition<Boolean>) wd ->
				((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}

	public void waitForDomToLoad(int time) {
		waitForLoadJavaScripts(driver,time);
	}


	public void navigateToParticularPage(String url) {
		waitForPageToLoad(60);
		driver.get(url);
		waitForPageToLoad(100);
		implicitWait(60);
	}

	public String randomGenerateEmail() {
		String email;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String date = simpleDateFormat.format(new Date());
		email = "dream11" + date + "@mailinator.com";
		System.out.println("Random Generated Email id with time stamp : " + email);
		return email;

	}


	public boolean VerifyElementsList(List<WebElement> elementList, String name) {
		boolean productNamePresent = false;
		for (WebElement element : elementList) {
			String elementName = element.getText().trim();
			elementName.replace("\n", "");
			if (elementName.equalsIgnoreCase(name)) {
				testLogger.info("Element name " + name + " is present");
				productNamePresent = true;
				break;
			}
		}
		if (productNamePresent = false) {
			testLogger.error("Element name " + name + " is not displayed");
		}
		return productNamePresent;
	}

	public boolean clickElementsList(List<WebElement> elementList, String name) {
		boolean productNamePresent = false;
		for (WebElement element : elementList) {
			String elementName = element.getText().trim();
			elementName.replace("\n", "");
			if (elementName.equals(name)) {
				//waitThread(5000);
				element.click();
				waitThread(5000);
				testLogger.info("Product " + name + " is clicked");
				productNamePresent = true;
				break;
			}
		}
		if (productNamePresent = false) {
			testLogger.error("Product name " + name + " is not available");
		}
		return productNamePresent;
	}

	public boolean clickElementsListContains(List<WebElement> elementList, String name) {
		boolean productNamePresent = false;
		for (WebElement element : elementList) {
			String elementName = element.getText().trim();
			elementName.replace("\n", "");
			if (elementName.contains(name)) {
				element.click();
				waitThread(3000);
				testLogger.info("Product " + name + " is clicked");
				productNamePresent = true;
				break;
			}
		}
		if (productNamePresent = false) {
			testLogger.error("Product name " + name + " is not available");
		}
		return productNamePresent;
	}

	public boolean clickElementsListByAttributeValue(List<WebElement> elementList, String name) {
		boolean productNamePresent = false;
		for (WebElement element : elementList) {
			String elementName = element.getAttribute("value");
			elementName.replace("\n", "");
			if (elementName.equalsIgnoreCase(name)) {
				element.click();
				waitForElementPresent(3);
				testLogger.info("Product " + name + " is clicked");
				productNamePresent = true;
				break;
			}
		}
		if (productNamePresent = false) {
			testLogger.error("Product name " + name + " is not available");
		}
		return productNamePresent;
	}

	public boolean clickElementsList(List<WebElement> elementList,WebElement elementText, String name) {
		boolean productNamePresent = false;
		for (WebElement element : elementList) {
			String elementName = elementText.getText().trim();
			elementName.replace("\n", "");
			if (elementName.equals(name)) {
				element.click();
				testLogger.info("Product " + name + " is clicked");
				productNamePresent = true;
				break;
			}
		}
		if (productNamePresent = false) {
			testLogger.error("Product name " + name + " is not available");
		}
		return productNamePresent;
	}

	public ArrayList<String> findElementsList(List<WebElement> element) {
		ArrayList<String> arrlist = new ArrayList<String>();
		for (WebElement ele : element) {
			arrlist.add(ele.getText().trim());
		}
		testLogger.info("Items present : " + arrlist);
		return arrlist;
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.getText().isEmpty();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresentCheckUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {

			Object obj = jse.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;", element);
			if (obj.toString().contains("true")) {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS");
				return true;
			} else {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
			}

		} catch (NoSuchElementException e) {
			System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
		}
		return false;
	}

	public void clearBrowserCache(){
        waitForPageToLoad(90);
        implicitWait(60);
		driver.manage().deleteAllCookies();
        waitForPageToLoad(90);
        implicitWait(60);

	}

public static String generateRandomString(int length){
	String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
			+"lmnopqrstuvwxyz";
	Random rnd = new Random();
	StringBuilder sb = new StringBuilder(length);
	for (int i = 0; i < length; i++)
		sb.append(chars.charAt(rnd.nextInt(chars.length())));
	return sb.toString();
}

	// Generates a random int with n digits
	public static int 	generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		return m + new Random().nextInt(9 * m);
	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public void switchToIFrame(WebDriver driver,String value){
		driver.switchTo().frame(value);
	}

	public static void newWindowTabClose(WebDriver driver){

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

		}
		//switch to the parent window
		driver.switchTo().window(parent);


	}
	public static String stringBuilder(WebDriver driver) {
		String curUrl=driver.getCurrentUrl();
		StringBuilder sb=new StringBuilder(curUrl);

		StringBuilder sb1=sb.delete(8, 30);
		String curUrl1=sb1.toString();
		return curUrl1;

	}

	public void scrollIntoView(WebElement Element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			jse.executeScript("arguments[0].scrollIntoView();",Element );
		}catch(NoSuchElementException nse){
			System.out.println("Unable to scroll to the element : " + Element.toString() + " as element is not found.");
		}
	}


	/**
	 *
	 * @author chananrasekhar.m
	 * This method will select the value in dropdown
	 *
	 */
	public void selectDropdownValueswithActions(WebElement element,String text)
	{


		Actions builder = new Actions(driver);
		Action click = builder
				.moveToElement(element)
				.click()
				.sendKeys(text)
				.build();
		click.perform();
	}

	// Capturing Screenshot
	public void captureScreenshot(String Screenshotname) {
		try {
			File srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(srcPath,
					new File(System.getProperty("user.dir") + "/Screenshots/" + Screenshotname + ".jpg"));
		} catch (Exception e) {
			testLogger.error("Exception while taking a screenshot" + Screenshotname + e.getMessage());
		}
	}

	/**
	 * @author sandhyapindi
	 * This method is used to input text in field.
	 *
	 * @param el
	 * @param text
	 */
	public void enterText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
		testLogger.info("Entered \""+text+"\" text");
		el.sendKeys(Keys.TAB);
		waitForElementPresent(3);
	}

	/**
	 * @author sandhyapindi
	 * This method is used to input text in field.
	 *
	 * @param xpath
	 * @param text
	 */
	public void enterText(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(text);
		testLogger.info("Entered \""+text+"\" text");
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
		waitForElementPresent(3);
	}

	/**
	 * This method is used to select dropdown by index value
	 *
	 * @author sandhyapindi
	 * @param element
	 * @param index
	 */
	public void selectDropdownValuesByIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method returns By type for an WebElement
	 *
	 * @author sandhyapindi
	 * @param
	 * @return
	 */
	public By toByVal(WebElement el) {
		// By format = "[foundFrom] -> locator: term"
		// see RemoteWebElement toString() implementation
		String[] data = el.toString().split(" -> ")[1].replace("]", "").split(": ");
		String locator = data[0];
		String term = data[1];

		switch (locator) {
			case "xpath":
				return By.xpath(term);
			case "css selector":
				return By.cssSelector(term);
			case "id":
				return By.id(term);
			case "tag name":
				return By.tagName(term);
			case "name":
				return By.name(term);
			case "link text":
				return By.linkText(term);
			case "class name":
				return By.className(term);
		}
		return (By) el;
	}

	/**
	 * This method is used to wait until the presence of element located by specified locator
	 *
	 * @author sandhyapindi
	 * @param el
	 * @param timeInSecs
	 */
	public void waitForVisibilityOfElementLocated(WebElement el, WebDriver driver,long timeInSecs) {

		new WebDriverWait(driver, timeInSecs).until(ExpectedConditions.visibilityOf(el));

	}


	public void waitForPresenceOfElementLocated(WebElement el,WebDriver driver, long timeInSecs) {

		new WebDriverWait(driver, timeInSecs).until(ExpectedConditions.visibilityOf(el));
//		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
//		try {
//			wait.until(ExpectedConditions.presenceOfElementLocated(toByVal(el)));
//		} catch (Exception e) {}
	}

	/**
	 * This method is used to wait until the presence of element located by specified locator
	 *
	 * @author sandhyapindi
	 * @param xpath
	 * @param timeInSecs
	 */
	public void waitForPresenceOfElementLocated(String xpath, long timeInSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {}
	}

	/**
	 * This method is used to click on selected WebElement
	 *
	 * @author sandhyapindi
	 * @param el
	 * @param seconds
	 */
	public void clickElement(WebElement el, long seconds) throws NoSuchElementException{
		waitForPresenceOfElementLocated(el, driver,seconds);
		//highlightWebElement(el);
		el.click();
		testLogger.info("Clicked on WebElement: "+el.toString());
	}

	/**
	 * This method is used to click on selected WebElement
	 *
	 * @author sandhyapindi
	 * @param
	 * @param seconds
	 */
	public void clickElement(String xpath, long seconds) throws NoSuchElementException{
		waitForPresenceOfElementLocated(xpath, seconds);
		//highlightWebElement(el);
		driver.findElement(By.xpath(xpath)).click();
		testLogger.info("Clicked on WebElement: "+xpath);
	}

	/**
	 * This method is used to highlight a webelement
	 *
	 * @author sandhyapindi
	 * @param el
	 */
	public void highlightWebElement(WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
	}

	/**
	 * This method is used to verify the presence of webelement
	 *
	 * @author sandhyapindi
	 * @param el
	 * @param seconds
	 * @return
	 */
	public boolean isElementPresent(WebElement el, String elementName, int seconds) {
		waitForPresenceOfElementLocated(el, driver,seconds);
		try {
			if (el.isDisplayed()) {
				testLogger.info(elementName+" is displayed - "+el.toString());
				return true;
			}
		} catch (NoSuchElementException e) {
			testLogger.info(elementName+" is not displayed - "+el.toString());
			return false;

		} catch (Exception e) {
			testLogger.info(elementName+" is not displayed - "+el.toString());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is used to verify text in the webelement
	 *
	 * @author sandhyapindi
	 * @param el
	 * @param seconds
	 * @param expectedText
	 * @return
	 */
	public boolean verifyText(WebElement el, String elementName, int seconds, String expectedText) {
		try {
			if (isElementPresent(el, elementName, seconds)
					&& (el.getText().trim().equalsIgnoreCase(expectedText) || el.getText().trim().contains(expectedText))) {
				testLogger.info("Text Matched; Actual text: "+el.getText()+"; Expected Text: "+expectedText);
				return true;
			} else {
				testLogger.error("Text NOT Matched; Actual text: "+el.getText()+"; Expected Text: "+expectedText);
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method returns boolean based on element selection
	 *
	 * @param el
	 * @param elementName
	 * @param seconds
	 * @return
	 */
	public boolean isSelected(WebElement el, String elementName, int seconds) {
		if (isElementPresent(el, elementName, seconds) && (el.isSelected() || el.getAttribute("checked").equals("checked"))) {
			testLogger.info(el.toString()+" is checked.");
			return true;
		}else{
			testLogger.info(el.toString()+" is NOT checked.");
			return false;
		}

	}

	/**
	 * This method generates random string based on usage
	 *
	 * @param count
	 * @param useLetters
	 * @param useNumbers
	 * @return
	 */
	public String generateRandomString(int count, boolean useLetters, boolean useNumbers) {
		return RandomStringUtils.random(count, useLetters, useNumbers);
	}

	/**
	 * This method clears input from the field using keyboard actions
	 *
	 * @param el
	 */
	public void clearInput(WebElement el) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.DELETE).perform();
	}

	/**
	 * This method is used to execute a Java script
	 *
	 * @param
	 */
	public void javaScriptExecute(String xpath) {
		WebElement we = driver.findElement(By.xpath(xpath));
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", we);
	}

	/**
	 * This method is used to read the Payment provider value from console
	 *
	 * @author sandhyapindi
	 */
	public String getPaymentProvider() {
		String paymentProvider = "";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		paymentProvider = (String) jse.executeScript("return LMS.pageData.paymentProvider");
		testLogger.info("Payment Provider: " + paymentProvider);
		return paymentProvider;
	}
	public void selectDropdownValues(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);

	}

	public String removeText(String text){
		String s=text.replaceAll("[^0-9.]","");
		return s;
	}

	public void enterPromoCode(WebElement element, String name) {
		element.sendKeys(name);
	}


	public static boolean verifyNoelement(WebElement element) {
		try {
			if(!element.isDisplayed()){
				return false;
			}else {
				return true;
			}
		}
    	catch(Exception e){
				return false;
			}
	}

	public static boolean isClickable(WebDriver driver,WebElement element) {
		try {
			new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void verifyLinks(String linkUrl)
	{
		try
		{

			URL url = new URL(linkUrl);
			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
			}

			//Fetching and Printing the response code obtained
			else{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
			}
		}catch (Exception e) {
		}
	}
}

