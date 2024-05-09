package com.example.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.annotation.Testable;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CommunityPageTest {
    CommunityPage communityPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
        communityPage = new CommunityPage();
    }

    @Test
    @DisplayName("Проверка что название сообщества соответствует ожидаемому")
    public void checkCommunityName() {
        $(communityPage.getCommunityNameSelector()).shouldHave(text("Test public for test"));
    }

    @Test
    @DisplayName("Проверка что количество подписчиков = 1")
    public void checkSubscribersCount() {
        $(communityPage.getCommunitySubscribersCountSelector()).shouldHave(text("1 подписчик"));
    }

    @Test
    @DisplayName("Проверка наличия карточек товаров в сообществе")
    public void checkProductCardsExistence() {
        Assertions.assertFalse($$(communityPage.getCommunityListItemsSelector()).isEmpty(), "Карточки товаров отсутствуют в сообществе.");
    }

    @Test
    @DisplayName("Проверка что количество товаров = 1")
    public void checkProductCardCount() {
        Assertions.assertEquals(1, $$(communityPage.getCommunityListItemsSelector()).size(), "Количество товаров не соответствует");
    }



}
