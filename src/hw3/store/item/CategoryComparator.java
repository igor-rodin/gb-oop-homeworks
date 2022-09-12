package hw3.store.item;

import java.util.Comparator;
import java.util.Map.Entry;

public class CategoryComparator implements Comparator<Entry<Item, Integer>> {
    private final SortingOrder sortOrder;

    public CategoryComparator(SortingOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public CategoryComparator() {
        this(SortingOrder.ASK);
    }

    @Override
    public int compare(Entry<Item, Integer> o1, Entry<Item, Integer> o2) {
        if (o1 == o2) {
            return 0;
        }
        int result = o1.getKey().getCategory().toString().compareTo(o2.getKey().getCategory().toString());

        return sortOrder == SortingOrder.ASK ? result : -result;
    }

}
