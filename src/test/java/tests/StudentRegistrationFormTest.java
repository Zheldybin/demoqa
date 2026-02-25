package tests;

import org.junit.jupiter.api.Test;
import pages.BestPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormTest extends BestPage {
    @Test
    void RegistrationForm() {

        String firstName = "Jovan";
        String lastName = "Savovich";
        String userMail = "kgb@jovan.ru";
        String userNumber = "4999886645";
        String currentAddress = "Leprosorium";

        registrationPage().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userMail)
                .setGender()
                .setNumber(userNumber)
                .setBirthDate("05","April", "1993");


        $("#subjectsInput").setValue("History");
        $(".subjects-auto-complete__menu").click();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-3").click();
        File file = new File("src/test/resources/cat.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").scrollIntoView(true);
        $("#react-select-3-input").click();
        $("#react-select-3-option-0").shouldBe(visible).click();
        $("#react-select-4-input").click();
        $("#react-select-4-option-0").shouldBe(visible).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userMail), text(userNumber),
                text("05 April,1993"), text("History"), text("cat.jpg"), text(currentAddress), text("NCR Delhi"));
    }
}
