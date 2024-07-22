package jb02.part02;

public class ForTest {
    public static void main(String[] args) {
        int j = 5;
        System.out.println(j + "단을 출력합니다.");

        for (int i = 0; i < 10; i++){
            System.out.println(j + " * " + i + " = " + j * i);
        }

//        //반복문 for/while 사용과 차이점 이해
//        int k = 1;
//        while (k < 10){
//            System.out.println("5 * " + k + " = " + 5 * k);
//            k++;
//        }
//        System.out.println("i의 최종변경 값: "+ i);
//        System.out.println("k의 최종변경 값: "+ k);

        // 무한 루프와 무한루프 후단의 실행문에서 컴파일 에러를 이해하면
        for ( ; ; ) {
            System.out.println("여기는 반복문 내부의 무한 루프");
        }
        // 아래의 주석을 풀면 컴파일 에러 발생
//        System.out.println("error가 발생한다. 이유는 ....");
    }
}