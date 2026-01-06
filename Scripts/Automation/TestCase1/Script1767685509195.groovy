import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.FacebookLoginPage
import pages.FacebookErrorPage

// Open Facebook
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.facebook.com/')

// Initialize page objects
FacebookLoginPage loginPage = new FacebookLoginPage()
FacebookErrorPage errorPage = new FacebookErrorPage()

// Enter credentials
loginPage.enterEmail('test123@gmail.com')
loginPage.enterPassword('tazepd6ld0M=')

// Click login
loginPage.clickLogin()

// Verify error message
String actualError = errorPage.getErrorMessage()
WebUI.verifyMatch(actualError, 'Invalid username or password', false)
