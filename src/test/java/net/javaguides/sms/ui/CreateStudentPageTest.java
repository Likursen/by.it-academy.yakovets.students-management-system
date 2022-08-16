package net.javaguides.sms.ui;

import net.javaguides.sms.ui.object.Student;
import net.javaguides.sms.ui.pages.CreateStudentPage;
import net.javaguides.sms.ui.pages.StudentsPage;
import net.javaguides.sms.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateStudentPageTest extends BaseTest {

    @Test
    public void createStudentsPageUITest() {
        CreateStudentPage createStudentPage = new StudentsPage().openPage()
                .clickAddStudent();

        Assert.assertTrue(createStudentPage.isHeaderPageDisplayed());
        Assert.assertTrue(createStudentPage.isLabelsFirstNameDisplayed());
        Assert.assertTrue(createStudentPage.isLabelsLastNameDisplayed());
        Assert.assertTrue(createStudentPage.isLabelsEmailDisplayed());
        Assert.assertTrue(createStudentPage.isButtonSubmitFormDisplayed());
    }

    @Test
    public void createStudentsTest() {
        Student student = new Student(Utils.generateRandomSting(), Utils.generateRandomSting(), Utils.generateRandomSting());

        StudentsPage studentsPage = new StudentsPage().openPage()
                .clickAddStudent()
                .typeFirstName(student.getFirstName())
                .typeLastName(student.getLastName())
                .typeEmail(student.getEmail())
                .clickSubmit();
        boolean isStudentFind = studentsPage.findStudent(student);

        Assert.assertTrue(isStudentFind);
    }
}