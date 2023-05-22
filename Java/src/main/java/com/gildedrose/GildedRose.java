package com.gildedrose;

//Extract "Factory Method" (those if statements with the new)
//Return a List<ItemStrategy> from the array of items
//Then use a forEach(ItemStrategy::updateQuality) at the call site to 'tell dont ask' each object to update itself
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        StrategyFactory strategyFactory = new StrategyFactory();
        for (Item item : items) {

            ItemStrategy strategy = strategyFactory.returnStrategy(item);

            strategy.updateQuality(item);

        }//end for loop
    }//end updateQuality


}
