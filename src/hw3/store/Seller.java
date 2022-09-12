package hw3.store;

import java.util.Map;
import java.util.Random;

import hw3.store.item.Item;

public class Seller extends Human implements SellCommunication {

    public Seller(String name, double money) {
        super(name, money, new Random().nextInt(MAX_LOVE_INDEX + 1));
    }

    @Override
    public void walkInStorage() {
        System.out.println("Надо поискать, есть ли это на складе(...");
    }

    @Override
    public void sellItems(Map<Item, Integer> items, Consumer consumer) {
        double totalCost = totalCost(items);
        if (totalCost > consumer.getMoney()) {
            System.out.println("У вас недостатчно средств для покупки выбранных товаров");
            return;
        }

        if (!isItemsInStorage(this, consumer.getItems())) {
            System.out.println("У нас нет нужных вам товаров");
            walkInStorage();
            return;
        }

        for (var item : items.entrySet()) {
            if (this.items.containsKey(item.getKey())) {
                this.items.put(item.getKey(), this.items.get(item.getKey()) - item.getValue());
            }
        }
        setMoney(getMoney() + totalCost);

        consumer.setMoney(consumer.getMoney() - totalCost);
        consumer.clearWishList();
    }

    @Override
    public void addItemsFrom(Map<Item, Integer> storage) {
        items.putAll(storage);
    }

}
