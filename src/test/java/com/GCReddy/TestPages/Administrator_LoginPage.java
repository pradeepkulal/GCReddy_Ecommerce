package com.GCReddy.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Administrator_LoginPage {
	WebDriver ldriver;
	public Administrator_LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Locating page Elements
	@FindBy(xpath="//input[@name='username']")WebElement usernameInput;
	@FindBy(xpath="//input[@name='password']")WebElement passwordInput;
	@FindBy(xpath="//span[@class='ui-button-text']")WebElement loginBtn;
	@FindBy(xpath="(//a[@class='headerLink'])[3]")WebElement logoffBtn;
	@FindBy(xpath="//td[@class='messageStackError']")WebElement errorMsg;
	@FindBy(xpath="(//a[@class='headerLink'])[2]") WebElement custBtn;
	//methods
	public void setUsername(String username) {
		usernameInput.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void clickLoginBtn() {
		loginBtn.click();
	}
	public void clickLogoffBtn() {
		logoffBtn.click();
	}
	public String getErrorText() {
		return errorMsg.getText();
	}
	public void clearField() {
		usernameInput.clear();
	}
	public void clickCustBtn() {
		custBtn.click();
	}
}
