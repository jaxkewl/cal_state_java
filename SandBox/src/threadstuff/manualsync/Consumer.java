package threadstuff.manualsync;

import java.util.Random;

public class Consumer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;

	public Consumer(Buffer shared) {
		sharedLocation = shared;

	}

	@Override
	public void run() {

		int sum = 0;

		for (int count = 1; count <= 10; count++) {
			int sleepTime = generator.nextInt(4000);
			//System.out.println("Consumer sleeping for " + sleepTime);
			try {
				Thread.sleep(sleepTime);
				sum += sharedLocation.get();
				//System.out.printf("\t\t\t%2d\n", sum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.printf("\n%s %d\n%s\n", "Consumer read values totaling",
				sum, "Terminating Consumer");
	}

}
