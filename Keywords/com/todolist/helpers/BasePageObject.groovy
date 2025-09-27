package com.todolist.helpers

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

public class BasePageObject {

    def TestObject createTestObjectByXpath(String objName, String objXpath) {
        return new TestObject(objName).addProperty("xpath", ConditionType.EQUALS, objXpath)
    }

    def boolean verifyElementVisible(TestObject obj) {
        return Mobile.verifyElementVisible(obj, 5, FailureHandling.OPTIONAL)
    }

    def boolean verifyElementPresent(TestObject obj) {
        return Mobile.verifyElementExist(obj, 5, FailureHandling.OPTIONAL)
    }
	
	def boolean verifyElementNotPresent(TestObject obj) {
		return Mobile.verifyElementNotExist(obj, 5, FailureHandling.OPTIONAL)
	}
}
