package hw3.store.item;

import java.util.Comparator;
import java.util.Map.Entry;

public class CostComparator implements Comparator<Entry<Item, Integer>> {
    private final SortingOrder sortOrder;

    public CostComparator(SortingOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public CostComparator() {
        this(SortingOrder.ASK);
    }

    @Override
    public int compare(Entry<Item, Integer> o1, Entry<Item, Integer> o2) {
        if (o1 == o2) {
            return 0;
        }
        double costDelta = o1.getKey().getCost() - o2.getKey().getCost();

        int result = 0;
        if (costDelta < 0) {
            result = -1;
        } else if (costDelta > 0) {
            result = 1;
        }

        return sortOrder == SortingOrder.ASK ? result : -result;
    }

}
