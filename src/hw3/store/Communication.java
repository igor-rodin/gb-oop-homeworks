package hw3.store;

import java.util.Map;

import hw3.store.item.Item;

public interface Communication {
    default double costOfItem(Item item) {
        return item.getCost();
    }

    default boolean isItemsInStorage(Seller seller, Map<Item, Integer> wishListOfConsumer) {
        for (var item : wishListOfConsumer.entrySet()) {
            if (!seller.getItems().containsKey(item.getKey())) {
                System.out.println("У нас нет " + item.getKey().getNameOfItem());
                return false;
            } else if (seller.getItems().get(item.getKey()) < item.getValue()) {
                System.out.printf("У нас нет %s в количестве %d\n", item.getKey().getNameOfItem(), item.getValue());
                return false;
            }
        }
        return true;
    }

    // Дописать метод
    default double totalCost(Map<Item, Integer> items) {
        if (items == null) {
            return 0.;
        }
        double sum = 0;
        for (var item : items.entrySet()) {
            sum += costOfItem(item.getKey()) * item.getValue();
        }
        return sum;
    }

    default void areYouPoor(Consumer consumer) {
        if (totalCost(consumer.getWishList()) > consumer.getMoney()) {
            System.out.println("Ты нищеброд");
        } else {
            walkInStorage();
        }
    }

    // У Покупателя и Продавца реализовать свои вариации метода "пойти на склад"
    void walkInStorage();
}
