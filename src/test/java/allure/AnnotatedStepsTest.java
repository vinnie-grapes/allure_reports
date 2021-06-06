package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends BaseTest {

    private WebSteps steps = new WebSteps();

    @Test
    @Feature("Issues")
    @Owner("vinogradov")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверяем что Issue {number} существует")
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository("VKCOM/VKUI");
        steps.goToRepository("VKCOM/VKUI");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(1588);
        steps.makeScreenshot();
    }
}

