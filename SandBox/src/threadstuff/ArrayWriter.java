package threadstuff;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayWriter implements Runnable {

	private final SimpleArray sharedSimpleArray;
	private final int startValue;

	public ArrayWriter(int startValue, SimpleArray simpleArray) {
		this.startValue = startValue;
		sharedSimpleArray = simpleArray;
	}

	@Override
	public void run() {
		for (int i = startValue; i < startValue + 3; i++) {
			sharedSimpleArray.add(i);
		}

	}

	public static void main(String[] args) {
		
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(writer1);
		threadExecutor.execute(writer2);
		threadExecutor.shutdown();
		
		try {
			boolean tasksEnded = threadExecutor.awaitTermination(1, TimeUnit.MINUTES);
			
			if (tasksEnded) {
				System.out.println(sharedSimpleArray);
			}
			else {
				System.out.println("Timed out while waiting for tasks to finish");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class SimpleArray {
	private final int[] array;
	private int writeIndex = 0;
	private final static Random generator = new Random();

	public SimpleArray(int size) {
		array = new int[size];
	}

	public void add(int value) {
		int position = writeIndex;

		try {
			Thread.sleep(generator.nextInt(500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		array[position] = value;
		System.out.printf("%s wrote %2d to element %d\n", Thread
				.currentThread().getName(), value, position);

		++writeIndex;
		System.out.printf("Next write index %d\n", writeIndex);
	}

	@Override
	public String toString() {
		return "\n Contents of array \n " + Arrays.toString(array);
	}

}
