package com.a.introduction.gildedrose;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {

        Item[] items = new Item[]{
                new Item("Default Item", 10, 20)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        System.out.println(app);

    }

    public void updateQuality() {
        for (Item item : items) {
            if (!Objects.equals(item.name, "Aged Brie") && !Objects.equals(item.name, "Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!Objects.equals(item.name, "Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                // This part handles the items for which quality can increase
                // "Backstage passes to a TAFKAL80ETC concert" and "Aged Brie"

                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            // Everything except for Sulfuras the sellIn Decreases
            if (!Objects.equals(item.name, "Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!Objects.equals(item.name, "Aged Brie")) {

                    if (!Objects.equals(item.name, "Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!Objects.equals(item.name, "Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // For Backstage passes with sellin less than zero
                        // quality is set to zero
                        item.quality = 0;
                    }
                } else {
                    // For Aged Brie below 50 quality increases actually by 2
                    // In the previous line
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}