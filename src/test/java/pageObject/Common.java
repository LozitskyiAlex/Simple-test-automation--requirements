package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Common {

    private SelenideElement inputFieldByLabel(String label)  {
        return $(By.xpath("//label[contains(., '"+label+"')]/following-sibling::input"));
    }

    private SelenideElement elementWithValue(String value)  {
        return $(By.xpath("//*[contains(@value, '"+value+"')]"));
    }

    public void clickByText(String text) {
        $(byText(text)).click();
    }

    public void enterDataToFieldByLabel(String text, String label) {
        inputFieldByLabel(label).sendKeys(text);
    }

    public void clickOnElementByValue(String value) {
        elementWithValue(value).click();
    }
}
