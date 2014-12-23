package generics;

public class GenericMethodTest {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 9.0, 10.2, 6.7, 7.8, 8.0 };
		Character[] charArray = { 'a', 'b', 'c', 'd', 'e' };

		printArray(intArray);
		printArray(doubleArray);
		printArray(charArray);
	}

	static <T> void printArray(T[] inputArray) {

		for (T element : inputArray) {
			System.out.println(element);
		}

	}
}
