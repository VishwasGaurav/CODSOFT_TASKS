import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {

    static Scanner sc = new Scanner(System.in);

    // Course class
    static class Course {
        String code;
        String title;
        String description;
        int capacity;
        String schedule;
        int registeredStudents;

        Course(String code, String title, String description,
               int capacity, String schedule) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
            this.registeredStudents = 0;
        }

        int availableSlots() {
            return capacity - registeredStudents;
        }
    }

    // Student class
    static class Student {
        String studentId;
        String name;
        ArrayList<String> registeredCourses;

        Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }
    }

    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        addCourses();

        System.out.println("==========================================");
        System.out.println("     STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("==========================================");

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        Student student = new Student(studentId, studentName);
        students.add(student);

        int choice;

        do {
            System.out.println("\n==========================================");
            System.out.println("                 MENU");
            System.out.println("==========================================");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View My Registered Courses");
            System.out.println("5. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    registerCourse(student);
                    break;

                case 3:
                    dropCourse(student);
                    break;

                case 4:
                    displayStudentCourses(student);
                    break;

                case 5:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    // Add courses to the course database
    static void addCourses() {

        courses.add(new Course(
                "CS101",
                "Java Programming",
                "Introduction to Java programming",
                3,
                "Monday - 10:00 AM"
        ));

        courses.add(new Course(
                "CS102",
                "Database Management",
                "Basics of database management systems",
                2,
                "Tuesday - 11:00 AM"
        ));

        courses.add(new Course(
                "CS103",
                "Web Development",
                "HTML, CSS and JavaScript fundamentals",
                3,
                "Wednesday - 2:00 PM"
        ));

        courses.add(new Course(
                "CS104",
                "Data Structures",
                "Introduction to data structures and algorithms",
                2,
                "Thursday - 12:00 PM"
        ));
    }

    // Display all courses
    static void displayCourses() {

        System.out.println("\n================ AVAILABLE COURSES ================");

        for (Course course : courses) {

            System.out.println("\nCourse Code   : " + course.code);
            System.out.println("Course Title  : " + course.title);
            System.out.println("Description   : " + course.description);
            System.out.println("Capacity      : " + course.capacity);
            System.out.println("Schedule      : " + course.schedule);
            System.out.println("Available Slot: " + course.availableSlots());
            System.out.println("---------------------------------------------------");
        }
    }

    // Register student for a course
    static void registerCourse(Student student) {

        displayCourses();

        System.out.print("\nEnter course code to register: ");
        String code = sc.nextLine();

        Course selectedCourse = findCourse(code);

        if (selectedCourse == null) {
            System.out.println("Course not found!");
            return;
        }

        if (selectedCourse.availableSlots() <= 0) {
            System.out.println("Sorry! This course is full.");
            return;
        }

        if (student.registeredCourses.contains(code.toUpperCase())) {
            System.out.println("You are already registered for this course.");
            return;
        }

        student.registeredCourses.add(code.toUpperCase());
        selectedCourse.registeredStudents++;

        System.out.println("Successfully registered for "
                + selectedCourse.title + "!");
    }

    // Drop a registered course
    static void dropCourse(Student student) {

        if (student.registeredCourses.isEmpty()) {
            System.out.println("You have not registered for any course.");
            return;
        }

        displayStudentCourses(student);

        System.out.print("\nEnter course code to drop: ");
        String code = sc.nextLine().toUpperCase();

        if (!student.registeredCourses.contains(code)) {
            System.out.println("You are not registered for this course.");
            return;
        }

        Course selectedCourse = findCourse(code);

        student.registeredCourses.remove(code);
        selectedCourse.registeredStudents--;

        System.out.println("Course dropped successfully!");
    }

    // Display student's registered courses
    static void displayStudentCourses(Student student) {

        System.out.println("\n============== MY REGISTERED COURSES ==============");

        System.out.println("Student ID   : " + student.studentId);
        System.out.println("Student Name : " + student.name);

        if (student.registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (String code : student.registeredCourses) {

            Course course = findCourse(code);

            if (course != null) {
                System.out.println("\nCourse Code  : " + course.code);
                System.out.println("Course Title : " + course.title);
                System.out.println("Schedule     : " + course.schedule);
            }
        }
    }

    // Find course by course code
    static Course findCourse(String code) {

        for (Course course : courses) {

            if (course.code.equalsIgnoreCase(code)) {
                return course;
            }
        }

        return null;
    }
}