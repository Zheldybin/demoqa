package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private static final String URL = "/automation-practice-form";
    private static final String HOBBIES_CHECKBOX_SELECTOR = "#hobbies-checkbox-";
    private static final String STATE_SELECT_OPTIONS_SELECTOR = "#react-select-3-option-";
    private static final String CITY_SELECT_OPTIONS_SELECTOR = "#react-select-4-option-";


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#gender-radio-1"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            addingSubjectMenu = $(".subjects-auto-complete__menu"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#react-select-3-input"),  // для выбора штата
            citySelect = $("#react-select-4-input"),
            submitBtnForm = $("#submit");

    public RegistrationPage openPage() {
        open(URL);
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
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        genderRadioButton.click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value);
        addingSubjectMenu.click();
        return this;
    }

    public RegistrationPage checkHobbies(String value) {
        $(HOBBIES_CHECKBOX_SELECTOR + value).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        File file = new File(value);
        uploadPictureInput.uploadFile(file);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.click();
        $(STATE_SELECT_OPTIONS_SELECTOR + value).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.click();
        $(CITY_SELECT_OPTIONS_SELECTOR + value).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitBtnForm.click();
        return this;
    }
}
