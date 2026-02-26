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
        String mounth = "April";
        String year = "1993";
        String subjects = "Hindi";
        String hobbies = "1";
        String patchName = "src/test/resources/cat.jpg";
        String city = "0";
        String state = "0";


        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userMail)
                .setGender()
                .setNumber(userNumber)
                .setBirthDate(day, mounth, year)
                .setSubjects(subjects)
                .checkHobbies(hobbies)
                .uploadFile(patchName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .VerifayResultsModalAppears()
                .VerifayResults("Student Name", firstName + " " + lastName)
                .VerifayResults("Student Email", userMail)
                .VerifayResults("Mobile", userNumber)
                .VerifayResults("Date of Birth", day + " " + mounth + "," + year);
    }

}
