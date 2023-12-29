package authorizationTests;

import initWebDriver.InitialSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainePage;
import urls.Urls;

public class TestAuthorizationWithCorrectData extends InitialSelenide {

    private final String EXPECTED_USER_GREETING = "Hello, Valentyna";

    @DataProvider(name = "AuthorizationData")
    private Object[][] myData(){
        return new Object[][]{{"odnolkovalentyna@gmail.com", "fortestautodoc"},{"+380660950357", "fortestautodoc"}};
    }

    @Test(dataProvider = "AuthorizationData")
    @Owner("Valentyna")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization")
    public void checkAuthorizationWithCorrectEmail( String email, String password){

        openPage(Urls.MAIN.url);
        changeCookie();
        String actualGreeting = new MainePage().openAuthorizationPage()
                .enterEmailAndSubmit(email).enterPasswordAndSubmit(password).getUserGreeting();
        Assert.assertEquals(EXPECTED_USER_GREETING,actualGreeting);
    }

}
