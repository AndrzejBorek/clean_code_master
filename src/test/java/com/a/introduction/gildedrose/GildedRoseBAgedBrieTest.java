package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {
    private final static String ITEM_TYPE = "Aged Brie";
    private final static int QUALITY = 3;
    private final static int NON_EXPIRED_SELLIN = 4;
    private final static int EXPIRED_SELLIN = -1;
    private final static int MAX_QUALITY = 50;
    //IN EVERY TEST METHOD UPDATEQUALITY DECREASES SELLIN BY 1
    @Test
    public void should_Increase_Quality_by_1_Of_Unexpired_Item() {
        //given
        Item item = new Item(ITEM_TYPE, NON_EXPIRED_SELLIN, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, NON_EXPIRED_SELLIN - 1, QUALITY + 1);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality));
    }

    @Test
    public void should_Increase_Quality_By_2_Of_Expired_Item() {
        //given
        Item item = new Item(ITEM_TYPE, EXPIRED_SELLIN, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, EXPIRED_SELLIN - 1, QUALITY + 2);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

    @Test
    public void should_Not_Increase_Quality_Of_Expired_Item_When_Quality_Is_Max() {
        //given
        Item item = new Item(ITEM_TYPE, EXPIRED_SELLIN, MAX_QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, EXPIRED_SELLIN-1, MAX_QUALITY);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }
}
