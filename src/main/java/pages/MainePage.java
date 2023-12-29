package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainePage extends ManePageLocators {

    public MainePage openMainPageAmazon(){
        open("https://www.amazon.com/");
        return this;
    }

    @Step("Go to the authorization page")
    public AuthorizationPage openAuthorizationPage(){
        ACCOUNT_HOVER_LINK.hover().click();
        return page(AuthorizationPage.class);
    }



}
