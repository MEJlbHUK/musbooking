import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class formRegistrPartner {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://musbooking.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {
        open("/partners-main");
        $(".mbpl_9_head").shouldHave(text("Форма регистрации партнера"));
        $(byName("your-name")).setValue("Арсений"); // Вводим имя
        $(byName("your-www")).setValue("vk.com/id1"); // Сайт
        $(byName("your-phone")).setValue("+71239993311"); // Номер телефона
        $(byName("name-company")).setValue("Вавилон"); // Название фирмы
        $(byName("your-email")).setValue("test@test.tu"); // e-mail
        $(byName("menu-472")).click(); // Раскрываем список тарифов
        $(byValue("Премиум")).click(); // Выбираем тариф
        $(byValue("Фотостудии")).click(); // Выбераем площадку
        $(byName("text-446")).setValue("Москва"); // Город
        $(byName("text-445")).setValue("arGQi73Vf$"); // Промокод
        $(byValue("Отправить")).submit(); // Нажимаем кнопку "Отправить"
        if (("При отправке сообщения произошла ошибка. Пожалуйста, попробуйте ещё раз позже.") != ("Ваша заявка на регистрацию объекта отправлена.")) {
            sleep(3000);
            $(byValue("Отправить")).click(); //  Проверяем нет ли ошибки и если есть, спустя время еще раз жмем кнопку
        }
        sleep(500);

        $(".main-page").shouldHave(text("Заявка на регистрацию объекта отправлена")); // Проверяем успешное оформление заявки.
    }
}
