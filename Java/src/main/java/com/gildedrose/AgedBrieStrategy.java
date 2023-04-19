package com.gildedrose;

public class AgedBrieStrategy implements ItemStrategy {

    public void updateQuality(Item item) {
        if (item.quality < 50) {
            if (item.sellIn <= 0) {
                increaseQualityValue(item, 2);
                return;
            }
            increaseQualityValue(item, 1);
        } else {
            item.sellIn--;
        }
    }

    private void increaseQualityValue(Item item, int rate) {
        item.quality += rate;
        if(item.quality >50){
            item.quality =50;
        }
    }
}
