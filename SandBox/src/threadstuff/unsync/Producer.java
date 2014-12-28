package threadstuff.unsync;

import java.util.Random;

public class Producer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;

	public Producer(Buffer shared) {
		sharedLocation = shared;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int count = 1; count <= 10; count++) {
			int sleepTime = generator.nextInt(3000);
			//System.out.println("Producer sleeping for " + sleepTime);
			try {
				Thread.sleep(sleepTime);
				sharedLocation.set(count);
				sum += count;
				System.out.printf("\t%2d\n", sum);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Producer done producing\n");
	}

}
