package com.github.coppco;

public class Demo4_Syn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 20; i++) {
						System.out.println(i + "a");
					}
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 20; i++) {
						System.out.println(i + "b");
					}
					
				}
			}
		};

			t1.start();

			t2.start();
		
		
	}

}