package jp01.part07;

import java.util.*;

public class ArrayListTest03 {

    public static void main(String[] args) {

        ArrayList<String> arrayList= new ArrayList<String>(10);

        String s1 = new String("홍");
        arrayList.add(s1);
        arrayList.add(new String("2.길"));
        arrayList.add("3.님 안녕하세요");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("\nJDK 1.5 추가기능 :: Generic, Enhanced For Loop 사용");

        for (String value : arrayList) {
            System.out.println(value);
        }

        System.out.println("\n ==> API 확인 ");
        arrayList.add("4.길");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("\n ==> API 확인");
        arrayList.set(3, "5.,홍길순");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("\n ==> API 확인");
        arrayList.remove(3);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}