package com.todolist.dashboard

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.todolist.helpers.BasePageObject
import com.kms.katalon.core.testobject.TestObject

public class DashboardPage extends BasePageObject {
	private TestObject lbl_dashboard
	private TestObject btn_addTask
	private TestObject lbl_taskList
	private TestObject inp_title
	private TestObject inp_description
	private TestObject drp_status
	private TestObject lbl_addEditTask
	private TestObject btn_save
	private TestObject btn_yesConfirm
	private TestObject td_titleTask
	private TestObject chk_statusTask
	private TestObject lbl_errorMessage
	private TestObject btn_Edit
	private TestObject btn_Delete
	private TestObject btn_Confirm
	
	public DashboardPage() {
		super()
		lbl_dashboard   = createTestObjectByXpath("lbl_dashboard", "//*[@text='Dashboard']")
		btn_addTask     = createTestObjectByXpath("btn_addTask", "//*[@resource-id='btn_addTask']")
		lbl_taskList    = createTestObjectByXpath("lbl_taskList", "//*[@text='Task List']")
		inp_title       = createTestObjectByXpath("inp_title", "//*[@resource-id='title-task']")
		inp_description = createTestObjectByXpath("inp_description", "//*[@resource-id='description-task']")
		drp_status      = createTestObjectByXpath("drp_status", "//*[@resource-id='status-task']")
		lbl_addEditTask = createTestObjectByXpath("lbl_addEditTask", "//*[@text='Add / Edit Task']")
		btn_save 		= createTestObjectByXpath("btn_save", "//*[@resource-id='save-task']")
		btn_yesConfirm  = createTestObjectByXpath("btn_yesConfirm", "//*[@resource-id='yes-confirm']")
		lbl_errorMessage = createTestObjectByXpath("error_titleTooLong","//*[@text='Title cannot exceed 50 characters']")
		
	}
	
	public boolean verifyLanding() {
		return verifyElementPresent(lbl_dashboard)
	}
	
	public boolean verifyLandingAddEditTask() {
		return verifyElementPresent(lbl_addEditTask)
	}
	
	public boolean verifyDashBoardPage() {
		boolean isPresent = verifyElementPresent(lbl_dashboard)
		isPresent = verifyElementPresent(inp_title)
		isPresent = verifyElementPresent(inp_description)
		isPresent = verifyElementPresent(drp_status)
		isPresent = verifyElementPresent(btn_save)
		return isPresent
	}
	
	public boolean verifyAddTaskPage() {
		boolean isPresent = verifyElementPresent(lbl_addEditTask)
		isPresent = verifyElementPresent(lbl_addEditTask)
		isPresent = verifyElementPresent(btn_addTask)
		return isPresent
	}
	
	public void addNewTask(String title, String description, String status) {
		Mobile.tap(btn_addTask, 10)
		Mobile.setText(inp_title, title, 10)
		Mobile.setText(inp_description, description, 10)
		Mobile.tap(drp_status, 10)
		// Assuming status is a dropdown, select via text
		TestObject statusOption = createTestObjectByXpath("status_option", "//*[@text='" + status + "']")
		Mobile.tap(statusOption, 10)
		Mobile.tap(btn_save, 5)
		Mobile.tap(btn_yesConfirm, 3)
	}
	
	public boolean verifySuccesAddEditTask(String title) {
		td_titleTask = createTestObjectByXpath("td_titleTask", "//*[@text='" + title + "']")

		return verifyElementPresent(td_titleTask)
	}
	
	public boolean verifyStatusDoneTask(String title) {
		chk_statusTask = createTestObjectByXpath("chk_statusTask","//*[@text='" + title + "']/preceding-sibling::*[@class='android.widget.CheckBox']")
		return verifyElementPresent(chk_statusTask)
	}
	
	public boolean verifyErrorMessage() {
		return verifyElementPresent(lbl_errorMessage)
	}
	
	public boolean verifyTaskDeleted(String title) {
		td_titleTask = createTestObjectByXpath("td_titleTask", "//*[@text='" + title + "']")
		return verifyElementNotPresent(td_titleTask)
	}
	
	public void editTask(String oldTitle, String newTitle, String newDescription, String newStatus) {
	    btn_Edit = createTestObjectByXpath("btn_edit_" + oldTitle,"//*[@text='" + oldTitle + "']/following-sibling::*[@text='Edit']")
	    
	    Mobile.tap(btn_Edit, 10)
	    
	    Mobile.clearText(inp_title, 10)
	    Mobile.setText(inp_title, newTitle, 10)
	
	    Mobile.clearText(inp_description, 10)
	    Mobile.setText(inp_description, newDescription, 10)
	
	    Mobile.tap(drp_status, 10)
	    TestObject statusOption = createTestObjectByXpath("status_option", "//*[@text='" + newStatus + "']")
	    Mobile.tap(statusOption, 10)
	
	    Mobile.tap(btn_save, 10)
	}
	
	public void deleteTaskYesConfirm(String title) {
	    btn_Delete = createTestObjectByXpath(
	        "btn_delete_" + title,
	        "//*[@text='" + title + "']/following-sibling::*[@text='Delete']"
	    )
	    
	    Mobile.tap(btn_Delete, 10)
	    
	    btn_Confirm = createTestObjectByXpath("btn_confirmDelete", "//*[@text='Yes']")
	    if (verifyElementPresent(btn_Confirm)) {
	        Mobile.tap(btn_Confirm, 10)
	    }
	}
	
	public void deleteTaskNoConfirm(String title) {
		btn_Delete = createTestObjectByXpath(
			"btn_delete_" + title,
			"//*[@text='" + title + "']/following-sibling::*[@text='Delete']"
		)
		
		Mobile.tap(btn_Delete, 10)
		
		btn_Confirm = createTestObjectByXpath("btn_confirmDelete", "//*[@text='No']")
		if (verifyElementPresent(btn_Confirm)) {
			Mobile.tap(btn_Confirm, 10)
		}
	}

	 
}
