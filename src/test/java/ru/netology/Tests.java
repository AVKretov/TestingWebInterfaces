package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class Tests {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }


    @Test
    void happyPath() {
        $("[name=\"name\"]").setValue("Петров Василий");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".checkbox__box").click();
        $(By.tagName("Button")).click();
        $("[data-test-id=\"order-success\"]").shouldHave(exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void wrongName() {
        $("[name=\"name\"]").setValue("asadasd");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(".checkbox__box").click();
        $(By.tagName("Button")).click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(text("Имя и Фамилия указаные неверно." +
                " Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void wrongPhoneAndFixing() {
        $("[name=\"name\"]").setValue("Вася Пупкин");
        $("[name=\"phone\"]").setValue("89270000000");
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id=\"phone\"].input_invalid .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, " +
                "например, +79012345678."));
        $("[name=\"phone\"]").doubleClick().sendKeys("+79270000000");
        $(By.tagName("Button")).click();
        $("[data-test-id=\"order-success\"].paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void withoutCheck() {
        $("[name=\"name\"]").setValue("Вася Пупкин");
        $("[name=\"phone\"]").setValue("+79270000000");
        $(By.tagName("Button")).click();
        $("[data-test-id=\"agreement\"].input_invalid .checkbox__text").shouldHave(text("Я соглашаюсь с условиями обработки и использования" +
                " моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    void emptyName() {
        $("[name=\"phone\"]").setValue("+79270000000");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(By.tagName("Button")).click();
        $("[data-test-id='name'].input_invalid .input__sub").
                shouldHave(text("Поле обязательно для заполнения"));
    }
    @Test
    void emptyPhone() {
        $("[name=\"name\"]").setValue("Вася Пупкин");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(By.tagName("Button")).click();
        $("[data-test-id='phone'].input_invalid .input__sub").
                shouldHave(text("Поле обязательно для заполнения"));
    }

//    @Test
//    void emptyFields() {
//        $(By.tagName("Button")).click();
//        $("[data-test-id='name'].input_invalid .input__sub").
//                shouldHave(text("Поле обязательно для заполнения"));
//        $("[name=\"name\"]").doubleClick()
//                .sendKeys("Аркадий Укупник");
//        $(By.tagName("Button")).click();
//        $("[data-test-id=\"phone\"].input_invalid .input__sub").
//                shouldHave(text("Поле обязательно для заполнения"));
//        $("[name=\"phone\"]").doubleClick()
//                .sendKeys("+79991112233");
//        $("[data-test-id=\"agreement\"] .checkbox__box").click();
//        $(By.tagName("Button")).click();
//        $("[data-test-id=\"order-success\"].paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! " +
//                "Наш менеджер свяжется с вами в ближайшее время."));
//    }

}