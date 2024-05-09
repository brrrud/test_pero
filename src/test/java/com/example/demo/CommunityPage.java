package com.example.demo;

import lombok.Getter;

@Getter
public class CommunityPage {
    private final String communityNameSelector = "#group > div.page_block.redesigned-cover-block > div.redesigned-group-info > div.redesigned-group-info__main > div > h1";
    private final String communitySubscribersCountSelector = "#page_subscribers > div";

    private final String communityListItemsSelector = "#group_tabs_content > div > div:nth-child(1) > section > ul";

    private final String communityItemExpectedSelector = "#group_tabs_content > div > div:nth-child(1) > section > ul > li > div > a > div.EcommPreviewProductCardProductPicture.MarketItemPreview__image > a > img";

    private final String communityItemExpectedRef = "https://vk.com/club225299895?w=product-225299895_10044406%2Fquery";

}
