package threadstuff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintTask implements Runnable {

	private final static Random sleepTimeGen = new Random();
	private String taskName;

	public PrintTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sleepTime = sleepTimeGen.nextInt(30000);
		System.out.println("Called thread " + taskName + " and sleeping for "
				+ sleepTime + "ms");

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + taskName + " all done");
	}

	public static void main(String[] args) {

		int numOfThreads = 75;

		for (int i = 0; i < numOfThreads; i++) {
			PrintTask pt = new PrintTask("Task" + Integer.toString(i));
			ExecutorService threadExecutor = Executors.newCachedThreadPool();
			threadExecutor.execute(pt);
			
			//do not accept any new tasks and also shuts downs previously started threads
			//in an orderly fashion
			threadExecutor.shutdown();
		}
	}

}
