package jb05.part09;

/*
 	FileName : NullTest.java 
 	
 		1. Garbage Collection 이해
			ㅇ null 의미를 이해
			ㅇ garbage  
			ㅇ garbage collector : 
			ㅇ garbage collecting
			ㅇ garbage collection
		2. Field ( Member Variable) 과 Local Variable 초기화 이해 
*/
public class NullTest{
	
	///Field
	private int number;
	
	///Constructor
	public NullTest(){
	}
	
	///Method
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	///Main Method
	public static void main(String[] args){
		//==> localVariable 초기화
		//==> 아래의 주석을 번갈아 풀어보고 컴파일시 에러를 확인하자. 
		int i = 0;
		//int i;
		System.out.println(" i : "+i);
		
		System.out.println("=================");
		// 객체의 선언만 한 단계(null로 초기화함.)
		NullTest nt = null;
		System.out.println("nt : "+nt);
		
		//값의 대입 단계 
		nt = new NullTest();
		System.out.println("nt : "+nt);
		System.out.println("nt.getNumber() : "+nt.getNumber());
		
		//참조값을 끊는 단계	
		nt = null;
		System.out.println("nt : "+nt);
		System.out.println("nt.getNumber() : "+nt.getNumber());
	}//end of main
	
}//end of class