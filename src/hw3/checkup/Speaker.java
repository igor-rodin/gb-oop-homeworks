package hw3.checkup;

import java.util.List;

import hw3.checkup.student.Student;

public interface Speaker {

    void goToCheckup(List<Student> students);

    void countOffByAge(List<Student> students);

    void countOffByName(List<Student> students);
}
