package tests;

import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.RegistrationPage;

public class StudentRegistrationFormTest extends BasePage {
    @Test
    void RegistrationForm() {

        String firstName = "Jovan";
        String lastName = "Savovich";
        String userMail = "kgb@jovan.ru";
        String userNumber = "4999886645";
        String currentAddress = "Leprosorium";
        String day = "05";
        String month = "April";
        String year = "1993";
        String subjects = "Hindi";
        String hobbies = "1";
        String filePath = "src/test/resources/cat.jpg";
        String cityIndex = "0";
        String stateIndex = "0";


        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userMail)
                .setGender()
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .checkHobbies(hobbies)
                .uploadFile(filePath)
                .setCurrentAddress(currentAddress)
                .setState(stateIndex)
                .setCity(cityIndex)
                .submitForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year);
    }

}
