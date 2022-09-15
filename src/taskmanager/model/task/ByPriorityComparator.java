package taskmanager.model.task;

import java.util.Comparator;

public class ByPriorityComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1 == o2) {
            return 0;
        }
        return o2.getPriorityLevel().ordinal() - o1.getPriorityLevel().ordinal();
    }

}
