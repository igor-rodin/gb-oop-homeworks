package hw2.store;

import java.util.Map;
import java.util.Random;

public class Consumer extends Human {

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
}
