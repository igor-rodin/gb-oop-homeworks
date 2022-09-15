package taskmanager.model.task;

import java.util.Comparator;

public class ByDeadlineComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1 == o2) {
            return 0;
        }
        return o1.daysForDeadline() - o2.daysForDeadline();
    }

}
