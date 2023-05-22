package com.gildedrose;

public class StrategyFactory {
    boolean itemNameCheckStartWith(String itemName, String productName) {
        return itemName.startsWith(productName);
    }


    public ItemStrategy returnStrategy(Item item) {
    String itemName = item.name;
    ItemStrategy strategy;
    strategy = new GeneralItemStrategy();

        if (

            itemNameCheckStartWith(itemName, "Aged Brie")) {
            strategy = new AgedBrieStrategy();
        }

        if (

            itemNameCheckStartWith(itemName, "Backstage passes ")) {
            strategy = new BackStagePassStrategy();
        }

        if (

            itemNameCheckStartWith(itemName, "Conjured ")) {
            strategy = new ConjuredStrategy();
        }

        if (

            itemNameCheckStartWith(itemName, "Sulfuras")) {
            strategy = new SulfurasStrategy();
        }
        return strategy;
    }

}
