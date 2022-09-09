package hw2.store;

public class Item {
    private String nameOfItem;
    private double cost;
    private Category category;

    public Item(String nameOfItem, double cost, Category category) {
        this.nameOfItem = nameOfItem;
        this.cost = cost;
        this.category = category;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
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
        return nameOfItem.equals(item.getNameOfItem()) && category == item.getCategory();
    }

    @Override
    public int hashCode() {
        return nameOfItem.hashCode() + 32 * category.hashCode();
    }
}
