package com.todolist.loginpage

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.todolist.helpers.BasePageObject

public class LoginPage extends BasePageObject {
	private TestObject lbl_Login
	private TestObject inp_Email
	private TestObject inp_Password
	private TestObject btn_Login
	private TestObject lbl_ErrorMessage
	
	public LoginPage() {
		super()
		// Adapted for mobile: using resource-id and text
		lbl_Login       = createTestObjectByXpath("lbl_Login", "//*[@text='Login']")
		inp_Email       = createTestObjectByXpath("inp_Email", "//*[@resource-id='email']")
		inp_Password    = createTestObjectByXpath("inp_Password", "//*[@resource-id='password']")
		btn_Login       = createTestObjectByXpath("btn_Login", "//*[@resource-id='btn_login']")
		lbl_ErrorMessage= createTestObjectByXpath("lbl_ErrorMessage", "//*[@resource-id='error_msg']")
	}
	
	public void doLogin(String email, String password) {
		Mobile.startApplication("", false)
		Mobile.setText(inp_Email, email, 10)
		Mobile.setText(inp_Password, password, 10)
		Mobile.tap(btn_Login, 10)
	}
	
	public boolean verifyErrorMessage() {
		return verifyElementPresent(lbl_ErrorMessage)
	}
	
	public boolean verifyLandingPage() {
		return verifyElementPresent(lbl_Login)
	}
}
