package hw2.store;

import java.util.HashMap;
import java.util.Map;

public class Main {
    final static Map<Item, Integer> storage = new HashMap<>();

    public static void main(String[] args) {
        fillStorage();

        Seller seller = new Seller("Продавец", 0);
        seller.addItemsFrom(storage);

        System.out.println("Storage:");
        printItems(storage);

        Consumer consumer = new Consumer("Покупатель", 100);

        consumer.addToWishList(new Item("Item_1", 12.5, Category.FOOD), 1);
        consumer.addToWishList(new Item("Item_4", 2.5, Category.WATER), 2);
        consumer.addToWishList(new Item("Item_9", 20.5, Category.HYGIENE), 1);
        System.out.println("Wish List:");
        printItems(consumer.getWishList());

        double totalCostStorage = seller.totalCost(seller.getItems());
        System.out.println(totalCostStorage);
        System.out.printf("Стоимость товаров на складе: %f\n", totalCostStorage);
        double totalCostWishes = consumer.totalCost(consumer.getWishList());
        System.out.printf("Стоимость товаров в списке хотелок покупателя: %f\n", totalCostWishes);

        System.out.printf("Сумма денег у продавца: %f\n", seller.getMoney());
        System.out.printf("Сумма денег у покупателя: %f\n", consumer.getMoney());

        seller.sellItems(consumer.getWishList(), consumer);
        printItems(seller.getItems());
        System.out.printf("Сумма денег у продавца: %f\n", seller.getMoney());
        printItems(consumer.getWishList());
        System.out.printf("Сумма денег у покупателя: %f\n", consumer.getMoney());

        Item newItem = new Item("Item_34", 12., Category.FOOD);
        consumer.addToWishList(newItem, 2);
        seller.sellItem(newItem, 2, consumer);
    }

    private static void fillStorage() {
        Item item_1 = new Item("Item_1", 12.5, Category.FOOD);
        Item item_2 = new Item("Item_2", 5, Category.FOOD);
        Item item_3 = new Item("Item_3", 15, Category.FOOD);
        Item item_4 = new Item("Item_4", 2.5, Category.WATER);
        Item item_5 = new Item("Item_5", 15, Category.WATER);
        Item item_6 = new Item("Item_6", 12, Category.WATER);
        Item item_7 = new Item("Item_7", 42.5, Category.HYGIENE);
        Item item_8 = new Item("Item_8", 16, Category.HYGIENE);
        Item item_9 = new Item("Item_9", 20.5, Category.HYGIENE);

        storage.put(item_1, 5);
        storage.put(item_2, 2);
        storage.put(item_3, 4);

        storage.put(item_4, 3);
        storage.put(item_5, 1);
        storage.put(item_6, 2);

        storage.put(item_7, 3);
        storage.put(item_8, 2);
        storage.put(item_9, 1);
    }

    private static void printItems(Map<Item, Integer> items) {
        for (var item : items.entrySet()) {
            System.out.printf("%s - %d\n", item.getKey().getNameOfItem(), item.getValue());
        }
    }
}
