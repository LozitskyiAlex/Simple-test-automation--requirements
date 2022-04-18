import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.BrowserPerTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import io.cucumber.testng.CucumberOptions;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepdefs",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
@Listeners({ BrowserPerTest.class})
public class RunAllTest extends AbstractTestNGCucumberTests {

    AllureSelenide allureSelenide;

    @BeforeMethod
    public void addAllureListener() {
        allureSelenide = new AllureSelenide().enableLogs(LogType.DRIVER, Level.ALL);
        SelenideLogger.addListener("allure", allureSelenide);
    }

    @AfterClass
    public void logout() {
        closeWebDriver();
        SelenideLogger.removeListener("allure");
    }
}
