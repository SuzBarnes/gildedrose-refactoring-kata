package com.gildedrose;

public class GeneralItemStrategy implements ItemStrategy {
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.sellIn--;
            if (item.sellIn < 0) {
                item.quality -= 2;
            } else {
                item.quality--;
            }
        }
    }
}
