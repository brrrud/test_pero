package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class ProductPageTest {
    static ProductPage productPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
        productPage = new ProductPage();
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    @DisplayName("Проверка названия продукта")
    public void checkProductName() {
        $(productPage.getProductNameSelector()).shouldHave(text("For testing test"));
    }

    @Test
    @DisplayName("Проверка, что у товара установлена стоимость = бесплатно")
    public void checkProductPrice() {
        $(productPage.getProductPriceSelector()).shouldHave(text("бесплатно"));
    }

    @Test
    @DisplayName("Проверка, что у товара нет изображения")
    public void checkProductImage() {
        $(productPage.getProductImageSelector()).shouldNot(exist);
    }

    @Test
    @DisplayName("Проверка владельца товара как текст")
    public void checkProductOwnerText() {
        $(productPage.getProductOwnerSelector()).shouldHave(text("Test public for test"));
    }

    @Test
    @DisplayName("Проверка владельца товара как сравнение ожидаемой ссылки и ссылки из карточки товара")
    public void checkProductOwner() {
        String actualOwnerLink = $(productPage.getProductOwnerRefByCardSelector()).attr("href");
        Assertions.assertEquals(productPage.getProductOwnerExpectedRef(), actualOwnerLink, "Ссылка на профиль владельца не соответствует ожидаемой.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.ItemCardLayout__content > div.ItemCardControls-module__root--JtnOe > div > button > span",
            "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__bottom > div > ul > li.ItemActions__item.ItemActions__iconLike > button",
            "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__bottom > div > ul > li.ItemActions__item.ItemActions__iconShare > button"

    })
    @DisplayName("Проверка что при нажатии на кнопку откроется окно авторизации")
    public void checkButtonClick(String buttonSelector) {
        $(buttonSelector).click();
        $(productPage.getSignFrameVKSelector()).should(exist);
    }

}
