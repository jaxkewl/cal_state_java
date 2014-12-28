package threadstuff.manualsync;

public class SynchronizedBuffer implements Buffer {

	public int buffer = -1;
	private boolean occupied = false; // whether the buffer is occupied.
	
	@Override
	public synchronized void set(int value) throws InterruptedException {
		System.out.println("producer called...");
		
		//while there are no empty locations, place thread in waiting state
		while (occupied) {
			System.out.println("Producer tries to write, buffer full, need to wait");
			wait();
		}

		buffer = value;
		
		occupied = true;
		
		System.out.println("Proucer writes " + value + " and notifying all...");
		
		notifyAll();
	}

	@Override
	public synchronized int get() throws InterruptedException {
		System.out.println("Consumer called...");
		// need to wait until there is something in the buffer
		while (!occupied) {
			System.out.println("Consumer waiting to consume, need to wait");
			wait();
		}
		System.out.println("Consumer consumed and notifying all...");
		occupied = false;
		notifyAll();
		return buffer;
	}

}
