package authorizationTests;

import initWebDriver.InitialSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainePage;
import urls.Urls;

public class TestAuthorizationWithIncorrectEmail extends InitialSelenide {


    final String EXPECTED_MESSAGE = "There was a problem\n" +
            "We cannot find an account with that email address";
    final String INCORRECT_EMAIL = "qwertyuio33333333333344444@gmail.com";


    @Test
    @Owner("Valentyna")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization with incorrect email")
    public void checkAuthorizationWithIncorrectEmail(){

        openPage(Urls.MAIN.url);
        changeCookie();
        String actualMessage = new MainePage().openAuthorizationPage()
                .enterEmailAndSubmit(INCORRECT_EMAIL)
                .getErrorMessage();
        Assert.assertEquals(EXPECTED_MESSAGE,actualMessage);

        Assert.assertTrue(true);
    }
}
