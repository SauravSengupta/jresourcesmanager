package com.gemserk.resources.progress.tasks;


public class SimulateLoadingTimeRunnable implements Runnable {

	int time;

	public int getTime() {
		return time;
	}

	public SimulateLoadingTimeRunnable(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}