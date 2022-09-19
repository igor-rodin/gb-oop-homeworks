package taskmanager.model.task;

import java.util.Comparator;

public class ByCreateDateComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1.getCreateDateTime().isBefore(o2.getCreateDateTime())) {
            return -1;
        } else if (o1.getCreateDateTime().isAfter(o2.getCreateDateTime())) {
            return 1;
        }
        return 0;
    }

}
