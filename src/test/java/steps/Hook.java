package steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hook {
    private WebDriver driver;

    @Before
    public void setup() {
        BaseDriver driverFactory = new BaseDriver();
        driver = driverFactory.getDriver();

        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("AFTER");
        final byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);

        if(scenario.isFailed()) scenario.embed(screenshot, "image/png");
        WebDriverRunner.closeWebDriver();
    }

}

