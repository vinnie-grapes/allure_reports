package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SelenideTests extends BaseTest{

    private PageObjects page = new PageObjects();

    @Test
    public void selenideTestIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        page.openMainPage();
        page.searchRepository();
        page.openTheRepository();
        page.openIssueTab();
        page.searchIssueByNumber(1588);
        page.makeScreenshot();
    }
}
