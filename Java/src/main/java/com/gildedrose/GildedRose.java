package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            String itemName = item.name;

            ItemStrategy strategy;

            strategy = new GeneralItemStrategy();

            if (itemNameCheckStartWith(itemName, "Aged Brie")) {
                strategy = new AgedBrieStrategy();
            }

            if (itemNameCheckStartWith(itemName, "Backstage passes ")) {
                strategy = new BackStagePassStrategy();
            }

            if (itemNameCheckStartWith(itemName, "Conjured ")) {
                strategy = new ConjuredStrategy();
            }

            if (itemNameCheckStartWith(itemName, "Sulfuras")) {
                strategy = new SulfurasStrategy();
            }

            strategy.updateQuality(item);


        }//end for loop
    }//end updateQuality

    private boolean itemNameCheckStartWith(String itemName, String productName) {
        return itemName.startsWith(productName);
    }


}
