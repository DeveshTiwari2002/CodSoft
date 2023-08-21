import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for the number of subjects and maximum marks per subject
        final int NUM_SUBJECTS = 5;
        final int MAX_MARKS_PER_SUBJECT = 100;

        // Input marks for each subject
        int[] marks = new int[NUM_SUBJECTS];
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            // Validate input marks
            if (marks[i] < 0 || marks[i] > MAX_MARKS_PER_SUBJECT) {
                System.out.println("Invalid marks entered. Marks should be between 0 and " + MAX_MARKS_PER_SUBJECT);
                System.exit(0);
            }
        }

        // Calculate total marks and average
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        double average = (double) totalMarks / NUM_SUBJECTS;

        // Calculate the grade based on the average
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

        // Display the results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
