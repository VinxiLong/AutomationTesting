package pages

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

class FacebookLoginPage {

    // --- Login Section ---
    TestObject inputEmail = new TestObject('inputEmail')
            .addProperty('xpath', ConditionType.EQUALS, "//input[@id='email']")
    TestObject inputPassword = new TestObject('inputPassword')
            .addProperty('xpath', ConditionType.EQUALS, "//input[@id='pass']")
    TestObject loginButton = new TestObject('loginButton')
            .addProperty('xpath', ConditionType.EQUALS, "//button[@name='login']")

    void enterEmail(String email) {
        WebUI.setText(inputEmail, email)
    }

    void enterPassword(String password) {
        WebUI.setEncryptedText(inputPassword, password)
    }

    void clickLogin() {
        WebUI.waitForElementClickable(loginButton, 10)
        WebUI.click(loginButton)
    }

    // --- Error Message Section (support multiple messages) ---
    TestObject errorMessage = new TestObject('errorMessage')
            .addProperty('xpath', ConditionType.EQUALS, 
                "//div[contains(text(),'Invalid username or password')" +
                " or contains(text(),'Email required')" +
                " or contains(text(),'Password required')]")

    /**
     * Get any login error message
     * Can return: "Invalid username or password", "Email required", "Password required"
     */
    String getErrorMessage() {
        WebUI.waitForElementVisible(errorMessage, 10)
        return WebUI.getText(errorMessage)
    }

    // --- Forgot Password Section ---
    TestObject forgotPasswordLink = new TestObject('forgotPassword')
            .addProperty('xpath', ConditionType.EQUALS, "//a[text()='Forgotten password?']")
    TestObject findAccountHeader = new TestObject('findAccountHeader')
            .addProperty('xpath', ConditionType.EQUALS, "//h2[text()='Find Your Account']")

    void clickForgotPassword() {
        WebUI.waitForElementClickable(forgotPasswordLink, 10)
        WebUI.click(forgotPasswordLink)
    }

    String getFindAccountHeaderText() {
        WebUI.waitForElementVisible(findAccountHeader, 10)
        return WebUI.getText(findAccountHeader)
    }
}
