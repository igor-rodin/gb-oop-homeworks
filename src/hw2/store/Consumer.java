package hw2.store;

import java.util.ArrayList;

public class Consumer extends Human {
    ArrayList<Item> wishList = new ArrayList<>();

    public Consumer(String name, double money, int loveIndex) {
        super(name, money, loveIndex);
    }
}
