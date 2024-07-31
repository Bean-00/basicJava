package jp01.part03;

/*
	FileName : StringTest01.java
	
	 1. ���ڿ��� Object Modeling �� String Ư¡
	 2. �������� �����ϰ�,  ������ ����� �´��� Ȯ��
	 3. �ν��Ͻ� �񱳽� == �� equals() Method �ٽ� ���� 
*/

public class  StringTest01{
    
	///main method
	public static void main(String[] args)	{
		
		String s1 = "ȫ�浿";
		String s2 = "ȫ�浿";
		String s3 = new String("ȫ�浿");
		String s4 = new String("ȫ�浿");
		
		// == ��
		System.out.println("s1==s2 : "+(s1==s2));
		System.out.println("s1==s3 : "+(s1==s3));
		System.out.println("s1==s4 : "+(s1==s4));
		System.out.println("s1==s2 : "+(s2==s3));
		System.out.println("s1==s2 : "+(s2==s4));
		System.out.println("s3==s4 : "+(s3==s4));

		// equals() ��
		System.out.println("s1.equals(s2) : "+s1.equals(s2));
		System.out.println("s1.equals(s3) : "+s1.equals(s3));
		System.out.println("s1.equals(s4) : "+s1.equals(s4));
		System.out.println("s1.equals(s4) : "+s2.equals(s3));
		System.out.println("s1.equals(s4) : "+s2.equals(s4));
		System.out.println("s3.equals(s4) : "+s3.equals(s4));
		
	}//end of main

}//end of class