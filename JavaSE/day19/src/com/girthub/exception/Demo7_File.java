package com.girthub.exception;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo7_File {

	/**
	 * public String getAbsolutePath()：获取绝对路径
	 * public String getPath():获取路径
	 * public String getName():获取名称 
	 * public long length():获取长度。字节数 
	 * public long lastModified():获取最后一次的修改时间，毫秒值 
	 * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组 
	 * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		
		
//demo2();
		
		File dir = new File("E:\\");
		File[] subFile = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir, name);
				return file.isFile() && file.getName().endsWith(".exe");
			}
		});
		
		for (File file : subFile) {
			System.out.println(file);
		}
	}

	public static void demo2() {
		//		File dir = new File("E:\\");
				/*for (String string : dir.list()) {
					if (string.endsWith(".exe")) {
						System.out.println(string);
					}
				}*/
				
				File dir = new File("E:\\");
				for (File file : dir.listFiles()) {
					if (file.isFile() && file.getName().endsWith(".exe")) {
						System.out.println(file);
					}
				}
	}

	public static void demo1() throws IOException {
		File file  = new File("zzz.txt");
		file.createNewFile();
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println(file.length());
		
		long timeinve = file.lastModified();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
		String date = format.format(new Date(timeinve));
		System.out.println(date);
		
	}

}
