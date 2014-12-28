package threadstuff.blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {

	public static void main(String[] args) {
		BlockingBuffer bb = new BlockingBuffer();

		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.println("------\t\t-----\t---------------\t---------------\n");
		
		Producer producer = new Producer(bb);
		Consumer consumer = new Consumer(bb);
		
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(producer);
		threadExecutor.execute(consumer);
		
		threadExecutor.shutdown();
	}

}
