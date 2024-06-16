import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Weights for each component
        double assignmentsWeight = 0.4; // 40%
        double quizzesWeight = 0.1;     // 10%
        double midtermWeight = 0.2;     // 20%
        double finalExamWeight = 0.3;   // 30%
        
        // Input for each component
        System.out.print("Enter the average assignment grade (0-100): ");
        double assignmentsGrade = scanner.nextDouble();
        
        System.out.print("Enter the average quiz grade (0-100): ");
        double quizzesGrade = scanner.nextDouble();
        
        System.out.print("Enter the midterm exam grade (0-100): ");
        double midtermGrade = scanner.nextDouble();
        
        System.out.print("Enter the final exam grade (0-100): ");
        double finalExamGrade = scanner.nextDouble();
        
        // Calculate the final grade
        double finalGrade = (assignmentsGrade * assignmentsWeight) + 
                            (quizzesGrade * quizzesWeight) + 
                            (midtermGrade * midtermWeight) + 
                            (finalExamGrade * finalExamWeight);
        
        // Output the final grade
        System.out.printf("The final grade is: %.2f\n", finalGrade);
        
        // Determine the letter grade
        char letterGrade;
        if (finalGrade >= 90) {
            letterGrade = 'A';
        } else if (finalGrade >= 80) {
            letterGrade = 'B';
        } else if (finalGrade >= 70) {
            letterGrade = 'C';
        } else if (finalGrade >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        
        // Output the letter grade
        System.out.println("The letter grade is: " + letterGrade);
        
        scanner.close();
    }
}
