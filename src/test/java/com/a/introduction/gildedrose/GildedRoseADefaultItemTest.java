package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {
    final private static String itemType = "DEFAULT_ITEM";
    final private static int quality = 3;
    /**
     * Method to test the variation in quality of the item for the non expired
     * Item.
     * <p>
     * The quality should decrease by 1 when the item is not expired
     * and sell in should decrease by 1.
     */
//    @Test
//    public void testUpdateQuality() {
//
//        Item item = new Item("DEFAULT_ITEM", 15, 3);
//        GildedRose app = new GildedRose(new Item[]{item});
//        app.updateQuality();
//        assertEquals("DEFAULT_ITEM", app.items[0].name);
//        assertEquals(14, app.items[0].sellIn);
//        assertEquals(2, app.items[0].quality);
//    }

    // this is fixed test testUpdateQuality()
    @Test
    public void should_Decrease_Quality_AndSellin_Of_Unexpired_Item_By1() {
        //given
        int sellIn = 15;
        Item item = new Item(itemType, sellIn, quality);
        GildedRose actual = new GildedRose(new Item[]{item});
        //when
        actual.updateQuality();
        //then
        Item actualItem = actual.items[0];
        Item expectedItem = new Item(itemType, sellIn - 1, quality - 1);

        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality)
        );
    }

    /**
     * Method to test the variation in quality of the item for the non expired
     * Item.
     * <p>
     * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
     */
    @Test
    public void should_Decrease_Quality_By_2_AndSellin_By_1_WhenItem_SellIn_Is_LessThan_0() {
        //given
        int expiredSellIn = -1;
        Item item = new Item(itemType, expiredSellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});
        //when
        app.updateQuality();
        //then
        Item actualItem = app.items[0];
        Item expectedItem = new Item(itemType, expiredSellIn - 1, quality - 2);
        assertAll(
                () -> assertEquals(expectedItem.name, actualItem.name),
                () -> assertEquals(expectedItem.sellIn, actualItem.sellIn),
                () -> assertEquals(expectedItem.quality, actualItem.quality));
    }
}