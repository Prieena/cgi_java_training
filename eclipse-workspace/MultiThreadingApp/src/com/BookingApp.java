package com;
class Booking implements Runnable {
	int avl = 1;
	@Override
	public synchronized void run() {
		Thread t= Thread.currentThread();
		String name = t.getName();
		if(avl==1) {
			System.out.println(name+" got the ticket");
			avl=avl-1;
		}else {
			System.out.println("sorry no ticket "+name);
		}
	}
}
public class BookingApp {
	public static void main(String[] args) {
	Booking bb1 = new Booking();		// avl=1
	//Booking bb2 = new Booking();		// avl=1
	//Booking bb3 = new Booking();		// avl=1
	//Booking bb4 = new Booking();		// avl=1
	Thread t1 = new Thread(bb1);
	Thread t2 = new Thread(bb1);
	Thread t3 = new Thread(bb1);
	Thread t4 = new Thread(bb1);
	t1.setName("Ravi");t2.setName("Ajay");t3.setName("Vijay");t4.setName("Leena");
	t1.start(); t2.start(); t3.start(); t4.start();
	}

}