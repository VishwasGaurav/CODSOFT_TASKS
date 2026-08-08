import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Which language is used for Android development?",
            "2. Which keyword is used to create a class in Java?",
            "3. Which method is the starting point of a Java program?",
            "4. Which symbol is used to end a statement in Java?",
            "5. Which data type is used to store whole numbers?"
        };

        String[][] options = {
            {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
            {"A. function", "B. class", "C. define", "D. create"},
            {"A. start()", "B. run()", "C. main()", "D. begin()"},
            {"A. :", "B. .", "C. ;", "D. ,"},
            {"A. String", "B. boolean", "C. double", "D. int"}
        };

        char[] answers = {'A', 'B', 'C', 'C', 'D'};

        int score = 0;

        System.out.println("================================");
        System.out.println("        QUIZ APPLICATION");
        System.out.println("================================");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));

            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
                System.out.println("Correct answer: " + answers[i]);
            }
        }

        System.out.println("\n================================");
        System.out.println("             RESULT");
        System.out.println("================================");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 80) {
            System.out.println("Performance: Excellent!");
        } else if (percentage >= 60) {
            System.out.println("Performance: Good!");
        } else if (percentage >= 40) {
            System.out.println("Performance: Average!");
        } else {
            System.out.println("Performance: Needs Improvement!");
        }

        System.out.println("================================");

        sc.close();
    }
}