package com.githut.coppco;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2_Timer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(new Date());
			}
		}, 1, 1000);
		
		
	}

}
