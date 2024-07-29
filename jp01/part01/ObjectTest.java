package jp01.part01;

/*
   FileName : ObjectTest.java
   
     1.  equals() method  이해
     2.  equals() Method  필요성 
      ㅇ instance 비교(식별성비교) ==> false
      ㅇ 상태를 비교하고 싶다면 ==> 이름(일정상태)이 동일한 경우 true 를 놓고 싶은경우는
     3. equeals(Object obj) ==> 인자로 Object Data Type  받는다는 의미는 ?
                                                       ( Object obj = new JavaAllClass() 을 다시한번 생각)  
     3. ObjectTest.java를 통해...
         : Method OverRidng, this, 묵시적, 명시적, 다형성등 OOP와 OOPL의 문법 확인
*/
class B{
	
    ///Field
    int no;
    String name;
    
    ///Constructor
    public B(){
    }
    public B(int no,String name){
      this.no = no;
      this.name = name;
    }
    
    ///method
	public String toString(){		
      return "no : "+no+" name : " +name+" 인 A class 입니다.";
    }

	//아래의 주석을 처리하고, 주석을 풀고 결과를 확인
	//==> equals(Object obj)의 의미를 다시한번 생각
	/*
	public boolean equals(Object obj){
		boolean equal = ( this.no == ( (B)obj ).no );
		return equal;
	}
	*/
}//end of class


public class ObjectTest{
	
	///main method
	public static void main(String[] args){
		B b1 = new B(1,"홍길동");
		B b2 = new B(1,"홍길동");

        //equals / ==의 의미이해
        System.out.println("b1,b2는 같은 객체 인가");
		System.out.println("b1==b2() : "+ (b1==b2));
        System.out.println("b1,b2는 같은 equals한 인가");
		System.out.println("b1.equals(b2) : "+b1.equals(b2));
		
		System.out.println("========================");

        //참조값을 같게하자.
		b1 = b2;
        System.out.println("b1,b2는 같은 객체 인가");
		System.out.println("b1==b2() : "+ (b1==b2));
        System.out.println("b1,b2는 같은 equals한 인가");
		System.out.println("b1.equals(b2) : "+b1.equals(b2));
	}//end of main
	
}//end of class