package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public List<Student> searchByName(String name) {
        List<Student> results = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(student);
            }
        }

        return results;
    }

    public void sortByGradeDescending() {
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        System.out.println("Students sorted by grade.");
    }

    public boolean removeStudentById(int id) {
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    public int getStudentCount() {
        return students.size();
    }
}
