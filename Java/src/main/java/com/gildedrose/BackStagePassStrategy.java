package com.gildedrose;

public class BackStagePassStrategy implements ItemStrategy {

    public void updateQuality(Item item) {

        if (item.sellIn <= 0) {
            item.quality = 0;
            return;
        }

        if (isQualityLessThanFifty(item)) {
            if (isSellByDateLessThan(item, 6)) {
                increaseQualityValue(item, 3);
                return;
            }

            if (isSellByDateLessThan(item, 11)) {
                increaseQualityValue(item, 2);
                return;
            }
            if (item.sellIn > 10) {
                increaseQualityValue(item, 1);
            }
        } else{
            item.sellIn --;
            item.quality=50;
        }
    }

    private boolean isSellByDateLessThan(Item item, int days) {
        return item.sellIn < days;
    }

    private boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    private void increaseQualityValue(Item item, int rate) {
        item.quality += rate;
        if(item.quality >50){
            item.quality =50;
        }
    }
}
