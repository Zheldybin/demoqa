package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    private SelenideElement exampleModalTitle = $("#example-modal-sizes-title-lg");

    public void verifayModalAppers(){
        exampleModalTitle.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifayResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }

}