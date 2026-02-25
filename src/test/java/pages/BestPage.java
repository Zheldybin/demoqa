package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BestPage {
    protected RegistrationPage registrationPage = new RegistrationPage();

    public RegistrationPage registrationPage() {
        return registrationPage;
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1000";
    }
}
