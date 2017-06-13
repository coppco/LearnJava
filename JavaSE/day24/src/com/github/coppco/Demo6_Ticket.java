package com.github.coppco;

public class Demo6_Ticket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}

}

class Ticket extends Thread {
	private static int total = 100;

	public void run() {
		while (true) {
			synchronized (Ticket.class) {
				if (total > 0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					System.out.println("���ǵ�" + total-- + "��Ʊ");
				} else {
					System.out.println("Ʊ������!");
					break;
				}
			}
		}
	}
}