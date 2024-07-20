package jb01.part04;

/*
    FileName: PrimitiveTest.java

    1. Java에서 제공되는 8EA의 Primitive Data type의 이해
    2. Variable declaration(변수선언)과 Variable Assignment(값의 대입)
 */

public class PrimitiveTest
{
    //main method
    public static void main (String[] args)
    {
        //논리형
        boolean boo = true;
        
        //문자형
        char c = '홍';

        //정수형
        byte b = 127;
        //범위를 넘어서는 수를 담을 경우 문제(?) 발생 //=> compile error 발생(확인요망)
        //byte b1 = 128;

        short s = 1000;
        int i = 1000;
        long l = 1000; // <== long의 경우 000l 또는 000L로 int와 구별

        //실수형
        float f = 1000.5F; // <== float의 경우 000F 또는 000f로 double과 구별
        double d = 1000.5;

        // print()와 println()의 차이점 <== 실행결과를 확인할 것
        System.out.print("자바의 Primitive Data type을 ++");
        System.out.println("::사용하여 표준 출력 장치로 ,,," + ":: 출력");

        // + 연산자의 의미 (문자와 +연산자가 사용되면 append)
        System.out.println("논리형: " + boo);
        System.out.println("문자형: " + c);
        System.out.println("정수형 byte: " + b);
        System.out.println("정수형 short: " + s);
        System.out.println("정수형 int :" + i);
        System.out.println("정수형 long: " + l);
        System.out.println("실수형 float: " + f);
        System.out.println("실수형 double : " + d);

    } //end of main

} //end of class