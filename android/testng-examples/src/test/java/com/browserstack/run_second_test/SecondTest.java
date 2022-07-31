package com.browserstack.run_second_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class SecondTest extends BrowserStackTestNGTest {

	String usernameFldID = "test-Username";
	String passwordFldID = "test-Password";
	String loginBtnID = "test-LOGIN";
	String username = "standard_user";
	String password = "secret_sauce";
	By productTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");

	@Test
	public void test() throws Exception {

		System.out.println("SauceLabs Login");
		login(username, password);
		Assert.assertTrue(isOnProductPage());
	}

	public void login(String user, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement usernameFld = wait
				.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(usernameFldID)));
		WebElement passwordFld = driver.findElementByAccessibilityId(passwordFldID);
		WebElement loginBtn = driver.findElementByAccessibilityId(loginBtnID);

		usernameFld.sendKeys(user);
		passwordFld.sendKeys(pass);
		loginBtn.click();
	}

	public boolean isOnProductPage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
}