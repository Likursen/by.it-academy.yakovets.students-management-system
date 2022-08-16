package net.javaguides.sms.ui;

import net.javaguides.sms.utils.Utils;
import net.javaguides.sms.ui.object.Student;
import net.javaguides.sms.ui.pages.EditStudentsPage;
import net.javaguides.sms.ui.pages.StudentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditStudentPageTest extends BaseTest {

    @Test
    public void editStudentPageUITest() {
        int editStudentNumber = 1;
        EditStudentsPage editStudentsPage = new StudentsPage().openPage()
                .clickUpdateStudent(editStudentNumber);

        Assert.assertTrue(editStudentsPage.isHeaderPageDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsFirstNameDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsLastNameDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsEmailDisplayed());
        Assert.assertTrue(editStudentsPage.isButtonSubmitFormDisplayed());
    }

    @Test
    public void editStudentTest() {
        Student student = new Student(Utils.generateRandomSting(), Utils.generateRandomSting(), Utils.generateRandomSting());
        int editStudentNumber = 1;
        StudentsPage studentsPage = new StudentsPage().openPage();
        Student notEditStudent = studentsPage.getStudentByNumber(editStudentNumber);

        studentsPage.clickUpdateStudent(editStudentNumber)
                .typeFirstName(student.getFirstName())
                .typeLastName(student.getLastName())
                .typeEmail(student.getEmail())
                .clickSubmit();

        boolean isEditStudentsPresent = studentsPage.findStudent(notEditStudent);
        Assert.assertFalse(isEditStudentsPresent);
    }
}