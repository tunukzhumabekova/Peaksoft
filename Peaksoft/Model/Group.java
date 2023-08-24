package Peaksoft.Model;

import java.util.Arrays;

public class Group {
    private  int id;
    private String name;
    private Student[] students;
    private int count;
    private static  int idd = 1;


    public Group( String name, Student[] students, int count) {
        this.id = idd++;
        this.name = name;
        this.students = students;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", count=" + count +
                '}';
    }
}