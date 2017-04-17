package com.github.coppco;

public class Demo3_ThreadMothed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				this.setName("哈哈");
				System.out.println(this.getName());
				System.out.println(Thread.currentThread());
			}
		}.start();
		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println(this.getName());
				System.out.println(Thread.currentThread());
			}
		};
		t2.setName("匿名内部类");
		t2.start();
	}

}
