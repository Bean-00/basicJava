//package jp02.part03;

import java.io.*;

/*
*  FileName : Finallytest.java
*  
*	1.  try-catch-finally   �ǹ� 
*	2.  ���� catch ���� ���� : ���� catch  ��� Hierarchy ������ �Ϻ��� catch ��� ó��
*	3.  RuntimeException(Unchecked) / �׿� Exception( Checked ) �� ������ ���� 
*	  �� RuntimeExcetpion ����: �����Ͻ� check ���� �ʴ´�.	==> UnChecked Exception
*     �� �׿� Exception : �����Ͻ� check, Compile Error  		==> Checked Exception
*/
public class FinallyTest{

	///Field
	private char[] c = new char[1024];
	private FileReader fileReader;

	///Constructor
	public FinallyTest(){
	}
	public FinallyTest(String fileName){
		this.fileRead(fileName); 
	}

	///method
	//1. ���� catch ���� ���� ==> ���� catch �� ���� ���� Exception  ���� ó��
	//2. finally  ����           	 ==> Exception �߻������� ������� ������ ����
	public void fileRead(String str){
		try{
			fileReader = new FileReader(str); 
			fileReader.read(c,0,1024);          
		}catch(FileNotFoundException e1){
			System.out.println("e1 : "+e1);
			System.out.println(str+" : File�� �����ϴ�.");
		}catch(IOException e2){
			System.out.println("e2 : "+e2);
			System.out.println("read() method���� Exception �߻�");
		}catch(Exception e3){
			System.out.println("e3 : "+e3);
			System.out.println("��� Exception �� ���� �����.");
		}finally{
			System.out.println("����� fileRead() :: Exception�� �߻��ϴ� ���� ���� ����");
		}
	}
	
}//end of class