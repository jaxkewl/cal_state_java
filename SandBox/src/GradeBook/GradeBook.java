package GradeBook;

import java.util.Scanner;

public class GradeBook {
	private int numOfGrades = 0;
	private int totalScore = 0;
	private double avgScore = 0.0;

	public void determineAvgGrade() {

		Scanner scan = new Scanner(System.in);
		int userInput = 1;

		while (-1 != userInput) {
			System.out.println("Enter grade (-1 exits)");

			userInput = scan.nextInt();
			if ((-1 != userInput) && (0 != userInput)) {
				numOfGrades++;
				totalScore = totalScore + userInput;
			}
		}

		// now calculate the avg, also protect against div 0
		if (0 == numOfGrades)
			System.out.printf("No Grades inputted!\n");

		// the double casting only needs to appear once in this statement
		avgScore = (double) totalScore / numOfGrades;

	}

	public double getAvgScore() {
		return avgScore;
	}
}
