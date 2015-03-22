package cn.aleda.spring.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class testforfile {
	private static String[] deletes = {"配置清单.txt", "网络课程设计.zip"};
	public static void main(String[] args) {
		String uploadPath = "F:\\usersfile";
		String path = uploadPath + "\\" + "monique\\" + "images";
		System.out.println(path);
		File[] files = new File(path).listFiles();
		for (File file: files) {
			System.out.println("filename = " + file.getPath());
		}
		System.out.println("end???");
//		确实这种方可行啊，呵呵！
	}
}
