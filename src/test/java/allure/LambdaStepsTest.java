package allure;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends BaseTest {

    private static final int ISSUE_NUMBER = 1588;
    private PageObjects page = new PageObjects();

    @Test
    public void testIssueSearch() {
        step("Открываем главную страницу", (s) -> {
            s.parameter("url", page.BASE_URL);
            page.openMainPage();
        });
        step("Ищем репозиторий " + page.REPOSITORY, (s) -> {
            s.parameter("repository", page.REPOSITORY);
            page.searchRepository();
        });
        step("Переходим в репозиторий " + page.REPOSITORY, (s) -> {
            s.parameter("repository", page.REPOSITORY);
            page.openTheRepository();
        });
        step("Открываем Issues", () -> {
            page.openIssueTab();
        });
        step("Проверяем что Issue " + ISSUE_NUMBER + " существует", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            page.searchIssueByNumber(ISSUE_NUMBER);
        });
        step("Make screenshot", () -> {
            page.makeScreenshot();
        });
    }
}
