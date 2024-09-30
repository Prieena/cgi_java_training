package com;
class Resource implements Runnable {
	@Override
	public synchronized void run() {
		
	String name = Thread.currentThread().getName();
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(500);
				System.out.println(name+" "+i);
				if(name.equals("Ravi") && i==5) {
					wait();
					
				}
				if(name.equals("Raju") && i==8) {
					notify();
					wait();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
public class WaitAndNotifyExample {
	public static void main(String[] args) throws Exception{
	Resource res = new Resource();
	System.out.println("Game going to Start");
	Thread.sleep(1000);
	System.out.println("1...");
	Thread.sleep(1000);
	System.out.println("2....");
	Thread.sleep(1000);
	System.out.println("3....");
	Thread.sleep(1000);
	System.out.println("Game Start");
	Thread t1 = new Thread(res,"Ravi");
	Thread t2 = new Thread(res,"Raju");
	Thread t3 = new Thread(res,"Ramesh");
	t1.start();
	t2.start();
	t3.start();
	t3.join();
	System.out.println("Game End..");
	}

}