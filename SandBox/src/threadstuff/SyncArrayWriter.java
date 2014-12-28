package threadstuff;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SyncArrayWriter implements Runnable {

	private final SyncSimpleArray sharedSimpleArray;
	private final int startValue;

	public SyncArrayWriter(int startValue, SyncSimpleArray simpleArray) {
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
		
		SyncSimpleArray sharedSimpleArray = new SyncSimpleArray(6);
		
		SyncArrayWriter writer1 = new SyncArrayWriter(1, sharedSimpleArray);
		SyncArrayWriter writer2 = new SyncArrayWriter(11, sharedSimpleArray);
		
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(writer1);
		threadExecutor.execute(writer2);
		threadExecutor.shutdown();
		
		try {
			boolean tasksEnded = threadExecutor.awaitTermination(50, TimeUnit.SECONDS);
			
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

class SyncSimpleArray {
	private final int[] array;
	private int writeIndex = 0;
	private final static Random generator = new Random();

	public SyncSimpleArray(int size) {
		array = new int[size];
	State threadState = Thread.currentThread().getState();
	threadState.
	}

	public synchronized void add(int value) {
		
		int position = writeIndex;

		try {
			int sleepTime = generator.nextInt(10000);
			System.out.println("Sleeping for " + sleepTime);
			Thread.sleep(sleepTime);
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
