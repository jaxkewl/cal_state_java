package threadstuff.manualsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManualBufferSyncTest {

	public static void main(String[] args) {
		SynchronizedBuffer sb = new SynchronizedBuffer();

		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.println("------\t\t-----\t---------------\t---------------\n");
		
		Producer producer = new Producer(sb);
		Consumer consumer = new Consumer(sb);
		
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(producer);
		threadExecutor.execute(consumer);
		
		threadExecutor.shutdown();
	}

}
