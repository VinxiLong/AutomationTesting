package pages

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

class FacebookErrorPage {

    // Locator for error message
    TestObject errorMessage = new TestObject('errorMessage')
            .addProperty('xpath', ConditionType.EQUALS, "//div[contains(text(),'Invalid username or password')]")

    /**
     * Get the login error message
     */
    String getErrorMessage() {
        WebUI.waitForElementVisible(errorMessage, 10)
        return WebUI.getText(errorMessage)
    }
}
