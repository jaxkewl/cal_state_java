package GradeBook;

public class GradeBookTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GradeBook gradeBook = new GradeBook();
		gradeBook.determineAvgGrade();
		double avgScore = gradeBook.getAvgScore();

		System.out.printf("%s %.2f\n", "Avg Score is ", avgScore);

		int number1 = 255;
		String toBinary = Integer.toBinaryString(number1);
		
		int number2 = 255;
		String toBinary2 = Integer.toBinaryString(number2);

		System.out.println(number1 + " to binary is " + toBinary);
		System.out.println(number2 + " to binary is " + toBinary2);
		
		
	}

}
