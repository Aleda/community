package cn.aleda.java.test;

public class SynchronizedTest {
	
	public static int count = 0;
	
	public synchronized static void addCount() {
		count += 100;
	}
	public synchronized static void subCount() {
		count -= 100;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new ThreadOne().start();
			new ThreadTwo().start();
		}
		try {
			Thread.sleep(2000);
			System.out.println("count = " + count);
		} catch(Exception e) {
			
		}
	}
}
