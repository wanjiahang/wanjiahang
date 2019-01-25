package com.wh.www.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil{
	public static void main(String[] s){
		//�����ǲ��Դ���
		test("20099-1-1");
		test("20099-100-1");
		test("20099-1-100");
		test("2009-1-1");
		test("2009-1-31");
		test("2009-2-28");
		test("2009-2-29");
		test("2008-2-29");
		}
	
	private static void test(String stringdate){
		System.out.println("����[" + stringdate + "]�Ƿ�Ϸ�:" + validate(stringdate));
		}
		//���Դ��� end
		//==
		/** �ж������� */
		public static boolean validate(String dateString){
		//ʹ��������ʽ ���� �ַ� ���� dddd-dd-dd �ĸ�ʽ(d��ʾ����)
		Pattern p = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");
		Matcher m = p.matcher(dateString);
		if(!m.matches()){	return false;}
		//�õ�������
		String[] array = dateString.split("-");
		int year = Integer.valueOf(array[0]);
		int month = Integer.valueOf(array[1]);
		int day = Integer.valueOf(array[2]);
		if(month<1 || month>12){	return false;}
		int[] monthLengths = new int[]{0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(isLeapYear(year)){
		monthLengths[2] = 29;
		}else{
		monthLengths[2] = 28;
		}
		int monthLength = monthLengths[month];
		if(day<1 || day>monthLength){
		return false;
		}
		return true;
		}

		private static boolean isLeapYear(int year) {
			return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ;
		}
}
