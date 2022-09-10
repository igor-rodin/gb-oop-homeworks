package hw3.store;

import java.util.Map;

public interface SellCommunication {
    default void sellItem(Item item, int counts, Consumer consumer) {
        sellItems(Map.of(item, counts), consumer);
    };

    void sellItems(Map<Item, Integer> items, Consumer consumer);

    default void addItem(Item item, int counts) {
        addItemsFrom(Map.of(item, counts));
    };

    void addItemsFrom(Map<Item, Integer> storage);
}
