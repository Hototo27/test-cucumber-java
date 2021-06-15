package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private ChromeDriver driver;

    WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Max\\IdeaProjects\\test-cucumber-java\\src\\test\\resources\\test\\chromedriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.CAPABILITY, capabilities);
      //  options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        return driver;
    }
}
