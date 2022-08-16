package net.javaguides.sms.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateStudentPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement headerPage;

    @FindBy(xpath = "//div[@class='form-group'][1]/label")
    private WebElement labelsFirstName;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//div[@class='form-group'][2]/label")
    private WebElement labelsLastName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//div[@class='form-group'][2]/label")
    private WebElement labelsEmail;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitForm;

    public StudentsPage clickSubmit() {
        buttonSubmitForm.submit();
        return new StudentsPage();
    }

    public boolean isHeaderPageDisplayed() {
        return isElementDisplayed(headerPage);
    }

    public boolean isLabelsFirstNameDisplayed() {
        return isElementDisplayed(headerPage);
    }

    public boolean isLabelsLastNameDisplayed() {
        return isElementDisplayed(labelsLastName);
    }

    public boolean isLabelsEmailDisplayed() {
        return isElementDisplayed(labelsEmail);
    }

    public boolean isButtonSubmitFormDisplayed() {
        return isElementDisplayed(buttonSubmitForm);
    }

    public CreateStudentPage typeFirstName(String firstName) {
        clearAndTypeToField(inputFirstName, firstName);
        return this;
    }

    public CreateStudentPage typeLastName(String lastName) {
        clearAndTypeToField(inputLastName, lastName);
        return this;
    }

    public CreateStudentPage typeEmail(String email) {
        clearAndTypeToField(inputEmail, email);
        return this;
    }
}