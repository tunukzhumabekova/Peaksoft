package Peaksoft;

import Peaksoft.Model.Group;
import Peaksoft.Model.Mentor;
import Peaksoft.Model.Peaksoft;
import Peaksoft.Model.Student;
import Peaksoft.Servise.GroupServes;
import Peaksoft.Servise.MentorServes;
import Peaksoft.Servise.StudentServes;

import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class main {
    public static void main(String[] args) {

        Student student1 = new Student("Alex", "MALE", "email1");
        Student student2 = new Student("John", "MALE", "email2");
        Student student3 = new Student("Emily", "FEMALE", "email3");
        Student student4 = new Student("Olivia", "FEMALE", "email4");
        Student student5 = new Student("Daniel", "MALE", "email5");
        Student student6 = new Student("Sophia", "FEMALE", "email6");
        Student student7 = new Student("Michael", "MALE", "email7");
        Student student8 = new Student("Emma", "FEMALE", "email8");
        Student student9 = new Student("William", "MALE", "email9");
        Student student10 = new Student("Ava", "FEMALE", "email10");
        Student student11 = new Student("James", "MALE", "email11");
        Student student12 = new Student("Mia", "FEMALE", "email12");
        Student student13 = new Student("Benjamin", "MALE", "email13");
        Student student14 = new Student("Isabella", "FEMALE", "email14");
        Student student15 = new Student("Ethan", "MALE", "email15");

        Student[] students1 = {student1, student2, student3, student4, student5};
        Student[] students2 = {student6, student7, student8, student9, student10};
        Student[] students3 = {student11, student12, student13, student14, student15};
        Student[] students = {student1, student2, student3, student4, student5, student6, student7, student8,
                student9, student10, student11, student14, student15};

        Group group1 = new Group("Group1", students1, 5);
        Group group2 = new Group("Group2", students2, 5);
        Group group3 = new Group("Group3", students3, 5);

        Group[] groups1 = {group1};
        Group[] groups2 = {group2};
        Group[] groups3 = {group3};
        Group[] groups = {group1, group2, group3};

        Mentor mentor1 = new Mentor("Mentor1", "MALE", "email42", groups1);
        Mentor mentor2 = new Mentor("Mentor2", "FEMALE", "email51", groups2);
        Mentor mentor3 = new Mentor("Mentor3", "MALE", "email43", groups3);
        Mentor[] mentors = {mentor1, mentor2, mentor3};

        Peaksoft peaksoft = new Peaksoft("Peaksoft", "Ja12", mentors, students, groups);


        Scanner scan = new Scanner(System.in);
        StudentServes studentIntarface = new StudentServes(peaksoft);
        GroupServes groupInterface = new GroupServes(peaksoft);
        MentorServes mentorInterface = new MentorServes(peaksoft);


        System.out.println("1. Методы связанные с студентами ");
        System.out.println("2. Методы связанные с группами ");
        System.out.println("3. Методы связанные с менторами ");

        int x = scan.nextInt();
        switch (x) {
            // МЕТОДЫ СВЯЗАННЫЕ С СТУДЕНТАМИ
            case 1:
                while (true) {
                    System.out.println("1. Вывод всех студентов");
                    System.out.println("2. Получить данные о студенте");
                    System.out.println("3. Сортировка студентов по их именам");
                    System.out.println("4. Удаления студента по его айди");
                    System.out.println("5. Добавить студента в базу данных");
                    System.out.println("6  Найти студента по айди");
                    System.out.println("7. Обновить айди студента");
                    System.out.println("Выберите нужное вам действие");
                    long x1 = scan.nextLong();
                    switch ((int) x1) {
                        case 1:
                            System.out.println("ДЕЙСТВИЕ (1)");
                            System.out.println(Arrays.toString(studentIntarface.getAllStudents()));
                            break;
                        case 2:
                            System.out.println("ДЕЙСТВИЕ (2)");
                            System.out.print("Введите имя студента чтобы вывести о нем информацию: ");
                            String name = scan.next();
                            System.out.println(studentIntarface.searchStudentByName(name));
                            break;
                        case 3:
                            System.out.println("ДЕЙСТВИЕ (3)");
                            System.out.print("1. По возрастанию asc\n" +
                                    "2. Во убыванию D\nНапишите на выбор: ");
                            String acs = scan.next();
                            studentIntarface.sortByStudentName(acs);
                            break;
                        case 4:
                            System.out.println("ДЕЙСТВИЕ (4)");
                            System.out.print("Напишите айди студентка чтобы удалить его из базы: ");
                            int idDelete = scan.nextInt();
                            studentIntarface.deleteStudentById(idDelete);
                            break;
                        case 5:
                            System.out.println("ДЕЙСТВИЕ (5)");
                            studentIntarface.createStuden(student1);
                            break;
                        case 6:
                            System.out.println("ДЕЙСТВИЕ (6)");
                            System.out.println("Напишите айди для поиска:");
                            int idToSearch = scan.nextInt();
                            studentIntarface.findById(idToSearch);
                            break;
                        case 7:
                            System.out.println("ДЕЙСТВИЕ (7)");
                            System.out.println("напишите айди для обновления");
                            int idToUpdate = scan.nextInt();
                            studentIntarface.updateById(idToUpdate, student1);
                            break;
                    }
                }
                // МЕТОДЫ СВЯЗАННЫЕ С ГРУППАМИ
            case 2:
                while (true) {
                    System.out.println("1. Вывод всех групп");
                    System.out.println("2. Получить группу по наз");
                    System.out.println("3. Удалить группу по айди");
                    System.out.println("4. Создать группу");
                    System.out.println("5. Обновить группу по айди");
                    System.out.println("6  Найти группу по айди");
                    int a = scan.nextInt();
                    switch (a) {
                        case 1:
                            System.out.println(Arrays.toString(groupInterface.getAllGroup()));
                            break;
                        case 2:
                            System.out.println("Введите название группы ");
                            String NameOfGroup = scan.nextLine();
                            System.out.println(groupInterface.getGroupByName(NameOfGroup));
                            break;
                        case 3:
                            System.out.println("Введите айди для удаление");
                            int idToDelete = scan.nextInt();
                            groupInterface.deleteGroup(idToDelete);
                            break;
                        case 4:
                            System.out.println(Arrays.toString(groupInterface.createGroup(group1)));
                            break;
                        case 5:
                            System.out.println("Введите айди для обновления");
                            int idToUpdate = scan.nextInt();
                            groupInterface.updateById(idToUpdate, group1);
                            break;
                        case 6:
                            groupInterface.findById(1);
                            break;
                    }
                }

                // МЕТОДЫ СВЯЗАННЫЕ МЕНТОРАМИ
            case 3:
                while (true) {
                    System.out.println("1. Вывод всех менторов");
                    System.out.println("2. Получить ментора по почте");
                    System.out.println("3. Удалить ментора по айди");
                    System.out.println("4. Создать ментора");
                    System.out.println("5. Обновить ментора по айди");
                    System.out.println("6  Найти ментора по айди");
                    int b = scan.nextInt();
                    switch (b) {
                        case 1:
                            System.out.println(Arrays.toString(mentorInterface.getAllMentor()));
                            break;
                        case 2:
                            mentorInterface.getMentoryByemail("email42");
                            break;
                        case 3:
                            System.out.println("Введите айди для удаление");
                            int idToDelete1 = scan.nextInt();
                            mentorInterface.deleteMentorById(idToDelete1);
                            break;
                        case 4:
                            System.out.println(Arrays.toString(mentorInterface.createMentor(mentor1)));
                            break;
                        case 5:
                            System.out.println("Введите айди для обновления");
                            int idToUpdate1 = scan.nextInt();
                            mentorInterface.updateById(idToUpdate1,mentor1);
                            break;
                        case 6:
                            System.out.println("Введите айди для поиска ментора");
                            int idToFind1 = scan.nextInt();
                            mentorInterface.findById(idToFind1);
                            break;

                    }
                }

        }
    }
}
