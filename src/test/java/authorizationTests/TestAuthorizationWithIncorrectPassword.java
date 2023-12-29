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

public class TestAuthorizationWithIncorrectPassword extends InitialSelenide {


    final String EXPECTED_MESSAGE = "There was a problem\n" +
            "We cannot find an account with that email address";
    String CORRECT_EMAIL = "odnolkovalentyna@gmail.com";
    String INCORRECT_PASSWOR = "qwertyuio333333333";


    @Test
    @Owner("Valentyna")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization with incorrect password")
    public void checkAuthorizationWithIncorrectPassword(){

        openPage(Urls.MAIN.url);
        changeCookie();
        Assert.assertTrue(
        new MainePage().openAuthorizationPage()
                .enterEmailAndSubmit(CORRECT_EMAIL).enterPasswordAndSubmit(INCORRECT_PASSWOR).getCaptcha());


    }
}
