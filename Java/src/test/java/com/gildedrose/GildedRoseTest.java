package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sulfurasQualityAlwaysEqualsEighty() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void qualityOfItemIsNeverNegative() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOfItemNeverMoreThanFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityDecreasesTwiceAsFastAfterSellByDate() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 2, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality(); // 2 - 7 , 1 - 6
        app.updateQuality(); // 1 - 6 , 0 - 5
        app.updateQuality(); // 0 - 5, -1 - 4
        app.updateQuality(); // -1 - 4, -2 - 2
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality(); // 2 - 40 , 1 - 41
        app.updateQuality(); // 1 - 41 , 0 - 42
        app.updateQuality(); // 0 - 42 , -1 - 43
        app.updateQuality(); // -1 - 43 , -2 - 45
        assertEquals(45, app.items[0].quality);
    }

    @Test
    public void agedBrieCannotBeMoreThanFiftyQualityValue(){
        Item[] items = new Item[]{new Item("Aged Brie", 4, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstagePassQualityDecreasesToZeroAfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesByOneWhenMoreThanTenDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesByTwoWhenTenToSixDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(24, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreasesByThreeWhenFiveOrLessDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(26, app.items[0].quality);
    }
    @Test
    public void backstagePassesCannotBeMoreThanFiftyQualityValue(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
//        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void conjuredDegradeQualityRateTwice() {
        Item[] items = new Item[]{new Item("Conjured Gantt Chart", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void conjuredDegradeQualityRateTwiceDoublesBelowZero() {
        Item[] items = new Item[]{new Item("Conjured Gantt Chart", 1, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
