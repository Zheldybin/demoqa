import org.junit.jupiter.api.Test;

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
        //заполнить поле current address
        //выбрать штаит
        //выбрать город
        //нажать кнопку отправить
        // сделать проверку
        sleep(5000);
    }
}
