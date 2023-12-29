package initWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InitialSelenide {



    public final String X_AMZ_CAPTCHA_1;
    public final String X_AMZ_CAPTCHA_2;
    public final String CSM_HIT;
    public final String CP_CDN;
    private final ChromeOptions chromeOptions = new ChromeOptions();

    {
        X_AMZ_CAPTCHA_1 = "1703846491696784";
        X_AMZ_CAPTCHA_2 = "03I8TImkltx87BBY2V46Uw==";
        CSM_HIT = "tb:2M3VQGQ5EFXMR00FC08A+s-2M3VQGQ5EFXMR00FC08A|1703839312456&t:1703839312456&adb:adblk_yes";
        CP_CDN = "\"L5Z9:PL\"";
    }

    @BeforeMethod
    public void selenideSetUp() {

        chromeOptions.addArguments("--start-maximized");
        Configuration.browserSize = "3200х2000";
        chromeOptions.addArguments("user-agent=" + getRandomUserAgent());
        Configuration.timeout = 10000;
        Configuration.browserCapabilities = chromeOptions;
    }


    @AfterMethod
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

    private static String getRandomUserAgent() {
        int value = (int) (Math.random() * UserAgent.values().length);
        List<UserAgent> userAgents = List.of(UserAgent.values());
        return userAgents.get(value).value;
    }

    public void openPage(String url) {
        open(url);
    }

    public void changeCookie() {
        Cookie cookie = new Cookie("x-amz-captcha-1", X_AMZ_CAPTCHA_1);
        getWebDriver().manage().addCookie(cookie);
        Cookie cookie2 = new Cookie("x-amz-captcha-2", X_AMZ_CAPTCHA_2);
        getWebDriver().manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("csm-hit", CSM_HIT);
        getWebDriver().manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("sp-cdn", CP_CDN);
        getWebDriver().manage().addCookie(cookie4);
        getWebDriver().navigate().refresh();
    }

}
