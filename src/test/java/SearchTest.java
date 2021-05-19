import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    /**
     *
     * @BeforeAll
     *
     *     @BeforeEach
     *               @Test
     *     @AfterEach
     *
     *     @BeforeEach
     *               @Test
     *     @AfterEach
     *
     * @AfterAll
     */

    static Logger log = LoggerFactory.getLogger(SearchTest.class);

    @BeforeAll
    static void setUpConfig() {
        log.info("@BeforeAll");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openGooglePage() {
        log.info("@BeforeEach");
        open("https://www.google.com/");
    }

    @AfterEach
    void closeBrowser() {
        log.info("@AfterEach");
        closeWebDriver();
    }

    @Test
    void selenideSearchTest() {
        $(byName("q")).setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
}
