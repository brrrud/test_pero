package com.example.demo;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
@Getter
@NoArgsConstructor
public class ProductPage {
    private final String productNameSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.ItemCardLayout__content > h1";

    private final String productPriceSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.ItemCardLayout__content > div.ItemPrice-module__container--pcRRe.MarketItemCard__price > div > span";

    private final String productImageSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__left > div > div.ItemGallery__main";

    private final String productOwnerSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.vkuiSimpleCell.vkuiSimpleCell--sizeY-compact.vkuiSimpleCell--mult.ItemAuthor-module__root--qMKsy.vkuiTappable.vkuiInternalTappable.vkui-focus-visible > div.vkuiSimpleCell__middle > div:nth-child(1) > span > a";

    private final String productOwnerExpectedRef = "https://vk.com/club225299895";

    private final String productOwnerRefByCardSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.vkuiSimpleCell.vkuiSimpleCell--sizeY-compact.vkuiSimpleCell--mult.ItemAuthor-module__root--qMKsy.vkuiTappable.vkuiInternalTappable.vkui-focus-visible > div.vkuiSimpleCell__middle > div:nth-child(1) > span > a";

    public static final String productWriteButtonSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__top > div.ItemCardLayout__right > div.ItemCardLayout__content > div.ItemCardControls-module__root--JtnOe > div > button > span";




    public static final String productLikeButtonSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__bottom > div > ul > li.ItemActions__item.ItemActions__iconLike > button";

    public static final  String productShareButtonSelector = "#popup-sticker-market-react-container > div > div > div.ItemCardLayout__bottom > div > ul > li.ItemActions__item.ItemActions__iconShare > button";

    private final String signFrameVKSelector = "#content > div.page_block.VkIdSignIn";


    private final String inviteToVk = "https://vk.com/club225299895?marketItemCardDelayedAction=toggleGroupSubscribe&w=product-225299895_10044406%2Fquery";


}
