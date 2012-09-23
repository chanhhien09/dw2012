package com.example.projectstyle;

public class MainThread extends Thread {
	private MainGamePanel gamePanel;
	
	private boolean running;
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public MainThread(MainGamePanel mainGamePanel) {
		super();
		this.gamePanel = mainGamePanel;
	}
	
	@Override
	public void run() {
		while (running) {
			gamePanel.update();
			this.gamePanel.postInvalidate();
		}
	}

}
