package hw3.store.item;

import hw3.store.Category;

public class Item implements Comparable<Item> {
    private String itemName;
    private double cost;
    private Category category;

    public Item(String nameOfItem, double cost, Category category) {
        this.itemName = nameOfItem;
        this.cost = cost;
        this.category = category;
    }

    public String getNameOfItem() {
        return itemName;
    }

    public void setNameOfItem(String nameOfItem) {
        this.itemName = nameOfItem;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Item)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Item item = (Item) obj;
        return itemName.equals(item.getNameOfItem()) && category == item.getCategory();
    }

    @Override
    public int hashCode() {
        return itemName.hashCode() + 31 * category.hashCode();
    }

    @Override
    public int compareTo(Item o) {
        if (this == o) {
            return 0;
        }
        return itemName.compareTo(o.getNameOfItem());
    }
}
