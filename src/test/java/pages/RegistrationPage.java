package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    String url = "/automation-practice-form";
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            EmailInput = $("#userEmail"),
            GenderRadioButton = $("#gender-radio-1"),
            NumberInput = $("#userNumber");

    public RegistrationPage openPage() {
        open(url);
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        GenderRadioButton.click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        NumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDeta(day, month, year);
        return this;
    }

}
