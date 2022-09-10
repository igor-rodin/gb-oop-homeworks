package hw3.checkup.student;

import hw3.checkup.desease.Desease;
import hw3.checkup.desease.DeseaseDegree;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private DeseaseDegree deseaseDegree;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.deseaseDegree = new DeseaseDegree(Desease.NONE, 0);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public DeseaseDegree getDeseaseDegree() {
        return deseaseDegree;
    }

    public void setDeseaseDegree(DeseaseDegree deseaseDegree) {
        this.deseaseDegree = deseaseDegree;
    }

    @Override
    public int compareTo(Student o) {
        if (o == this) {
            return 0;
        }
        return name.compareTo(o.getName());
    }
}
