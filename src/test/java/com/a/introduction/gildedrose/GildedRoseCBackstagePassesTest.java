package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {
    private final static String ITEM_TYPE = "Backstage passes to a TAFKAL80ETC concert";
    private final static int QUALITY = 3;
    private final static int SELLIN_MORE_THAN_10 = 15;

    private final static int SELLIN_MORE_THAN_5 = 7;
    private final static int SELLIN_MORE_THAN_0 = 4;

    private final static int SELLIN_LESS_OR_EQUAL_TO_0 = 0;

    //IN EVERY TEST METHOD UPDATEQUALITY DECREASES SELLIN BY 1
    @Test
    public void should_Increase_Quality_By_1_When_Sellin_Is_More_Or_Equal_To_10() {
        //given
        Item item = new Item(ITEM_TYPE, SELLIN_MORE_THAN_10, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, SELLIN_MORE_THAN_10 - 1, QUALITY + 1);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

    @Test
    public void should_Increase_Quality_By_2_When_Sellin_Is_More_Or_Equal_To_5() {
        //given
        Item item = new Item(ITEM_TYPE, SELLIN_MORE_THAN_5, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, SELLIN_MORE_THAN_5 - 1, QUALITY + 2);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

    @Test
    public void should_Increase_Quality_By_3_When_Sellin_Is_Less_Than_5_And_More_Than_0() {
        //given
        Item item = new Item(ITEM_TYPE, SELLIN_MORE_THAN_0, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, SELLIN_MORE_THAN_0 - 1, QUALITY + 3);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

    @Test
    public void Quality_Should_Be_Equal_To_Zero_When_Sellin_Is_Zero_Or_Less() {
        //given
        Item item = new Item(ITEM_TYPE, SELLIN_LESS_OR_EQUAL_TO_0, QUALITY);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        Item actualItem = app.items[0];
        Item expectedItem = new Item(ITEM_TYPE, SELLIN_LESS_OR_EQUAL_TO_0 - 1, 0);
        //then
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

}