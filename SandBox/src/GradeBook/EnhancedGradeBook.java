package GradeBook;

import java.util.Scanner;

public class EnhancedGradeBook {
	private int aCount;
	private int bCount;
	private int cCount;
	private int dCount;
	private int eCount;

	private int gradeCount;
	private int totalGrades;

	public EnhancedGradeBook() {
		
		System.out.println("Welcome to the Enhanced Grade Book.");
	}
	
	public void inputGrades() {

		int userInput = 0;

		while (-1 != userInput) {
			System.out.println("Enter grade (-1 exits)");

			Scanner inputScanner = new Scanner(System.in);

			userInput = inputScanner.nextInt();

			// only count grades that are valid
			if (-1 != userInput) {

				// keep track of the letter grades.
				switch (userInput / 10) {

				case 10:
					aCount++;
					break;
				case 9:
					aCount++;
					break;
				case 8:
					bCount++;
					break;
				case 7:
					cCount++;
					break;
				case 6:
					dCount++;
					break;
				//default:
			//		eCount++;
		//			break;
				}

				// keep track of the avgs
				gradeCount++;
				totalGrades += userInput;
			}
		}
	}

	public void displayGrades() {

		System.out.println("Displaying " + gradeCount + " grades.");
		System.out.println(aCount + " A(s)");
		System.out.println(bCount + " B(s)");
		System.out.println(cCount + " C(s)");
		System.out.println(dCount + " D(s)");
		System.out.println(eCount + " Fails");
		System.out.println("");

		double avgGrade = (double) totalGrades / gradeCount;
		System.out.printf("Avg Grade %.2f", avgGrade);
	}
}
