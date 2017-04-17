package com.github.coppco;

public class Demo2_ThreadClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println(1);
				}
			}
		}.start();
		
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println(2);
				}
			}
		}).start();
	}

}
