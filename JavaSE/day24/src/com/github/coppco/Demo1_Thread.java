package com.github.coppco;

public class Demo1_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 //方式1
		 FirstThread thread1 = new FirstThread();
		thread1.start();
		
		//方式2
		Thread thread2 = new Thread(new TwoThread());
		thread2.start();
	}

}

//方式一
class FirstThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("2");
			System.out.println(getName());
		}
	}
}
//方式二
class TwoThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("1");
		}
	}	
}