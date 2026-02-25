package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDeta(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").shouldBe(visible).selectOption(year);
        $(".react-datepicker__month-select").shouldBe(visible).selectOption(month);
        $(".react-datepicker__day--0" + day).click();
    }
}
