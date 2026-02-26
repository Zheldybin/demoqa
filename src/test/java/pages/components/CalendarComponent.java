package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement yearSelect = $(".react-datepicker__year-select"),
            mountSelect = $(".react-datepicker__month-select");

    private static final String DAY_SELECTOR_BASE = ".react-datepicker__day--0";

    public void setDate(String day, String month, String year) {
        yearSelect.shouldBe(visible).selectOption(year);
        mountSelect.shouldBe(visible).selectOption(month);
        $(DAY_SELECTOR_BASE + day).click();
    }
}
