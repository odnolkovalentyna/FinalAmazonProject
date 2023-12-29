package listeners;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ProjectListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true));
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
    }
}
