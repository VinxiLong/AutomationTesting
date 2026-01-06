import pages.FacebookLoginPage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.facebook.com/')

FacebookLoginPage fb = new FacebookLoginPage()

// You can skip email/password input if testing blank login
// fb.enterEmail('test123@gmail.com')
// fb.enterPassword('tazepd6ld0M=')

fb.clickLogin()

// Verify any of the three possible messages
WebUI.verifyMatch(fb.getErrorMessage(), '(Email required|Password required|Invalid username or password)', true)
