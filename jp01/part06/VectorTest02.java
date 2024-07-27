package jp01.part06;

import java.util.*;

public class VectorTest02 extends Vector {

    public VectorTest02() {
        super();
    }

    public VectorTest02(int initalCapacity, int capacityIncrement) {
        super(initalCapacity, capacityIncrement);
    }

    public void pringString (Vector vector) {
//        for (int i = 0; i < vector.size(); i++) {
//            System.out.println((String)vector.elementAt(i));
//        }
        for (Object object : vector) {
            System.out.println((String)object);
        }
    }

    public static void main(String[] args) {
        VectorTest02 vectorTest = new VectorTest02(10, 10);

        String s1 = new String("홍");
        vectorTest.add(s1);
        vectorTest.add(new String("2.동"));
        vectorTest.add("3.님 안녕하세요");

        vectorTest.pringString(vectorTest);

        System.out.println("\n ==> API 확인 ");
        vectorTest.insertElementAt("4.길", 1);
        vectorTest.pringString(vectorTest);


        System.out.println("\n ==> API 확인");
        vectorTest.setElementAt("5.,홍길순", 3);
        vectorTest.pringString(vectorTest);

        System.out.println("\n ==> API 확인");
        vectorTest.removeElementAt(3);
        vectorTest.pringString(vectorTest);
    }
}