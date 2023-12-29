package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage extends AuthorizationPageLocators{

    @Step("Entering an email and clicking the accept button")
    public SecondAuthorizationPage enterEmailAndSubmit(String email){
        EMAIL_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(email);
        BTN_CONTINUE.click();
        return page(SecondAuthorizationPage.class);
    }




}
