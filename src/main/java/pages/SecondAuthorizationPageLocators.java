package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SecondAuthorizationPageLocators {

    final SelenideElement PASSWORD_INPUT = $(By.id("ap_password"));
    final SelenideElement BTN_SUBMIT = $(By.id("signInSubmit"));
    final SelenideElement ERROR_MESSAGE = $(By.id("auth-error-message-box"));
    final SelenideElement USER_GREETING = $(By.id("nav-link-accountList-nav-line-1"));
    final SelenideElement CAPTCHA = $(By.id("cvf-page-content"));
}
