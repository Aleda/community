package cn.aleda.java.test;

public class ThreadTwo extends Thread {

	public void run() {
		SynchronizedTest.subCount();
	}
}