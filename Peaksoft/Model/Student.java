package Peaksoft.Model;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String email;
    private static  int idd = 1;

    public Student(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.id = idd++;
    }

    public Student() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "gender: " + gender + "\n" +
                "email: " + email + "\n" +
                '}';
    }
}