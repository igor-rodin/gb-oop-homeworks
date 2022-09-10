package hw3.checkup.student;

import java.util.Comparator;

public class CompareByDeseaseDegree implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) {
            return 0;
        }
        return o2.getDeseaseDegree().degree() - o1.getDeseaseDegree().degree();
    }

}
