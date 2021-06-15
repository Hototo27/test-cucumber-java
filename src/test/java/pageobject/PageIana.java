package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PageIana {
    @FindBy(css = "title")
    public SelenideElement title;

    @FindBy(css = "#header")
    public SelenideElement header;

    @FindBy(css = "#body")
    public SelenideElement body;

    @FindBy(css = "#main_right")
    public SelenideElement mainRight;

    @FindBy(css = "#sidebar_left")
    public SelenideElement sidebarLeft;
}
