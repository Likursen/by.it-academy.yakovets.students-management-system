package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.object.Student;
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

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']/tbody/tr")
    private List<WebElement> items;

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
    public boolean isActionDisplayed() {
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
        return items.stream()
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

        @FindBy(xpath = "./td[1]")
        private WebElement firstName;

        @FindBy(xpath = "./td[2]")
        private WebElement lastName;

        @FindBy(xpath = "./td[3]")
        private WebElement email;

        @FindBy(xpath = "./td[4]/a[@class='btn btn-primary']")
        private WebElement buttonUpdate;

        @FindBy(xpath = "./td[4]/a[@class='btn btn-danger']")
        private WebElement buttonDelete;

        public StudentItem(WebElement student) {
            super(student);
        }

        private Student generateStudent() {
            return new Student()
                    .setFirstName(getFirstName())
                    .setLastName(getLastName())
                    .setEmail(getEmail());
        }

        private String getFirstName() {
            return firstName.getText();
        }

        private String getLastName() {
            return lastName.getText();
        }

        private String getEmail() {
            return email.getText();
        }

        private void clickUpdate() {
            buttonUpdate.click();
        }

        private void clickDelete() {
            buttonDelete.click();
        }

        private boolean isButtonUpdateDisplayed() {
            return isElementDisplayed(buttonUpdate);
        }

        private boolean isButtonDeleteDisplayed() {
            return isElementDisplayed(buttonDelete);
        }
    }
}