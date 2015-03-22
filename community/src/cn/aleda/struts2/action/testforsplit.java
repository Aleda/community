package cn.aleda.struts2.action;

public class testforsplit {
	public static void main(String[] args) {
		String names = "come on, qusiba, jiubuqusi, ";
		String[] array = names.split(", ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("name = " + array[i]);
		}
		System.out.println("wojuede  w keyi~!");
	}
}
