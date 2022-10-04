package com.GCReddy_v1.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GCReddy.TestPages.Administrator_LoginPage;

public class TC1001_Administrator_loginTest extends  BaseClass {
	
  @Test(priority=0)
  public void loginWithValidCredentials() throws IOException {
	  logger.info("loginWithValidCredentials");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.setUsername("gcreddy"); logger.info("username enterd");
	  lpage.setPassword("Temp@2020"); logger.info("password enterd");
	  lpage.clickLoginBtn(); logger.info("login button clicked");
	 
	  String actualURL=getURL();
	  if(actualURL.contains("http://gcreddy.com/project/admin/index.php")) {
		  captureScreen(driver,"loginTest");
		  lpage.clickLogoffBtn();
		  logger.info("loginWithValidCredentials passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  logger.info("loginWithValidCredentials failed");
		  Assert.assertEquals(actualURL, "http://gcreddy.com/project/admin/index.php");
	  }
		  
  }
  @Test (priority=1)
  public void loginWithInvalidCredentials() throws IOException {
	  logger.info("loginWithInvalidCredentials");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.setUsername("jhjkasldh"); logger.info("username enterd");
	  lpage.setPassword("klj;das"); logger.info("password enterd");
	  lpage.clickLoginBtn();logger.info("login button clicked");
	  String text=lpage.getErrorText();
	  if(text.contains(" Error: Invalid administrator login attempt.")) {
		  captureScreen(driver,"loginWithValidCredentials");
		  logger.info("loginWithInvalidCredentials Passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  logger.info("loginWithInvalidCredentials Failed");
		  Assert.assertEquals(text, " Error: Invalid administrator login attempt.");
	  }
	  
  }
  @Test (priority=2)
  public void loginWithValidUsernameAndInvalidPassword() throws IOException {
	  logger.info("loginWithValidUsernameAndInvalidPassword");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.clearField();
	  lpage.setUsername("gcreddy"); logger.info("username enterd");
	  lpage.setPassword("asmdkl;"); logger.info("password enterd");
	  lpage.clickLoginBtn(); logger.info("login button clicked");
	  String text=lpage.getErrorText();
	  if(text.contains(" Error: Invalid administrator login attempt.")) {
		  captureScreen(driver,"loginWithValidUsernameAndInvalidPassword");
		  logger.info("loginWithValidUsernameAndInvalidPassword Passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  logger.info("loginWithValidUsernameAndInvalidPassword Failed");
		  Assert.assertEquals(text, "Error: Invalid administrator login attempt.");
	  }
	  
  }
  
  @Test (priority=3)
  public void loginWithInvalidUsernameAndValidPassword() throws IOException {
	  logger.info("loginWithInvalidUsernameAndValidPassword");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.clearField();
	  lpage.setUsername("jklklklj"); logger.info("username enterd");
	  lpage.setPassword("Temp@2020"); logger.info("password enterd");
	  lpage.clickLoginBtn(); logger.info("login button clicked");
	  String text=lpage.getErrorText();
	  if(text.contains("Error: Invalid administrator login attempt.")) {
		  captureScreen(driver,"loginTest");
		  logger.info(" loginWithInvalidUsernameAndValidPassword Passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  logger.info("loginWithValidUsernameAndInvalidPassword Failed");
		  Assert.assertEquals(text, "Error: Invalid administrator login attempt.");
	  }
	  
  }
  @Test (priority=4)
  public void maxlogin() throws IOException {
	  logger.info("maxlogin");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.clearField(); 
	  lpage.setUsername("jklklklj"); logger.info("username enterd");
	  lpage.setPassword("Temp@2020"); logger.info("password enterd");
	  lpage.clickLoginBtn(); logger.info("login button clicked");
	  String text=lpage.getErrorText();
	  if(text.contains(" Error: The maximum number of login attempts has been reached. Please try again in 5 minutes.")) {
		  captureScreen(driver,"maxlogin");
		  logger.info("maxlogin Passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  logger.info("maxLogin failed");
		  Assert.assertEquals(text, " Error: The maximum number of login attempts has been reached. Please try again in 5 minutes.");
	  }
	  
  }
  @Test(priority=5)
  public void loginAfterMaxLogin() throws Exception {
	  Thread.sleep(300000);
	  logger.info("loginAfterMaxLogin");
	  Administrator_LoginPage lpage=new Administrator_LoginPage(driver);
	  lpage.clearField(); 
	  lpage.setUsername("gcreddy"); logger.info("username enterd");
	  lpage.setPassword("Temp@2020"); logger.info("password enterd");
	  lpage.clickLoginBtn(); logger.info("login button clicked");
	 
	  String actualURL=getURL();
	  if(actualURL.contains("http://gcreddy.com/project/admin/index.php123")) {
		 
		  lpage.clickLogoffBtn();
		  logger.info("loginAfterMaxLogin passed");
		  Assert.assertTrue(true);
	  }
	  else {
		  captureScreen(driver,"loginAfterMaxLogin");
		  logger.info("loginAfterMaxLogin failed");
		  Assert.assertEquals(actualURL, "http://gcreddy.com/project/admin/index.php123");
	  }
  }
  @Test(priority=6)
  public void  redirectingToCustomerTest() throws Exception {
	  Administrator_LoginPage lpage= new Administrator_LoginPage(driver);
	  lpage.clickCustBtn(); logger.info("redirecting to customer customer");
	  String actualTitle=getTitle();
	  if(actualTitle.contains("GCR Shop")) {
		 logger.info("redirected to customer page");
		 Assert.assertTrue(true);
	  }
	  else {
		  captureScreen(driver,"redirectingToCustomerTest");
		  logger.info("not redirected to customer page");
		  Assert.assertEquals(actualTitle, "GCR Shop");
	  }
	  
  }
  
}
