package ru.job4j.profession;

public class Teacher extends Profession {
    public Student teach(Student student) {
        return new Student();
    }
}
