package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PageObjects {

    static final String BASE_URL = "https://github.com";
    static final String REPOSITORY = "vkui";

    public SelenideElement searchInput = $(".header-search-input"),
            tabIssues = $(withText("Issues"));

    public void openMainPage() {
        open(BASE_URL);
    }

    public void searchRepository() {
        searchInput.click();
        searchInput.setValue(REPOSITORY).submit();
    }

    public void openTheRepository() {
        $(By.linkText(REPOSITORY)).click();
    }

    public void openIssueTab() {
        tabIssues.click();
    }

    public void searchIssueByNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    public void makeScreenshot() {
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", stream);
    }
}
