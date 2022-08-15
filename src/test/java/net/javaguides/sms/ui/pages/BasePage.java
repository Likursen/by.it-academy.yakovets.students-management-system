package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.webDriver.WebDriverSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class BasePage {
    protected WebDriver webDriver = WebDriverSingleton.getWebDriver();

    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    protected BasePage(SearchContext context) {
        PageFactory.initElements(new DefaultElementLocatorFactory(context), this);
    }

    protected void clearAndTypeToField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}