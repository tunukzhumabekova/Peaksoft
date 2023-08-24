package Peaksoft.Servise;

import Peaksoft.Interface.StudentIntarface;
import Peaksoft.Model.Mentor;
import Peaksoft.Model.Peaksoft;
import Peaksoft.Model.Student;

import java.util.Arrays;

public class StudentServes implements StudentIntarface {

    private Peaksoft peaksoft;
private Mentor[] mentors;

    String smile = "\u2713";

    public StudentServes(Peaksoft peaksoft) {
        this.peaksoft = peaksoft;
    }

    @Override
    public Student[] getAllStudents() {
        return peaksoft.getStudents();
    }

    @Override
    public Student searchStudentByName(String name) {
        for (Student s : peaksoft.getStudents()) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        System.out.println("Данного студентка нету в базе");
        return null;
    }

    @Override
    public Student[] sortByStudentName(String ascDecs) {
        return new Student[0];
    }

    @Override
    public void deleteStudentById(int id) {
        Student[] students = peaksoft.getStudents();
        Student[] updatedStudents = new Student[students.length - 1];
        int index = 0;

        for (Student student : students) {
            if (student.getId() != id) {
                updatedStudents[index] = student;
                index++;
            }
        }

        peaksoft.setStudents(updatedStudents);

        System.out.println("[" + smile + "] Студент с ID " + id + " удален [" + smile + "]");
        System.out.println("Новый массив после удаления: " + Arrays.toString(updatedStudents));
    }


    @Override
    public Student[] createStuden(Student student) {
        boolean x = true;
        Student[] students = peaksoft.getStudents();
        for (Student student1:students) {
            if(student1.getName().equals(student.getName())){
                x = false;
                System.out.println("Данный студент уже есть в бaзе данных");
            }
            break;
        }
        if(x){
            Student[] students1;
            students1 = Arrays.copyOf(students, students.length + 1);
            students1[students1.length - 1] = student;
            peaksoft.setStudents(students1);

            System.out.println(Arrays.toString(students1));
        }
        return  students;
    }

    @Override
    public void updateById(int id, Student student) {
        Student[] students = peaksoft.getStudents();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId()==id ) {
                students[i].setId(id);
                students[i].setName(student.getName());
                students[i].setEmail(student.getEmail());
                students[i].setGender(student.getGender());
                System.out.println(students[i]);
            }
        }

    }


    @Override
    public void findById(int id) {
        Student[] students = peaksoft.getStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);            }
        }

    }
}


