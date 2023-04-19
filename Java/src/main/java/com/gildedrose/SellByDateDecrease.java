package com.gildedrose;

public class SellByDateDecrease {
    public static void main (String[] args, Item item){
      sellByDateDecrease(item);
    }
    public static void sellByDateDecrease(Item item) {
        item.sellIn--;
    }
}
