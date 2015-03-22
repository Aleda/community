package cn.aleda.java.test;

public class ThreadOne extends Thread {

	public void run() {
		SynchronizedTest.addCount();
	}
}
