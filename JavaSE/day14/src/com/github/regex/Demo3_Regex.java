package com.github.regex;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3_Regex {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		//match();
		
		
		//split();
		
		//replace();
		
//		group1();
		
//		replace11();
		
//		pipeizifuchuan();
		
//		round();
		
		
//		system();
		
//		BidDecimal();
		
		/*Date date = new Date();
		System.out.println(date);*/
		
//		format();
		
//		simpleFormat();
		
//		calendar();
		
		//�������, �ж������껹��ƽ��
		System.out.println("���������");
		Scanner scanner = new Scanner(System.in);
		while(!scanner.hasNextInt()) {
			System.out.println("�����ʽ����, ����������:");
			scanner.next();
		}
		int year = scanner.nextInt();
		Calendar ca = Calendar.getInstance();
		ca.set(year, 2, 1);
		ca.add(Calendar.DATE, -1);
		int day = ca.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	}

	public static void calendar() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		calendar.add(Calendar.YEAR, 1);
		System.out.println(calendar.get(Calendar.YEAR));
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(2020, 6, 1);
		System.out.println(calendar.get(Calendar.YEAR));
	}

	public static void simpleFormat() throws ParseException {
		long today = new Date().getTime(); //����
		String birthday = "1988-08-03 08:33:51";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long bir = format.parse(birthday).getTime();
		
		long time = (today - bir) / 1000 / 3600 / 24 / 365;
		System.out.println(time);
	}

	public static void format() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date());
		
		Date date = format.parse("2015-09-09 12:22:55");
		
		System.out.println(dateStr);
	}

	public static void BidDecimal() {
		BigDecimal bd1 = new BigDecimal(2.0);
		BigDecimal bd2 = new BigDecimal(1.1);
		System.out.println(bd1.subtract(bd2));
		
		BigDecimal bd3 = new BigDecimal("2.0");
		BigDecimal bd4 = new BigDecimal("1.1");
		System.out.println(bd3.subtract(bd4));
		
		BigDecimal bd5 = BigDecimal.valueOf(2.0);
		BigDecimal bd6 = BigDecimal.valueOf(1.1);
		System.out.println(bd5.subtract(bd6));
		
		System.out.println(2.0-1.1);
	}

	public static void system() {
		//��������������
		//System.gc();
		
		//System.exit(-1);
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.println("*");
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}

	public static void round() {
		int a = Math.round(12.345f * 100);
		float f = (float) (a / 100.0);
		System.out.println(f);
	}

	public static void pipeizifuchuan() {
		String s1 = "�ҵ�������coppco, ��github����ʹ��hexo + node.js���һ������.";
		Pattern pattern = Pattern.compile("[a-zA-Z]+\\.?[a-zA-Z]+");
		Matcher matcher = pattern.matcher(s1);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	public static void replace11() {
		String s3 = "��...��.��.....��...����...��....��...��..��.��....��...��..��....��....��..��";
		String s4 = s3.replaceAll("\\.", "");
		System.out.println(s4);
		String s5 = s4.replaceAll("(.)\\1+", "$1");
		System.out.println(s5);
	}

	public static void group1() {
		//���ʹ��
		String str = "adfffkdllldfgggeeedksljfdsfjsdl";
		String[] arr = str.split("(.)\\1+");//��������������ͬ���ַ�
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr.length);
	}

	public static void replace() {
		String s1 = "������11co2ppco1�Ĳ���!";
		String s2 = s1.replaceAll("\\d", "");
		System.out.println(s2);
	}

	public static void split() {
		String[] arr = "����.�Ǻ�.�ٺ�.����".split("\\.");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void match() {
		String regex= "[abc]?";
		System.out.println("".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
	}

} 
