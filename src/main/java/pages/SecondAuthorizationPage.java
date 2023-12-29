package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

public class SecondAuthorizationPage extends SecondAuthorizationPageLocators{



    @Step("Entering an password and clicking the accept button")
    public SecondAuthorizationPage enterPasswordAndSubmit(String password){
        PASSWORD_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(password);
        BTN_SUBMIT.click();
        return this;
    }

    @Step("Getting error text")
    public String getErrorMessage (){
        return ERROR_MESSAGE.shouldBe(Condition.visible,Duration.ofSeconds(15)).getText();
    }

    @Step("Getting captcha")
    public boolean getCaptcha (){
        return CAPTCHA.shouldBe(Condition.visible,Duration.ofSeconds(15)).isDisplayed();

    }

    @Step("Retrieving the user's greeting text")
    public String getUserGreeting(){
        return USER_GREETING.shouldBe(Condition.appear).getText();
    }


}
