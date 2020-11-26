import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @Test
    void assertThatFiveDepositArchivePresentOnPage() {
        open("http://alfabank.ru");
        $("body").shouldHave(text("Частным лицам"));
        $(byText("Вклады")).shouldBe(visible).click();
        $("#filter").shouldHave(text("Накопительные продукты"));
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).shouldBe(visible).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("#filter").$$("[data-widget-name=CatalogCard]").shouldHaveSize(5);
    }

    @Test
    void insuranceTabVerificationUsingSibling() {
        open("http://alfabank.ru");
        $$(byText("Вклады")).find(visible).click();
        $("[data-test-id='tabs-list-tabTitle-0']").sibling(0).click();
        $("[data-test-id='accordion-header-2']").shouldHave(text("Страхованию подлежат"));
    }

    @Test
    void insuranceTabVerificationUsingCloset() {
        open("http://alfabank.ru");
        $$(byText("Вклады")).find(visible).click();
        $("[data-test-id='tabs-list-tabTitle-1'] span").closest("button").click();
        $("[data-test-id='accordion-header-2']").shouldHave(text("Страхованию подлежат"));
    }

    @Test
    void insuranceTabVerificationUsingPreceding() {
        open("http://alfabank.ru");
        $$(byText("Вклады")).find(visible).click();
        $("[data-test-id='tabs-list-tabTitle-2']").preceding(0).click();
        $("[data-test-id='accordion-header-2']").shouldHave(text("Страхованию подлежат"));
    }

    @Test
    void insuranceTabVerificationUsingParent() {
        open("http://alfabank.ru");
        $$(byText("Вклады")).find(visible).click();
        $$(byText("Страхование вкладов")).find(visible).parent().click();
        $("[data-test-id='accordion-header-2']").shouldHave(text("Страхованию подлежат"));
    }
}

