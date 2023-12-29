package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPageLocators {
    final SelenideElement EMAIL_INPUT = $(By.id("ap_email"));
    final SelenideElement BTN_CONTINUE = $(By.id("continue"));


}
