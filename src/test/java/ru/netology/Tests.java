package ru.netology;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class Tests {

    @Test
    void happyPath() {
        open("http://localhost:9999");
        $("[name=\"name\"]").setValue("Петров Василий");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".checkbox__box").click();
        $(".button__text").click();
        $(".paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void happyPath() {
        open("http://localhost:9999");
        $("[name=\"name\"]").setValue("Петров Василий");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".checkbox__box").click();
        $(".button__text").click();
        $(".paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }
}