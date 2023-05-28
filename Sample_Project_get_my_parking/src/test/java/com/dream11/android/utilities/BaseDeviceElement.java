/**
 * BaseDeviceElement
 * 
 * @author Bhargav Chirumamilla LandmarkGroup, Created by Bhargav Chirumamilla
 *         on 04/10/2019 Copyright (c) 2019 LandmarkGroup . All rights reserved.
 * 
 */

package com.dream11.android.utilities;

import java.util.Calendar;
import java.util.Random;

import com.dream11.android.helper.LoggerHelper;
import com.dream11.android.launcher.TestHarness;
import org.apache.log4j.Logger;

import com.dream11.android.config.config;

import io.appium.java_client.MobileElement;

public abstract class BaseDeviceElement extends TestHarness {
	protected Object elementSelector;
	protected static Logger log = LoggerHelper.getLogger(BaseDeviceElement.class);

	public static long getCurrentDate() {

		Calendar cal = Calendar.getInstance();
		return cal.getTime().getTime();
	}

	public static int getRandomNumber() {

		Random rnd = new Random();
		int id = rnd.nextInt(5000);
		return id;

	}



	public boolean verify_element_Enabled(MobileElement element) {
		boolean res = element.isEnabled();
		log.info("User found  element in screen is available : " + res);
		return res;
	}

	public boolean verify_element_Display(MobileElement element) {
		boolean res = element.isDisplayed();
		log.info("User found  element is Displayed in screen is available : " + res);
		return res;
	}

	public String verify_element_Present(MobileElement element) {
		boolean res = element.isDisplayed();
		log.info("User found  element is Displayed in screen is available : " + res);
		return null;
	}

	public void tap(MobileElement element) {
		element.click();
		log.info("User Tap MobileElement is  : " + element);

		// tap(sizeList.get(i));
	}


	public void clearTextBoxWithTip(MobileElement element) {
		element.clear();
		log.info("User Clear Text Box With Tip is  : " + element);
	}

	public String verify_text_value(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("value").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("name").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}
	}

	public String verify_text_label(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("label").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("name").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}

	}

	public String verify_text_text(MobileElement element) throws InterruptedException {
		if (config.getPlatform().equalsIgnoreCase("iOS")) {
			String text = element.getAttribute("value").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		} else {
			String text = element.getAttribute("text").replaceAll("\\r|\\n", "");
			log.info("User found text in screen is available : " + text);
			return text;
		}
	}



	public boolean split(MobileElement Element) throws InterruptedException {
		String str = null;
		str = verify_text_label(Element);
		splitString(str);
		return true;
	}

	public void splitString(String str) {
		StringBuffer alpha = new StringBuffer(), num = new StringBuffer(), special = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));

			else if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));

			else
				special.append(str.charAt(i));
		}
		log.info("Product Number  is : " + num);
		log.info("Alphabetic is : " + alpha);
		log.info("Spcl Char  is : " + special);
	}

	public void split_Length(MobileElement Element) throws InterruptedException {
		String strMain = null;
		strMain = verify_text_label(Element);
		String[] arrSplit = strMain.split("\\s");
		for (int i = 0; i < arrSplit.length; i++) {
			log.info(arrSplit[i]);

		}
	}

	public boolean split_Number(MobileElement Element) throws InterruptedException {
		String str = null;
		str = verify_text_label(Element);
		split_Count(str);
		return true;
	}

	public void split_Count(String str) {
		StringBuffer num = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
		}
		log.info("Product Number is : " + num);
	}

	public boolean integerFormat(MobileElement Element) throws InterruptedException {
		{
			// Split into Numbers
			String str = verify_text_text(Element);
			String[] format = str.split("(?<=\\D)(?=\\d)");
			log.info("Alphabet is : " + format[0]);
			log.info("Numberic  is : " + format[1]);
			// Verify Number In Integer format
			log.info("Number is in Integer Format : " + Integer.parseInt(format[1]));
			// Convert String to int
			String num = format[1];
			int inum = Integer.parseInt(num);
			// Length of String
			int len = String.valueOf(inum).length();
			log.info("Number of digits: " + len);
			// Verify Length of price is equals to 3 digits or less than 4 & not
			// equals to zero
			if (len != 0 & len <= 3) {
				return true;
			} else {
				return false;
			}

		}

	}

	public boolean decimalFormat(MobileElement Element) throws InterruptedException {
		{
			// Split into Numbers
			String str = verify_text_text(Element);
			String[] format = str.split("(?<=\\D)(?=\\d)");
			log.info("Alphabet is : " + format[0]);
			log.info("Numberic  is : " + format[1]);
			// Verify Number In Decimal/Double format
			log.info("Number is in Decimal Format : " + Double.parseDouble(format[1]));
			// Convert String to Double

			String num = format[1];
			double inum = Double.parseDouble(num);
			// Length of String
			double len = String.valueOf(inum).length();
			log.info("Number of digits: " + len);

			// Verify Length of price is equals to 4.0 digits or less than 4.0
			// equals to zero
			if (len != 0 & len <= 4.0) {

				return true;
			} else {
				return false;
			}
		}

	}

}
