package ArrayTests;

import java.util.Random;

public class RollDie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// setup our random number generator.
		Random randomDie = new Random();

		int[] freq = new int[6];

		for (int roll = 1; roll < 10000000; roll++) {

			++freq[randomDie.nextInt(6)];

		}

		for (int face = 0; face < freq.length; face++) {
			System.out.println((face + 1) + " " + freq[face]);
		}

	}
}
