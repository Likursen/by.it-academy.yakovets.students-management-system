package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.object.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class StudentsPage extends BasePage {
    private final String baseUrl = "http://localhost:8080/students";

    @FindBy(xpath = "//h1")
    private WebElement headerPage;

    @FindBy(xpath = "//a[@href='/students/new']")
    private WebElement linkAddStudent;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[1]")
    private WebElement titlesFirstName;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[2]")
    private WebElement titlesLastName;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[3]")
    private WebElement titlesEmail;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[4]")
    private WebElement titlesAction;

    public StudentsPage openPage() {
        webDriver.get(baseUrl);
        return this;
    }

    public boolean isHeaderPageDisplayed() {
        return isElementDisplayed(headerPage);
    }

    public boolean isTitlesFirstNameDisplayed() {
        return isElementDisplayed(titlesFirstName);
    }

    public boolean isTitlesLastNameDisplayed() {
        return isElementDisplayed(titlesLastName);
    }

    public boolean isTitlesEmailDisplayed() {
        return isElementDisplayed(titlesEmail);
    }

    public boolean isTitleActionDisplayed() {
        return isElementDisplayed(titlesAction);
    }

    public CreateStudentPage clickAddStudent() {
        linkAddStudent.click();
        return new CreateStudentPage();
    }

    public boolean isStudentUpdateButtonDisplayed(int studentNumber) {
        return getStudentItem(studentNumber)
                .isButtonUpdateDisplayed();
    }

    public boolean isStudentDeleteButtonDisplayed(int studentNumber) {
        return getStudentItem(studentNumber)
                .isButtonDeleteDisplayed();
    }

    public EditStudentsPage clickUpdateStudent(int studentNumber) {
        getStudentItem(studentNumber)
                .clickUpdate();
        return new EditStudentsPage();
    }

    public StudentsPage clickDeleteStudent(int studentNumber) {
        getStudentItem(studentNumber)
                .clickDelete();
        return this;
    }

    public List<Student> getStudents() {
        return getStudentItems()
                .stream()
                .map(StudentItem::generateStudent)
                .collect(Collectors.toList());
    }

    public Student getStudentByNumber(int number) {
        return getStudentItem(number)
                .generateStudent();
    }

    public boolean findStudent(Student student) {
        return getStudents()
                .stream()
                .anyMatch(s -> s.equals(student));
    }

    private List<StudentItem> getStudentItems() {
        return webDriver.findElements(StudentItem.STUDENT_ITEM)
                .stream()
                .map(StudentItem::new)
                .collect(Collectors.toList());
    }

    private StudentItem getStudentItem(int studentNumber) {
        List<StudentItem> studentsItems = getStudentItems();
        if (!studentsItems.isEmpty()) {
            return studentsItems.get(studentNumber - 1);
        }
        throw new RuntimeException("not found");
    }

    private static class StudentItem extends BasePage {
        private static final By STUDENT_ITEM = By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr");
        private final By firstName = By.xpath("./td[1]");
        private final By lastName = By.xpath("./td[2]");
        private final By email = By.xpath("./td[3]");
        private final By buttonUpdate = By.xpath("./td[4]/a[@class='btn btn-primary']");
        private final By buttonDelete = By.xpath("./td[4]/a[@class='btn btn-danger']");

        public StudentItem(SearchContext context) {
            super(context);
        }

        private Student generateStudent() {
            return new Student()
                    .setFirstName(getFirstName())
                    .setLastName(getLastName())
                    .setEmail(getEmail());
        }

        private String getFirstName() {
            return findElement(firstName)
                    .getText();
        }

        private String getLastName() {
            return findElement(lastName)
                    .getText();
        }

        private String getEmail() {
            return findElement(email)
                    .getText();
        }

        private void clickUpdate() {
            findElement(buttonUpdate)
                    .click();
        }

        private void clickDelete() {
            findElement(buttonDelete)
                    .click();
        }

        private boolean isButtonUpdateDisplayed() {
            return isElementDisplayed(buttonUpdate);
        }

        private boolean isButtonDeleteDisplayed() {
            return isElementDisplayed(buttonDelete);
        }
    }
}