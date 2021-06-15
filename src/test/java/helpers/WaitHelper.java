package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WaitHelper {
    static WebDriverWait wait = new WebDriverWait(getWebDriver(), 15);

    public static boolean waitVisiblityOf(SelenideElement elem, int sec){
        sleep(500);
        WaitHelper.forAjax();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), sec);
        wait.until(ExpectedConditions.visibilityOf(elem));

        return true;
    }

    public static void waitVisiblityOf(SelenideElement elem){
        sleep(500);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public static boolean forAjax() {

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 15);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        sleep(1000);
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
