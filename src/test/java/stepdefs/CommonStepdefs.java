package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Common;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommonStepdefs {
    private Common common = new Common();

    @Given("^I open (.*)$")
    public void openHomePage(String url) {
        open(url);
    }

    @When("^I click on element by text: (.*)$")
    public void clickByText(String text) {
        common.clickByText(text);
    }

    @When("^I click on element by value: (.*)$")
    public void clickOnElementByValue(String value) {
        common.clickOnElementByValue(value);
    }

    @And("^I enter (.*) to (.*)$")
    public void enterDataToFieldByLabel(String text, String label) {
        common.enterDataToFieldByLabel(text, label);
    }

    @Then("^I check that page contains text: (.*)$")
    public static void checkTextOnPage(String value) {
        $(byTagName("body")).shouldHave(text(value));
    }
}
