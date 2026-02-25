import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    @Test
    void RegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        //заполнить поле first name
        $("#firstName").setValue("Ivan");
        //заполнить поле last name
        $("#lastName").setValue("Ivanov");
        //заполнить поле email
        $("#userEmail").setValue("ivanIvanov@mail.ru");
        //выбрать чекбокс GENDER
        $("#gender-radio-1").click();
        //заполнить номер телефона
        $("#userNumber").setValue("9501725010");
        //выбрать дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").shouldBe(visible).selectOption("1993");
        $(".react-datepicker__month-select").shouldBe(visible).selectOption("April");
        $(".react-datepicker__day--005").click();
        //заполнить поле subjects
        $("#subjectsInput").setValue("History");
        $(".subjects-auto-complete__menu").click();
        //выбрать чекбокс hobbies
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-3").click();
        //загрузить фото
        File file = new File("src/test/resources/cat.jpg");
        $("#uploadPicture").uploadFile(file);
        //заполнить поле current address
        $("#currentAddress").setValue("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //выбрать штаит
        $("#react-select-3-input").scrollIntoView(true);
        $("#react-select-3-input").click();
        $("#react-select-3-option-0").shouldBe(visible).click();
        //выбрать город
        $("#react-select-4-input").click();
        $("#react-select-4-option-0").shouldBe(visible).click();
        //нажать кнопку отправить
        $("#submit").click();
        // сделать проверку
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        sleep(5000);
    }
}
