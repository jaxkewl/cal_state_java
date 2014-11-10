package ArrayTests;

import java.awt.Color;

public class ArrayTest {

	public static void outputArray(int[][] array) {

		for (int row = 0; row < array.length; row++) {

			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + " ");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myArray = new int[2];
		myArray[0] = 45;
		myArray[1] = 100;

		Object[] myArray2 = new Object[2];
		myArray2[0] = "first item";
		myArray2[1] = "second item";

		int[] myArray3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] array2 = { { 1, 2 }, { 3 }, { 4, 5, 6 } };

		System.out.println("Outputting array1");
		outputArray(array1);
		System.out.println("");
		System.out.println("Outputting array2");
		outputArray(array2);

	}

}
