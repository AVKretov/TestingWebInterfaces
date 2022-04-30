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
    void wrongName() {
        open("http://localhost:9999");
        $("[name=\"name\"]").setValue("asadasd");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".checkbox__box").click();
        $(".button__text").click();
        $(".input_invalid").shouldHave(text("Имя и Фамилия указаные неверно." +
                " Допустимы только русские буквы, пробелы и дефисы."));
    }
    @Test
    void wrongPhone() {
        open("http://localhost:9999");
        $("[name=\"name\"]").setValue("Вася Пупкин");
        $("[name=\"phone\"]").setValue("89270000000");
        $(".checkbox__box").click();
        $(".button__text").click();
        $(".input_invalid").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, " +
                "например, +79012345678."));
    }

    @Test
    void withoutCheck() {
        open("http://localhost:9999");
        $("[name=\"name\"]").setValue("Вася Пупкин");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".button__text").click();
        $(".input_invalid").shouldHave(text("Я соглашаюсь с условиями обработки и использования" +
                " моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

}