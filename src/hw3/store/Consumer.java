package hw3.store;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import hw3.store.item.Item;

public class Consumer extends Human implements ConsumerCommunication {

    public Consumer(String name, double money) {
        super(name, money, new Random().nextInt(MAX_LOVE_INDEX + 1));
    }

    public Map<Item, Integer> getWishList() {
        return items;
    }

    public void clearWishList() {
        items.clear();
    }

    public void addToWishList(Item item, Integer counts) {
        items.put(item, counts);
    }

    @Override
    public void walkInStorage() {
        System.out.println("Пойду погляжу, что у них тут есть на складе...");
    }

    @Override
    public void validateWishList(Map<Item, Integer> storage) {
        Iterator<Entry<Item, Integer>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!storage.containsKey(iterator.next().getKey())) {
                iterator.remove();
            }
        }
    }
}
