package hw3.checkup;

import java.util.List;
import java.util.Map;

import hw3.checkup.student.CompareByAge;
import hw3.checkup.student.CompareByDeseaseDegree;
import hw3.checkup.student.Student;

public class Nurse implements Speaker {
    private List<Student> students;
    private Map<String, Integer> pillows;

    public Nurse(List<Student> students, Map<String, Integer> pillows) {
        this.students = students;
        this.pillows = pillows;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<String, Integer> getPillows() {
        return pillows;
    }

    @Override
    public void goToCheckup(List<Student> students) {
        System.out.println("------Медосмотр----------");
        // Сортируем по степени болезни, чобы осмотреть сначала самых больных
        students.sort(new CompareByDeseaseDegree());
        for (Student student : students) {
            System.out.printf("%s беги на медосмотр, у тебя %s (%d)\n", student.getName(),
                    student.getDeseaseDegree().desease(), student.getDeseaseDegree().degree());
        }

    }

    @Override
    public void countOffByAge(List<Student> students) {
        System.out.println("------По возрасту----------");
        students.sort(new CompareByAge());
        for (Student student : students) {
            System.out.printf("Студент: %s  (возраст - %d)\n", student.getName(), student.getAge());
        }
    }

    @Override
    public void countOffByName(List<Student> students) {
        System.out.println("------По алфавиту--------");
        students.sort(null);
        for (Student student : students) {
            System.out.printf("Студент: %s\n", student.getName());
        }
    }
}
