package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            String itemName = item.name;

            if (itemIsSulfuras(item)||
                itemIsConjured(item)||
                itemIsAgedBrieOrBackstagePass(item, itemName))
                return;

            isGeneralItem(item);
        }//end for loop
    }//end updateQuality

    private boolean itemIsAgedBrieOrBackstagePass(Item item, String itemName) {
        if (itemNameCheckStartWith(itemName, "Aged Brie")
            || itemNameCheckStartWith(itemName, "Backstage passes ")) {

            if (isQualityLessThanFifty(item)) {
                isItemBackstagePass(item, itemName);
                isItemAgedBrie(item, itemName);
                sellByDateDecrease(item);
                return true;
            }
            sellByDateDecrease(item);
            item.quality = 50;
            return true;
        }
        return false;
    }

    private boolean itemIsConjured(Item item) {
        if (itemNameCheckStartWith(item.name, "Conjured ")) {
            ItemStrategy conjured = new ConjuredStrategy();
            conjured.updateQuality(item);
            return true;
        }
        return false;
    }

    private boolean itemIsSulfuras(Item item) {
        if (itemNameCheckStartWith(item.name, "Sulfuras")) {
           ItemStrategy sulfuras = new SulfurasStrategy();
           sulfuras.updateQuality(item);
            return true;
        }
        return false;
    }

    private void isGeneralItem(Item item) {
        ItemStrategy generalItem = new GeneralItemStrategy();
        generalItem.updateQuality(item);
    }


    public void sellByDateDecrease(Item item) {
        item.sellIn--;
    }

    private void isItemBackstagePass(Item item, String itemName) {
        if (itemNameCheckStartWith(itemName, "Backstage passes ")) {
            ItemStrategy backStagePassItem = new BackStagePassStrategy();
            backStagePassItem.updateQuality(item);
        }
    }

    private void isItemAgedBrie(Item item, String itemName) {
        if (itemNameCheckStartWith(itemName, "Aged Brie")) {
            ItemStrategy brieItem = new AgedBrieStrategy();
            brieItem.updateQuality(item);
        }
    }

        private boolean itemNameCheckStartWith (String itemName, String productName){
            return itemName.startsWith(productName);
        }

        private boolean isQualityLessThanFifty (Item item){
            return item.quality < 50;
        }



}
