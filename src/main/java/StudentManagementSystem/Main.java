package StudentManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("=================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("=================================");

        while (running) {
            displayMenu();

            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    studentManager.displayAllStudents();
                    break;

                case 3:
                    searchStudentById();
                    break;

                case 4:
                    searchStudentByName();
                    break;

                case 5:
                    studentManager.sortByGradeDescending();
                    studentManager.displayAllStudents();
                    break;

                case 6:
                    removeStudent();
                    break;

                case 7:
                    System.out.println(
                            "Total students: " + studentManager.getStudentCount()
                    );
                    break;

                case 8:
                    running = false;
                    System.out.println("Thank you for using the Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-8.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n========== MENU ==========");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Search Student by Name");
        System.out.println("5. Sort Students by Grade");
        System.out.println("6. Delete Student");
        System.out.println("7. Show Student Count");
        System.out.println("8. Exit");
        System.out.println("==========================");
    }

    private static void addStudent() {

        System.out.println("\n------ Add Student ------");

        int id = readInteger("Enter student ID: ");

        if (studentManager.findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter student name: ");
            name = scanner.nextLine().trim();
        }

        int age = readInteger("Enter age: ");

        while (age < 5 || age > 100) {
            System.out.println("Please enter a valid age.");
            age = readInteger("Enter age: ");
        }

        System.out.print("Enter course: ");
        String course = scanner.nextLine().trim();

        while (course.isEmpty()) {
            System.out.print("Course cannot be empty. Enter course: ");
            course = scanner.nextLine().trim();
        }

        double grade = readDouble("Enter grade (0-100): ");

        while (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            grade = readDouble("Enter grade (0-100): ");
        }

        Student student = new Student(
                id,
                name,
                age,
                course,
                grade
        );

        studentManager.addStudent(student);
    }

    private static void searchStudentById() {

        System.out.println("\n------ Search by ID ------");

        int id = readInteger("Enter student ID: ");

        Student student = studentManager.findStudentById(id);

        if (student != null) {
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudentByName() {

        System.out.println("\n------ Search by Name ------");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        List<Student> results = studentManager.searchByName(name);

        if (results.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nSearch results:");

        for (Student student : results) {
            student.displayStudent();
        }
    }

    private static void removeStudent() {

        System.out.println("\n------ Delete Student ------");

        int id = readInteger("Enter student ID: ");

        boolean removed = studentManager.removeStudentById(id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int readInteger(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
