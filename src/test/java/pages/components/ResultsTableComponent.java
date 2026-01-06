package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    private SelenideElement resultModalTitle = $("#example-modal-sizes-title-lg"),
            tableResponsiveInput = $(".table-responsive"),
            closeLargeModalInput = $("#closeLargeModal");



    public ResultsTableComponent checkResult(String key, String value) {
        tableResponsiveInput
                .$(byText(key)).
                parent() //перевод вверх по иерархии на tr
                .shouldHave(text(value));
        return this;
    }
    public void closeLargeModal() {
        closeLargeModalInput
                .click();
    }
    public ResultsTableComponent checkResultModalNotVisible() {
        resultModalTitle.shouldNot(appear);
        return this;
    }
}
