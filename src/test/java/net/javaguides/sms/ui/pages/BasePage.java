package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.webDriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    WebDriver webDriver = WebDriverSingleton.getWebDriver();

    protected BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    protected void clearAndTypeToField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }


}