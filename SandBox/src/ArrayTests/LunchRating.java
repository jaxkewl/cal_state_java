package ArrayTests;

import java.util.function.IntPredicate;

public class LunchRating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] rating = { 5, 4, 5, 4, 3, 2, 4, 5, 4, 3, 2, 4, 2, 1, 2, 3, 4, 5,
				5, 0, 7 };

		int[] freq = new int[5];

		for (int i = 0; i < rating.length; i++) {

			try {
				System.out.println("student #" + (i + 1) + " gave a rating of "
						+ rating[i]);
				++freq[--rating[i]];

			} catch (Exception exc) {
				System.out.println("Rating needs to between scale 1-5");

			}
		}

		System.out.println("\nSummary: ");
		for (int i = 0; i < freq.length; i++) {
			System.out.println((i + 1) + " " + freq[i]);

		}

	}
}
