package jb02.part02;

public class WhileTest {
    public static void main(String[] args) {
        int i = 0;
        //while (0) {
        while (i < 10) {
            System.out.println("여기는 while문 내부 안임 i = " + i);
            i++;
        }

        int j = 0;
        do {
            System.out.println("\n\t 여기는 do문 내부임 j = " + j);
            j++;
        } while(j < 1);

        System.out.println("\n===================================\n");

        int k = 1;
        while (k < 10) {
            System.out.println("5 * i" + k + " = " + 5 * k);
            k++;
        }

//        while (true) {
//            System.out.println("여기는 반복문 내부의 무한 루프");
//        }

//        System.out.println("error가 발생한다. 이유는 ......");
        // 위 부분 주석 풀면 컴파일 에러 발생
    }
}