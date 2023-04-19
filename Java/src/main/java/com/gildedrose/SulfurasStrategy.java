package com.gildedrose;

public class SulfurasStrategy implements ItemStrategy {
//    public void sellByDateDecrease(Item item) {
//        item.sellIn--;
//    }
    public void updateQuality(Item item){
        item.quality = 80;
        item.sellIn--;
//        sellByDateDecrease(item);
    }

}
