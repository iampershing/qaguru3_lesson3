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
}

