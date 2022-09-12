package hw3.store;

import java.util.Map;
import hw3.store.item.Item;

public interface ConsumerCommunication {
    void validateWishList(Map<Item, Integer> storage);
}
