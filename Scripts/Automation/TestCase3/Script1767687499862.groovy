import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.FacebookLoginPage

// Open Facebook
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.facebook.com/')

// Initialize page object
FacebookLoginPage loginPage = new FacebookLoginPage()

// Click "Forgotten password?"
loginPage.clickForgotPassword()

// Verify "Find Your Account" header
String actualHeader = loginPage.getFindAccountHeaderText()
WebUI.verifyMatch(actualHeader, "Find Your Account", false)