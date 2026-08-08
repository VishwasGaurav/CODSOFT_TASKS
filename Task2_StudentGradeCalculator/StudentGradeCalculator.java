import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   STUDENT GRADE CALCULATOR");
        System.out.println("================================");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--;
                continue;
            }

            total += marks;
        }

        double average = total / subjects;

        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
        System.out.println("================================");

        sc.close();
    }
}