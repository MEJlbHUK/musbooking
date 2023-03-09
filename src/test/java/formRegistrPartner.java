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
        $(byName("your-name")).setValue("Арсений");
        $(byName("your-www")).setValue("vk.com/id1");
        $(byName("your-phone")).setValue("+71239993311");
        $(byName("name-company")).setValue("Вавилон");
        $(byName("your-email")).setValue("test@test.tu");
        $(byName("menu-472")).click();
        $(byValue("Премиум")).click();
        $(byValue("Фотостудии")).click();
        $(byName("text-446")).setValue("Москва");
        $(byName("text-445")).setValue("arGQi73Vf$");
        $(byValue("Отправить")).click();
        if (("При отправке сообщения произошла ошибка. Пожалуйста, попробуйте ещё раз позже.") != ("Ваша заявка на регистрацию объекта отправлена.")) {
            sleep(3000);
            $(byValue("Отправить")).click();
        }
        sleep(500);

        $(".main-page").shouldHave(text("Заявка на регистрацию объекта отправлена"));
    }
}
