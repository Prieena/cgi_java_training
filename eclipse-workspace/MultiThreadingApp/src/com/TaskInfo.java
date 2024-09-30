package com;
class Task implements Runnable {
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t);
	}
}
public class TaskInfo {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t);
	Task t1 = new Task();	
	Thread obj1 = new Thread(t1);
	Thread obj2 = new Thread(t1);
	Thread obj3 = new Thread(t1);
	Thread obj4 = new Thread(t1);
	obj1.start();
	obj2.start();
	obj3.start();
	obj4.start();
	}

}