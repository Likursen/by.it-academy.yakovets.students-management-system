package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.webDriver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    protected WebDriver webDriver = WebDriverSingleton.getWebDriver();
    private SearchContext context;

    public BasePage() {
        PageFactory.initElements(webDriver, this);
        context = webDriver;
    }

    public BasePage(SearchContext context) {
        this.context = context;
    }

    protected void clearAndTypeToField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator) {
        List<WebElement> elements = context.findElements(locator);
        if (!elements.isEmpty()) {
            return elements.get(0)
                    .isDisplayed();
        }
        return false;
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected WebElement findElement(By by) {
        return context.findElement(by);
    }
}