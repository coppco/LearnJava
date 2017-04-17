package com.girthub.exception;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo7_File {

	/**
	 * public String getAbsolutePath()����ȡ����·��
	 * public String getPath():��ȡ·��
	 * public String getName():��ȡ���� 
	 * public long length():��ȡ���ȡ��ֽ��� 
	 * public long lastModified():��ȡ���һ�ε��޸�ʱ�䣬����ֵ 
	 * public String[] list():��ȡָ��Ŀ¼�µ������ļ������ļ��е��������� 
	 * public File[] listFiles():��ȡָ��Ŀ¼�µ������ļ������ļ��е�File����
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
