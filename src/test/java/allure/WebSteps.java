package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Открываем Issues")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue {number} существует")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
