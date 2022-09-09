package hw2.store;

import java.util.HashMap;
import java.util.Map;

public abstract class Human implements Communication {
    protected final static int MAX_LOVE_INDEX = 5;

    private String name;
    private double money;
    private int loveIndex;
    protected Map<Item, Integer> items = new HashMap<>();

    protected Human(String name, double money, int loveIndex) {
        this.name = name;
        this.money = money;
        this.loveIndex = loveIndex;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public int getLoveIndex() {
        return loveIndex;
    }

    public void setLoveIndex(int loveIndex) {
        this.loveIndex = loveIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
