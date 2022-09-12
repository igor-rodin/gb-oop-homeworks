package hw3.store.item;

import java.util.Comparator;
import java.util.Map.Entry;

public class CountsItemComparator implements Comparator<Entry<Item, Integer>> {
    private final SortingOrder sortOrder;

    public CountsItemComparator(SortingOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public CountsItemComparator() {
        this(SortingOrder.ASK);
    }

    @Override
    public int compare(Entry<Item, Integer> o1, Entry<Item, Integer> o2) {
        if (o1 == o2) {
            return 0;
        }

        int result = o1.getValue() - o2.getValue();
        return sortOrder == SortingOrder.ASK ? result : -result;
    }

}
