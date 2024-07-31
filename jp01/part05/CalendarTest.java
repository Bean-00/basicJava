//package jp01.part05;

/*
*	FileName : CalendarTest.java  
*
*     1. �ð��� ��¥�� ��ü�𵨸��� java.util.Calendar 
*     2. �ð��� ��¥�� ��ü������ java.util.Data�� Ȯ���Ͽ� deprecation �ǹ� Ȯ��
*     3.  static �� Ȱ��
*     4.  wrapper class ���
*     5.  java.lang package �̿� �ٸ� package ���
*/
import java.util.*;

public class CalendarTest{
	
	///Main method
	public static void main(String args[])	{
		
		////==> Calendar instance ���� (Calendar.class�� abstract class �� �ν��Ͻ� �Ұ�.)
		//==>1. ��ü���� �� �� ���ٸ� Calendar.class�� ��� ����� ���ΰ�.. (static Method Ȱ��)
		Calendar cld = Calendar.getInstance();

		//==> 2. �ٸ� �����... ( Generalization / ~ is a ~ / ������ ����ȯ / Hierarchy ����..)
		//Calendar cld = new GregorianCalendar();

		// static  Ȱ�� : �� ���� static Field  API���� Ȯ��
		System.out.println("�� : "+cld.get(Calendar.YEAR));
		System.out.println("�� : "+cld.get(Calendar.MONTH));
		System.out.println("�� : "+cld.get(Calendar.DATE));
		System.out.println(cld.get(Calendar.YEAR)+"����: "+
				                                                           cld.get(Calendar.WEEK_OF_YEAR)+"��°��");
		System.out.println(cld.get(Calendar.YEAR)+"����: "+
                                                                           cld.get(Calendar.WEEK_OF_MONTH)+"��°��");
		System.out.println("�̹����� : "+cld.get(Calendar.DAY_OF_MONTH)+"��°��");
		System.out.println(cld.get(Calendar.YEAR)+"����: "+
                                                                          cld.get(Calendar.DAY_OF_YEAR)+"��°��");
		System.out.println("�̹����� : "+cld.get(Calendar.DAY_OF_WEEK)+"��°��");
		System.out.println("����,���� : "+cld.get(Calendar.AM_PM));
		System.out.println("�ð� : "+cld.get(Calendar.HOUR));
		System.out.println("24�ð� : "+cld.get(Calendar.HOUR_OF_DAY));
		System.out.println("�� : "+cld.get(Calendar.MINUTE));
		System.out.println("�� : "+cld.get(Calendar.SECOND));
		System.out.println("�и��� : "+cld.get(Calendar.MILLISECOND));

		// wrapper class  ���� �� ���
		// equals(Object obj) ==> ���ڸ� Object �� �޴´ٴ� �ǹ̴�...
		// java �� ��� class �� equals Method �� ���ڷ� ���� �� �� ������
		// ���ڷ� ���޵ɼ� ���� 8EA�� Data Type �� �ִ�(Primitive Data Type)
		//==> Primitive Data �� Reference Data �� ����Ҽ� �ְ� �Ѵ�.
		int i = 100;
		Integer integer = new Integer(i);  
		System.out.println(" 1 : "+integer.toString());
		System.out.println(" 2 : "+integer.intValue());
		System.out.println(" 3 : "+integer.doubleValue());
	}//end of main
}//end of class