package StudentManagementSystem;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private double grade;

    public Student(int id, String name, int age, String course, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }
}
