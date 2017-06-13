package com.github.coppco;

public class Demo1_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 //��ʽ1
		 FirstThread thread1 = new FirstThread();
		thread1.start();
		
		//��ʽ2
		Thread thread2 = new Thread(new TwoThread());
		thread2.start();
	}

}

//��ʽһ
class FirstThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("2");
			System.out.println(getName());
		}
	}
}
//��ʽ��
class TwoThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("1");
		}
	}	
}