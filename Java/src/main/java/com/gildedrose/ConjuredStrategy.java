package com.gildedrose;

public class ConjuredStrategy implements ItemStrategy {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality -= 2;
        }
        item.quality -= 2;
        sellByDateDecrease(item);
            }

    public void sellByDateDecrease(Item item) {
        item.sellIn--;
    }
}

