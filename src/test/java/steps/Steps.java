package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.WaitHelper;
import pageobject.PageIana;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class Steps {

    private PageIana page;
    private boolean elementVisible;

    @Given("open page ([^']*)")
    public void openPage(String url) {
        page = open(url, PageIana.class);
    }

    @When("I see title ([^']*)")
    public void title(String title) {
        assertEquals(page.title.innerText(), title);
    }

    @When("block ([^']*) visible")
    public void block(String block) {
        WaitHelper.forAjax();

        switch (block){
            case("Headers"):
                elementVisible = page.header.isDisplayed();
                break;

            case("Main right"):
                elementVisible = page.mainRight.isDisplayed();
                break;

            case("Body"):
                elementVisible = page.body.isDisplayed();
                break;

            case("Sidebar left"):
                elementVisible = page.sidebarLeft.exists();
                break;
        }

        assertTrue("Result: " + elementVisible, elementVisible);
    }
}