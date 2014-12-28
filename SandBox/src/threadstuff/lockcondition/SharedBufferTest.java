package threadstuff.lockcondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {

	public static void main(String[] args) {
		SynchronizedBuffer uBuffer = new SynchronizedBuffer();

		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.println("------\t\t-----\t---------------\t---------------\n");
		
		Producer producer = new Producer(uBuffer);
		Consumer consumer = new Consumer(uBuffer);
		
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(producer);
		threadExecutor.execute(consumer);
		
		threadExecutor.shutdown();
	}

}
