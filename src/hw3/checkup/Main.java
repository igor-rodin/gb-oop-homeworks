package hw3.checkup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hw3.checkup.desease.Desease;
import hw3.checkup.desease.DeseaseDegree;
import hw3.checkup.student.Student;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Map<String, Integer> pillows = new HashMap<>();

        Student student1 = new Student("Иванов", 8);
        student1.setDeseaseDegree(new DeseaseDegree(Desease.FLUE, 2));
        Student student2 = new Student("Петров", 10);
        Student student3 = new Student("Сидоров", 12);
        student3.setDeseaseDegree(new DeseaseDegree(Desease.TOOTHACHE, 6));
        Student student4 = new Student("Чапаев", 20);
        Student student5 = new Student("Баранов", 15);
        student5.setDeseaseDegree(new DeseaseDegree(Desease.COVID, 5));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Nurse nurse = new Nurse(students, pillows);
        nurse.countOffByAge(students);
        nurse.countOffByName(students);
        // Убираем из очереди здоровых учеников
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            if (iter.next().getDeseaseDegree().desease() == Desease.NONE) {
                iter.remove();
            }
        }

        // students.removeIf(student -> student.getDeseaseDegree().desease() ==
        // Desease.NONE);

        nurse.goToCheckup(nurse.getStudents());

        pillows.put("Уголь", 100000);
        pillows.put("Аспирин", 10);
        pillows.put("Зеленка", 100);

    }

}
