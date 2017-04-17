package com.github.coppco;

public class Demo5_syn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Í¬²½´úÂë¿é
		new Thread() {
			public void run() {
				Printer.p1();
			}
		}.start();
		
		new Thread() {
			public void run() {
				Printer.p2();
			}
		}.start();

	}

}

class Printer {
	static void p1() {
		synchronized (Printer.class) {
			for (int i = 0; i < 10; i++) {
				System.out.println(i + "a");
			}
		}
	}

	synchronized static void p2() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "b");
		}
	}
	
}
